package com.pwk.springboot.study.socket;

import com.pwk.springboot.study.lambda.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketByObjectServer {
    public static void main(String[] args){
        new ObjectServer();
    }
}

class ObjectServer{
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ObjectServer()  {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started...");

            output = new ObjectOutputStream(new FileOutputStream("person.dat",true));

            while (true){
                Socket socket = serverSocket.accept();
                input = new ObjectInputStream(socket.getInputStream());

                Person person = (Person)input.readObject();
                output.writeObject(person);
                System.out.println("person information stored...");


            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                input.close();
                output.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

