package com.pwk.springboot.study.socket.TicTacToe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server implements TicTacToeConstants {

    public void main(String[] args){
        new Server();
    }

    public Server() {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                System.out.println("Server started at "+ LocalDateTime.now());
                //ready for players
                while (true){
                    Socket player1 = serverSocket.accept();
                    System.out.println("player1 jointed the game ");
                    new DataOutputStream(player1.getOutputStream()).writeInt(PLAYER1);

                    Socket player2 = serverSocket.accept();
                    System.out.println("player2 jointed the game");
                    new DataOutputStream(player2.getOutputStream()).writeInt(PLAYER2);

                    System.out.println("game started");
                    new Thread(new HandleSession(player1,player2)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    class HandleSession implements Runnable,TicTacToeConstants{
            Socket player1;
            Socket player2;

            private char cell[][] = new char[3][3];
            private DataInputStream fromPlayer1;
            private DataOutputStream toPlayer1;
            private DataInputStream fromPlayer2;
            private DataOutputStream toPlayer2;

        public HandleSession(Socket player1, Socket player2) {
            this.player1 = player1;
            this.player2 = player2;

            for(int i = 0;i<3;i++)
                for(int j = 0;j<3;j++)
                    cell[i][j] = ' ';
        }

        @Override
        public void run(){
            try {
                fromPlayer1 = new DataInputStream(player1.getInputStream());
                toPlayer1 = new DataOutputStream(player1.getOutputStream());
                fromPlayer2 = new DataInputStream(player2.getInputStream());
                toPlayer2 = new DataOutputStream(player2.getOutputStream());

                toPlayer1.writeInt(PLAYER1_BEGIN);

                while (true){
                    //receive player1 move
                    int row = fromPlayer1.readInt();
                    int column = fromPlayer1.readInt();
                    cell[row][column] = 'X';

                    if(isWon('X')){
                        toPlayer1.writeInt(PLAYER1_WON);
                        toPlayer2.writeInt(PLAYER1_WON);
                        sendMove(toPlayer2,row,column);
                        break;
                    }else if(isFull()){
                        toPlayer1.writeInt(DRAW);
                        toPlayer2.writeInt(DRAW);
                        sendMove(toPlayer2,row,column);
                        break;
                    }else{
                        toPlayer2.writeInt(CONTINUE);
                        sendMove(toPlayer2,row,column);
                    }

                    //receive player2 move
                    row = fromPlayer2.readInt();
                    column = fromPlayer2.readInt();
                    cell[row][column] = 'O';

                    if(isWon('O')){
                        toPlayer1.writeInt(PLAYER2_WON);
                        toPlayer2.writeInt(PLAYER2_WON);
                        sendMove(toPlayer1,row,column);
                        break;
                    }else if(isFull()){
                        toPlayer1.writeInt(DRAW);
                        toPlayer2.writeInt(DRAW);
                        sendMove(toPlayer1,row,column);
                        break;
                    }else{
                        toPlayer1.writeInt(CONTINUE);
                        sendMove(toPlayer1,row,column);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendMove(DataOutputStream output,int row,int column) throws IOException{
            output.writeInt(row);
            output.writeInt(column);
        }

        private boolean isFull(){
            for(int i = 0;i<3;i++)
                for(int j = 0;j<3;j++)
                    if(cell[i][j]==' ')
                        return false;
            return true;
        }

        private boolean isWon(char token){
            //check row
            for(int i = 0;i<3;i++) {
                if (cell[i][0] == token && cell[i][1] == token && cell[i][2] == token)
                    return true;
            }
            //check column
            for (int i = 0;i<3;i++){
                if(cell[0][i]==token&&cell[1][i]==token&&cell[2][i]==token)
                    return true;
            }
            //check diagonal
            if(cell[0][0]==token&&cell[1][1]==token&&cell[2][2]==token)
                return true;
            if(cell[0][2]==token&&cell[1][1]==token&&cell[2][0]==token)
                return true;
            return false;
        }

        private boolean isDraw(){
            //check row

            //check column

            //check diagonal
            return false;
        }
    }
}
