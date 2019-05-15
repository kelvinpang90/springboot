package com.pwk.springboot.study.socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClient extends Application {
    DataOutputStream output = null;
    DataInputStream input = null;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane main = new BorderPane();

        BorderPane textPane = new BorderPane();
        textPane.setPadding(new Insets(5,5,5,5));
        textPane.setLeft(new Label("Enter a radius:"));

        TextField field = new TextField();
        field.setAlignment(Pos.BOTTOM_LEFT);
        textPane.setCenter(field);

        TextArea text = new TextArea();
        main.setCenter(new ScrollPane(text));
        main.setTop(textPane);

        Scene scene = new Scene(main);
        stage.setTitle("client");
        stage.setScene(scene);
        stage.show();

        field.setOnAction(actionEvent -> {
            double radius = Double.valueOf(field.getText().trim());
            try {
                output.writeDouble(radius);
                output.flush();
                text.appendText("Radius is "+radius+"\n");
                double area = input.readDouble();
                text.appendText("Area is "+area+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Socket socket = new Socket("localHost",8000);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }
}
