package org.kazim.demo.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class GenerateDoc {

    public static void generate(int numStr, int min, int max) throws Exception {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < numStr; i++) {
            Integer[] list = IntStream.range(min, max).boxed().toArray(Integer[]::new);
            shuffleArray(list);
            strings.add(i + " " + Arrays.toString(list).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", ""));
        }
        Files.write(Paths.get("demo.txt"), strings, StandardOpenOption.CREATE);
    }

    private static void shuffleArray(Integer[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
