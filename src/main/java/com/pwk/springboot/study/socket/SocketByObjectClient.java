package com.pwk.springboot.study.socket;

import com.pwk.springboot.study.lambda.Person;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;

public class SocketByObjectClient extends Application {
    private TextField name = new TextField();
    private ToggleGroup gender = new ToggleGroup();
    private TextField email = new TextField();
    private TextField birthday = new TextField();

    private ToggleButton male = new ToggleButton("male");
    private ToggleButton female = new ToggleButton("female");

    private Button submit = new Button("Submit");

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        pane.add(new Label("Name"),0,0);
        pane.add(name,1,0);

        pane.add(new Label("Gender"),0,1);
        male.setToggleGroup(gender);
        female.setToggleGroup(gender);
        pane.add(male,1,1);
        pane.add(female,2,1);

        pane.add(new Label("Email"),0,2);
        pane.add(email,1,2);
        pane.add(new Label("Birthday"),0,3);
        pane.add(birthday,1,3);
        pane.add(submit,1,4);
        GridPane.setHalignment(submit, HPos.RIGHT);

        pane.setAlignment(Pos.CENTER);

        name.setPrefColumnCount(15);
        email.setPrefColumnCount(15);
        birthday.setPrefColumnCount(15);

        submit.setOnAction(actionEvent -> {
            try {
                Socket socket = new Socket("localHost",8000);

                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                Person p = new Person(name.getText().trim(),(name.getText().trim().equals("male")? Person.SEX.MALE: Person.SEX.FEMALE),email.getText(), LocalDate.now());
                output.writeObject(p);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Person Information");
        stage.show();
    }
}
