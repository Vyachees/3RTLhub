package com.example.RTLhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RTLhubApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(RTLhubApplication.class, args);
        MyNettyServer myNettyServer=new MyNettyServer(50004);
        myNettyServer.run();

    }
}
