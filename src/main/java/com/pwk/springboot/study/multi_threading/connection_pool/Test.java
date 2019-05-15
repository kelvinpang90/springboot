package com.pwk.springboot.study.multi_threading.connection_pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 30;
        int count = 20;
        end = new CountDownLatch(threadCount);
        AtomicInteger successfulConnection = new AtomicInteger();
        AtomicInteger unsuccessfulConnection = new AtomicInteger();
        for (int i = 0;i<threadCount;i++){
            Thread thread = new Thread(new ConnectionRunner(count,successfulConnection,unsuccessfulConnection));
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke:"+(threadCount*count));
        System.out.println("successful connection:"+successfulConnection);
        System.out.println("unsuccessful connection:"+unsuccessfulConnection);
    }
    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger successfulConnection;
        AtomicInteger unsuccessfulConnection;

        public ConnectionRunner(int count, AtomicInteger successfulConnection, AtomicInteger unsuccessfulConnection) {
            this.count = count;
            this.successfulConnection = successfulConnection;
            this.unsuccessfulConnection = unsuccessfulConnection;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count>0){
                Connection connection = null;
                try {
                    connection = pool.getConnection(1000);
                    if(connection!=null){
                        connection.createStatement();
                        connection.commit();
                        pool.releaseConnection(connection);
                        successfulConnection.incrementAndGet();
                    }
                    else
                        unsuccessfulConnection.incrementAndGet();
                } catch (InterruptedException | SQLException e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
