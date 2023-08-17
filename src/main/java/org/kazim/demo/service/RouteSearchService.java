package org.kazim.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;

@Slf4j
@Service
public class RouteSearchService {
    public boolean routeSearch(int from, int to) {
        var fileName = "demo.txt";
        var isSearch = false;
        try (var fr = new FileReader(fileName);
             var br = new BufferedReader(fr)) {
            var line = br.readLine();
            while (line != null) {
                var numbs = Arrays.stream(line.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
                if (search(numbs, from, to)) {
                    isSearch = true;
                    line = null;
                } else {
                    line = br.readLine();
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return isSearch;
    }

    private boolean search(Integer[] arr, int x, int y) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] == x)
                for (int j = i; j < arr.length; j++)
                    if (arr[j] == y)
                        return true;
        return false;
    }
}
