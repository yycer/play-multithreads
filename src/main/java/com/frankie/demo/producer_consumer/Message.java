package com.frankie.demo.producer_consumer;


import lombok.Getter;
import lombok.Setter;

/**
 * @author: Yao Frankie
 * @date: 2020/1/3 15:18
 */
@Setter
@Getter
public class Message {
    private String message;

    public Message(String message){
        this.message = message;
    }
}
