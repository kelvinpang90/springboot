package com.pwk.springboot.study;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Channel {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("d:\\log.log");
        Path dir = Paths.get("d:\\abc\\bcd\\cde\\abc.txt");

//        //Channels
//        //read the file by using channel and bytebuffer
//        try(SeekableByteChannel sbc = Files.newByteChannel(dir)){
//            //set the data limit that each buffer can load
//            ByteBuffer buffer = ByteBuffer.allocate(10);
//            String encoding = System.getProperty("file.encoding");
//            int i = 0;
//            while(sbc.read(buffer)>0){
//                i++;
//                //倒带
//                buffer.rewind();
//                System.out.println(Charset.forName(encoding).decode(buffer));
//                System.out.println(i);
//                buffer.flip();
//            }
//        }

        //create and write the file by using channel and bytebuffer
        //below codes have to run under UNIX system
//        Set<OpenOption> options = new HashSet<>();
//        options.add(APPEND);
//        options.add(CREATE);
//
//        //设置文件存取权限
//        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-r-----");
//        //将权限转化为文件属性
//        FileAttribute<Set<PosixFilePermission>> attribute = PosixFilePermissions.asFileAttribute(permissions);
//
//        ByteBuffer buffer = ByteBuffer.wrap(Files.readAllBytes(dir));
//        try(SeekableByteChannel sbc = Files.newByteChannel(Paths.get("d:\\abc\\bcd\\cde\\def.txt"),options,attribute)){
//            sbc.write(buffer);
//        }

        //create temp files and regular files
//        Path temp = Files.createTempFile(Paths.get("d:\\abc\\bcd\\cde\\"),"def",".log");
//        System.out.format("temp file:%s has been created",temp);

        //get system root directory
//        System.out.println(FileSystems.getDefault().getRootDirectories());

        //read&write by channel and buffers
//        String s = "I am here!\n";
//        ByteBuffer buffer = ByteBuffer.wrap(s.getBytes());
//        ByteBuffer capacity = ByteBuffer.allocate(12);
//        try(FileChannel channel = FileChannel.open(dir,READ,WRITE)){
//            int status;
//            do{
//                status = channel.read(capacity);
//            }while(status!=-1&&capacity.hasRemaining());
//
//
//            //write the String s at the beginning of the file
//            channel.position(0);
//            while(buffer.hasRemaining())
//                channel.write(buffer);
//            buffer.rewind();
//
//            //move to the end of file,and write the String s to the file
//            channel.position(channel.size()-1);
//            capacity.flip();
//            while (buffer.hasRemaining())
//                channel.write(buffer);
//        }

//        //directory stream
//        //glob filter
//        try(DirectoryStream<Path> java_path = Files.newDirectoryStream(Paths.get("D:\\IdeaProjects\\reborn\\src\\com\\reborn\\test"),"a*.java")){
//            for(Path java:java_path){
//                System.out.println(java);
//            }
//        }
//
//        //customize filter
//        DirectoryStream.Filter<Path> filter = entry -> Files.isDirectory(entry);
//        try(DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get("D:\\IdeaProjects\\reborn\\src\\com\\reborn\\test"),filter)){
//            for(Path java:paths){
//                System.out.println(java);
//            }
//        }

//        //hard link and symbolic link
//        Path newLink = Paths.get("d:\\abc\\bcd\\cde\\abc1.txt");
//        Path newLink2 = Paths.get("d:\\abc\\bcd\\cde\\abc2.txt");
//        Path target = Paths.get("d:\\abc\\bcd\\cde\\abc.txt");
//        try{
//            Files.createSymbolicLink(newLink,target);
//            Files.createLink(newLink2,target);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        System.out.println(Files.isSymbolicLink(target));

        //Iterate directories and files
        Files.walkFileTree(Paths.get("d:\\360\\"), new FileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("preVisitDirectory "+dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("visitFile " + file);
                SeekableByteChannel chanel = Files.newByteChannel(file);
                ByteBuffer capacity = ByteBuffer.allocate(1000);
                String charset = System.getProperty("file.encoding");
//                while (chanel.read(capacity) > 0) {
//                    capacity.rewind();
//                    System.out.println(Charset.forName(charset).decode(capacity));
//                    capacity.flip();
//                }
                return FileVisitResult.CONTINUE;
            }


            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("visitFileFailed " + file);
                return FileVisitResult.TERMINATE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("postVisitDirectory "+dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
