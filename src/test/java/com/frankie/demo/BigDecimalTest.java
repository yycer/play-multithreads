package com.frankie.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author: Yao Frankie
 * @date: 2020/1/13 15:09
 */
@SpringBootTest
public class BigDecimalTest {

    @Test
    public void bidDecimalTest(){
        // 0.1000000000000000055511151231257827021181583404541015625
        BigDecimal bg1 = new BigDecimal(0.1);
        // 0.1
        BigDecimal bg2 = BigDecimal.valueOf(0.1);
    }
}
