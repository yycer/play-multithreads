package com.frankie.demo.chapter8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Yao Frankie
 * @date: 2020/7/9 13:44
 */
public class CheckDuplicate {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/com/frankie/demo/chapter8/Demo4");
        List<String> lines = Files.lines(path, StandardCharsets.UTF_8)
                .collect(Collectors.toList());
        HashSet<String> set = new HashSet<>();
        int ans = 0;
        for (String line: lines){
            if (!set.add(line)){
                System.out.println(line);
                ans++;
            }
        }
        System.out.println("ans = " + ans);
    }
}
