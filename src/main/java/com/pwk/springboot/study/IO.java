package com.pwk.springboot.study;

import java.io.*;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IO {
    //FileInputStream FileOutputStream
    public static void copyBytes(File src,File dest) throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream(src);
            FileOutputStream fileOutputStream = new FileOutputStream(dest);
        ){
            int c;
            while((c = fileInputStream.read())!=-1)
                fileOutputStream.write(c);
        }
    }

    //FileReader FileWriter
    //updated BufferedReader BufferedWriter
    public static void copyChars(File src,File dest) throws IOException {
        try(
                BufferedReader fileReader = new BufferedReader(new FileReader(src));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(dest))
                ){
            int c;
            while((c=fileReader.read())!=-1){
                fileWriter.write(c);
            }
        }
    }




    //InputStreamReader OutputStreamWriter



    public static void main(String[] args) throws IOException {
//        copyBytes(new File("C:\\Users\\pengw\\Desktop\\java note.txt"),new File("C:\\Users\\pengw\\Desktop\\"+Math.random()+".txt"));
//        copyChars(new File("C:\\Users\\pengw\\Desktop\\java note.txt"),new File("C:\\Users\\pengw\\Desktop\\"+Math.random()+".txt"));

        //Scanner
//        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
//        if (scanner.hasNext())
//            System.out.println(scanner.next());

        //Console
//        Console c = System.console();
//        if(c == null){
//            System.out.println("no console");
//            System.exit(1);
//        }
//        String name = c.readLine("enter your name");
//        char[] password = c.readPassword();
//        System.out.format("your name is %s and your password is %s",name,password);

        //Data Stream
//        final double[] price = {11.99,22.99,33.99,44.99};
//        final int[] units = {2,4,6,8};
//        final String[] names = {"shirt","polo","sweater","coat"};
//
//        try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\pengw\\Desktop\\test.txt")))){
//            for(int i = 0;i<price.length;i++){
//                out.writeDouble(price[i]);
//                out.writeInt(units[i]);
//                out.writeUTF(names[i]);
//            }
//        }


        Path path = Paths.get("d:\\log.log");
        Path dir = Paths.get("d:\\abc\\bcd\\cde\\abc.txt");
//        System.out.println(path.toAbsolutePath());
//
//        File file = new File("d:\\log.log");
//        Charset charset = Charset.forName("US-ASCII");
//        String s = "abcd";
//        try(BufferedWriter writer = Files.newBufferedWriter(path,charset)){
//            writer.write(s,0,s.length());
//        }
//        Files.deleteIfExists(path);
//        Files.createFile(path);
//        Files.createDirectories(dir);
//        BasicFileAttributes attributes = Files.readAttributes(dir, BasicFileAttributes.class);
//        System.out.println(attributes.lastAccessTime());
//        Files.copy(dir,dir, StandardCopyOption.ATOMIC_MOVE);

        //getOwner
//        UserPrincipal principal = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("");
//        System.out.println(Files.getOwner(path).getName());
//        Files.setOwner(dir, Files.getOwner(path));

        //customize attributes
//        UserDefinedFileAttributeView view = Files.getFileAttributeView(dir,UserDefinedFileAttributeView.class);
//        for(String str:view.list()){
//            System.out.println(str);
//        }
//        view.write("user.mimitype", Charset.defaultCharset().encode("text/html"));
//        ByteBuffer byteBuffer = ByteBuffer.allocate(view.size("user.minitype"));
//        byteBuffer.flip();
//        String value = Charset.defaultCharset().decode(byteBuffer).toString();
//        System.out.println(value);

        //File Storage Attributes
        FileStore store = Files.getFileStore(path);
        long total = store.getTotalSpace()/1024/1024/1024;
        long used = (store.getTotalSpace()-store.getUnallocatedSpace())/1024/1024/1024;
        long avail = (store.getUsableSpace())/1024/1024/1024;
        System.out.println(total+" "+used+" "+avail);

        //read,write and create files
        //for small files,can read/write all contents at one time
//        byte[] buf = Files.readAllBytes(dir);
//        Files.write(dir,buf);

        //read write by buffered stream
//        Charset charset = Charset.forName("US-ASCII");
//        try(BufferedReader reader = Files.newBufferedReader(dir,charset);
//            BufferedWriter writer = Files.newBufferedWriter(path,charset)
//        ){
//            String line = "";
//            while((line = reader.readLine())!=null){
//                System.out.println(line);
//            }
//        }
//        Files.copy(dir,path,StandardCopyOption.REPLACE_EXISTING);

    }
}
