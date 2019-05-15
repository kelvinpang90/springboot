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
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class SocketServer extends Application {
    @Override
    public void start(Stage stage)  {
        TextArea textArea = new TextArea();
        Scene scene = new Scene(new ScrollPane(textArea));
        stage.setTitle("server");
        stage.setScene(scene);
        stage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() -> {
                    textArea.appendText("Server started at "+ LocalDateTime.now()+"\n");
                    try {
                        Socket socket = serverSocket.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                        while (true){
                            double radius = input.readDouble();
                            double area = radius*radius*Math.PI;
                            output.writeDouble(area);

                            Platform.runLater(()->{
                                textArea.appendText("Radius received from client:"+radius+"\n");
                                textArea.appendText("Area is "+area+"\n");
                            });
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
