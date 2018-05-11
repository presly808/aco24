package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {

        try {
            String result = Files.readAllLines(Paths.get(path))
                    .stream().collect(Collectors.joining("\n"));
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean writeInto(String path, String src, boolean append) throws IOException {
        try (FileWriter fl = new FileWriter(path, append)) {
            fl.write(src);
        }

        return true;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        List<String> folderList = new ArrayList();

        File file = new File(path);
        if (file.isDirectory()) {
            //list all files on directory
            String[] files = file.list();
            folderList = new ArrayList<String>(Arrays.asList(files));
        }
        return folderList;
    }

    public static boolean copy(String src, String dest) throws Exception {

        //writeInto(cat(src), dest, true);
        writeInto(dest, cat(src),  true);

        return true;
    }

    public static boolean move(String src, String dest) throws Exception {
        writeInto(dest, cat(src),  true);
        return true;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        List<String> res = new ArrayList<>();
        File file = new File(path);

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                List<String> found = find(f.getAbsolutePath(), targetName);

                found.stream()
                        .filter(s -> s.equals(targetName))
                        .forEach(s -> res.add(s));
            }
        } else {
            if (file.getName().equals(targetName)) {
                res.add(file.getName());
            }
        }

        return res;
    }

    public static List<String> grep(String lines, String targetWord) {

       List<String> srcLinesList = Arrays.asList(lines.split("\n"));
       List<String> targetLines = new ArrayList<>();

       srcLinesList.stream()
               .filter(str -> str.equals(targetWord))
               .forEach(str -> targetLines.add(str));

       return targetLines;
    }

    public static Map<String, String> grepR(String path, String targetWord) {

        return null;
    }

}
