package com.ouyang.project.tomcat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ouyang on 2017/2/27.
 */
public class HttpSimulateRequest {
    public void request() throws Exception{
        Socket socket = new Socket("www.sina.com.cn", 80);
        OutputStream outputStream = socket.getOutputStream();
        boolean autoFlush = true;
        PrintWriter out = new PrintWriter(outputStream, autoFlush);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.println("GET / HTTP/1.1");
        out.println("Host: www.sina.com.cn");
        out.println("Conneciton:close");
        out.println();
        boolean bool = true;
        StringBuffer sb = new StringBuffer(8096);
        while (bool){
            if(br.ready()){
                int i=0;
                while(i != -1){
                    i = br.read();
                    sb.append((char)i);
                }
                bool = false;
            }
            Thread.currentThread().sleep(50);
        }
        System.out.println(sb.toString());
        socket.close();

    }

    public static void main(String[] args) throws Exception{
        HttpSimulateRequest request = new HttpSimulateRequest();
        request.request();
    }
}
