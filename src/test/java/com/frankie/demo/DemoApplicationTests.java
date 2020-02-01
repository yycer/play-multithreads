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
//        sb.append("hmset test_hash_max_ziplist_entries ");
//        sb.append("rpush test_list_max_ziplist_entries ");
        sb.append("zadd sorted_set_test2 ");
        for (int i = 1; i <= 128; i++){
            sb.append(i);
            sb.append(" ");
            sb.append(i);
            sb.append(" ");
        }

        String result = new String(sb);
        System.out.println(result);
    }

    @Test
    public void buildMsetTest(){
        StringBuilder sb = new StringBuilder();
        sb.append("mset ");
        for (int i = 1; i <= 200; i++){
            sb.append("n");
            sb.append(i);
            sb.append(" v");
            sb.append(i);
            sb.append(" ");
        }
        String result = new String(sb);
        System.out.println(result);
    }

    @Test
    public void print10Test(){
        for (int i = 0; i < 10; i++){
            System.out.print(i + " ");
        }
    }
}
