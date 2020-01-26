package com.frankie.demo;

import com.frankie.demo.utils.Status;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        System.out.println("yyc");
    }

    @Test
    public void switchTest(){
        Status status = Status.Unknow;
        switch (status) {
            default:
            case Unknow:
            case Fail:
                System.out.println("enter fail block");
                break;
            case Success:
                break;
        }
        System.out.println("Done");
    }

    @Test
    public void switchTest2(){
        String name = "2";

        switch (name) {
            case "1":
                System.out.println("1");
            case "2":
                System.out.println("2");
            case "3":
                System.out.println("3");
            case "4":
                System.out.println("4");
                break;
        }
    }

    @Test
    public void print512FiledAndValueTest(){
        StringBuilder sb = new StringBuilder();
        sb.append("hmset test_hash_max_ziplist_entries ");
        for (int i = 501; i <= 512; i++){
            sb.append("f");
            sb.append(i);
            sb.append(" v");
            sb.append(i);
            sb.append(" ");
        }

        String result = new String(sb);
        System.out.println(result);
    }
}
