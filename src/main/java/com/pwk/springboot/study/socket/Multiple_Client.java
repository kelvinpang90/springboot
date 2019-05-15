package com.pwk.springboot.study.socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Multiple_Client extends Application {
    private DataInputStream input ;
    private DataOutputStream output;
    @Override
    public void start(Stage stage){
        TextArea area = new TextArea();
        Scene scene = new Scene(new ScrollPane(area));
        stage.setTitle("Multiple Server");
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                area.appendText("Server started at "+ LocalDateTime.now()+"\n");
                while (true){
                    Socket socket = serverSocket.accept();

                    Platform.runLater(() -> {
                        InetAddress inetAddress = socket.getInetAddress();
                        area.appendText(inetAddress.getHostName()+" "+inetAddress.getHostAddress()+"\n");
                    });
                    new Thread(() -> {
                        try {
                            input = new DataInputStream(socket.getInputStream());
                            output = new DataOutputStream(socket.getOutputStream());

                            while (true){
                                double radius = input.readDouble();
                                double acreage = radius*radius*Math.PI;
                                output.writeDouble(acreage);

                                Platform.runLater(() -> {
                                    area.appendText("radius ("+radius+")"+",acreage ("+acreage+")\n");
                                });
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
