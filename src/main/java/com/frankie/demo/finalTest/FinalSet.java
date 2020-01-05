package com.frankie.demo.finalTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yao Frankie
 * @date: 2020/1/5 16:02
 */
public class FinalSet {

    public final Set<String> names = new HashSet<>();

    public FinalSet(){
        names.add("yyc");
        names.add("frankie");
    }
}
