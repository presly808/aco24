package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();

        try {
            while (reader.ready()) {
                sb.append(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileNotFoundException();
        }
        return sb.toString();
    }

    public static boolean writeInto(String path, String src, boolean append)
            throws IOException {
        FileWriter writer = new FileWriter(path, append);

        if (append) {
            writer.write(src);
        } else {
            writer.append(src);
        }
        writer.close();
        return true;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        File dir;
        try {
            dir = new File(path);
        } catch (Exception e) {
            throw new FileNotFoundException();
        }
        List<String> fileNames = new ArrayList<>();

        if (dir.isDirectory() && dir.listFiles() != null) {
            for (File f : dir.listFiles()) {
                fileNames.add(f.getName());
            }
        }
        return fileNames;
    }

    public static boolean copy(String src, String dest) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(src));
        BufferedWriter writer = new BufferedWriter(new FileWriter(dest, true));

        while (reader.ready()) {
            writer.append(reader.readLine());
        }

        writer.close();
        reader.close();

        return true;
    }

    public static boolean move(String src, String dest) throws Exception {
        copy(src, dest);
        Files.delete(Paths.get(src));
        return true;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        List<String> all = new ArrayList<>();
        File dir = new File(path);

        if (path.contains(targetName)) {
            all.add(path);
        }

        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                List<String> res = find(f.getAbsolutePath(), targetName);
                all.addAll(res);
            }
        }
        return all;
    }

    public static List<String> grep(String lines, String targetWord) {
        List<String> result = new ArrayList<>();
        String[] parsedLines = lines.split("\n");
        for (String line : parsedLines) {
            if (line.contains(targetWord)) {
                result.add(line);
            }
        }
        return result;
    }

    public static Map<String, String> grepR(String path, String targetWord) {
        Map<String, String> map = new HashMap<>();
        File dir = new File(path);

        if (!dir.isDirectory()) {
            try {
                String result = grep(cat(dir.getAbsolutePath()), targetWord)
                        .stream()
                        .collect(Collectors.joining("\n"));
                if (result.length() > 0) {
                    map.put(dir.getName(), result);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            for (File file : dir.listFiles()) {
                Map<String, String> res = grepR(file.getAbsolutePath(), targetWord);
                map.putAll(res);
            }
        }
        return map;
    }

}
