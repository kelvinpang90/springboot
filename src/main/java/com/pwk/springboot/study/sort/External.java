package com.pwk.springboot.study.sort;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class External {
    private final static int SEGMENT_SIZE = 100000;

    public static void sort(File ori, File dest) throws IOException{
        File tempFile1 = new File("f1.dat");
        File tempFile2 = new File("f2.dat");
        File tempFile3 = new File("f3.dat");
        //step 1
        int numberOfSegments = sortSegments(ori,tempFile1);
        merge(tempFile1,tempFile2,tempFile3,dest,numberOfSegments);
    }

    private static int sortSegments(File ori,File tempFile) throws IOException {
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(ori)));
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tempFile)));
        List<Integer> tempList = new ArrayList<>();
        int numberOfSegments = 0;

        while (input.available()>0){
            numberOfSegments++;
            for(int i = 0;i<SEGMENT_SIZE&&input.available()>0;i++){
                tempList.add(input.readInt());
            }
            Collections.sort(tempList);

            for(Integer integer:tempList)
                output.write(integer);
        }

        input.close();
        output.close();
        return numberOfSegments;
    }

    private static void merge(File temp1,File temp2,File temp3,File dest,int numberOfSegments) throws IOException {
        if(numberOfSegments>1){
            DataInputStream temp1Input = new DataInputStream(new BufferedInputStream(new FileInputStream(temp1)));
            DataOutputStream temp2Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(temp2)));
            //step 2
            divideTo2(numberOfSegments,temp1Input,temp2Output);
            temp2Output.close();
            //step 3 and 4
            DataInputStream temp2Input = new DataInputStream(new BufferedInputStream(new FileInputStream(temp2)));
            DataOutputStream temp3Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(temp3)));
            mergeAllSegments(numberOfSegments,temp1Input,temp2Input,temp3Output);
            temp1Input.close();
            temp2Input.close();
            temp3Output.close();
        }else{
            Files.copy(new DataInputStream(new BufferedInputStream(new FileInputStream(temp1))),dest.toPath());
        }
    }

    private static void divideTo2(int numberOfSegments,DataInputStream temp1,DataOutputStream temp2) throws IOException{
        for(int i = 0;i<(SEGMENT_SIZE*numberOfSegments)/2;i++){
            temp2.write(temp1.readInt());
        }
    }

    private static void mergeTwoSegments(DataInputStream temp1,DataInputStream temp2,DataOutputStream temp3) throws IOException{
        int f1Data = temp1.readInt();
        int f2Data = temp2.readInt();
        int f1Count = 1;
        int f2Count = 1;

        //对比2个segment的数据，将小的存进temp3
        while (true){
            if(f1Data<f2Data){
                temp3.write(f1Data);
                if(temp1.available()==0||f1Count++>=SEGMENT_SIZE){
                    temp3.write(f2Data);
                    break;
                }else{
                    f1Count = temp1.readInt();
                }
            }else{
                temp3.write(f2Data);
                if(temp2.available()==0||f2Count++>=SEGMENT_SIZE){
                    temp3.write(f1Data);
                    break;
                }
            }
        }

        //将还没有对比的数据存进temp3
        while(temp1.available()>0&&f1Count++>=SEGMENT_SIZE){
            temp3.write(temp1.readInt());
        }

        while ((temp2.available()>0&&f2Count++>=SEGMENT_SIZE)){
            temp3.write(temp2.readInt());
        }
    }

    private static void mergeAllSegments (int numberOfSegments,DataInputStream temp1,DataInputStream temp2,DataOutputStream temp3) throws IOException{
        for(int i=0;i<numberOfSegments/2;i++){
            //step 3
            mergeTwoSegments(temp1,temp2,temp3);
        }

        while (temp1.available()>0)
            temp3.write(temp1.readInt());
    }
}
