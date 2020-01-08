package com.frankie.demo.core_tech;

/**
 * @author: Yao Frankie
 * @date: 2020/1/8 21:21
 */
public class PublicVariable {

    public String username = "A";
    public String password = "AA";

    public void setValue(String username, String password){
        this.username = username;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;
        System.out.println("setValue() method thread name = " + Thread.currentThread().getName() +
                ", username = " + username + " , password = " + password);
    }

    public void getValue(){
        System.out.println("getValue() method thread name = " + Thread.currentThread().getName() +
                ", username = " + username + " , password = " + password);
    }
}
