package com.pwk.springboot.study.multi_threading.connection_pool;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection> connectionPool = new LinkedList<>();

    public ConnectionPool(int size) {
        if(size>0)
            for (int i = 0;i<size;i++)
                connectionPool.add(ConnectionDriver.createConnection());
    }

    public Connection getConnection(long mills) throws InterruptedException {
        synchronized (connectionPool){
            if(mills<0){
                while (connectionPool.isEmpty())
                    connectionPool.wait();
                return connectionPool.removeFirst();
            }else{
                long future = System.currentTimeMillis()+mills;
                long remaining = mills;
                while (remaining>0&&connectionPool.isEmpty()){
                    connectionPool.wait(remaining);
                    remaining = future-System.currentTimeMillis();
                }
                Connection result = null;
                if(!connectionPool.isEmpty())
                    result = connectionPool.removeFirst();
                return result;
            }
        }
    }

    public void releaseConnection(Connection connection){
        if (connection!=null){
            synchronized (connectionPool){
                connectionPool.addLast(connection);
                connectionPool.notify();
            }
        }
    }
}
