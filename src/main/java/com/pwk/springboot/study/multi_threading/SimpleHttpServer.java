package com.pwk.springboot.study.multi_threading;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {


    static String basePath;
    static int port = 8080;
    static ServerSocket serverSocket;

    public static void setPort(int port){
        if(port>0){
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath){
        File file = new File(basePath);
        if(!basePath.isBlank()&&file.exists()&&file.isDirectory())
            SimpleHttpServer.basePath = basePath;
    }

    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept())!=null){

        }
    }

    static class HttpRequestHandler implements Runnable{

        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();

                String filePath = basePath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                out.println("HTTP/1.1 200 OK");
                out.println("Server:Molly");
                if(filePath.endsWith("jpg")||filePath.endsWith("ico")){
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i;
                    while ((i=in.read())!=-1){
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();

                    out.println("Content-Type:image/jpeg");
                    out.println("Content-Length:"+array.length);
                    out.println("");
                    socket.getOutputStream().write(array,0,array.length);
                }else{
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out.println("Content-Type:text/html;charset=UTF-8");
                    out.println("");
                    while ((line = br.readLine())!=null)
                        out.print(line);
                }
                out.flush();
            }catch (Exception e){

            }finally {
                close(br,in,reader,out,socket);
            }
        }
    }

    private static void close(Closeable... closeables){
        if(closeables!=null){
            for(Closeable closeable:closeables){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
