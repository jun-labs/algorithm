package boj.boj_1141.java;

import static java.util.Comparator.comparingInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for (int index = 0; index < n; index++) {
            words.add(br.readLine());
        }

        words.sort(comparingInt(String::length));
        int count = 0;
        outer:for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words.get(j).startsWith(words.get(i))) {
                    continue outer;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
