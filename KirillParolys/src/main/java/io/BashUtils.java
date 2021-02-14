package io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.text.StrBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException {
        StringBuilder builder = new StringBuilder();

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static String cat(String path, String targetWord) {

        StringBuilder builder = new StringBuilder();

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        try {
            while ((line = bufferedReader.readLine()) != null && line.equals(targetWord)) {
                builder.append(new File(path).getName() + "," + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();

    }

    public static boolean writeInto(String path, String src, boolean append) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path, append);

        fileOutputStream.write(src.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();

        return true;
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        List<String> res = new ArrayList<>();
        File folder = new File(path);

        Arrays.asList(folder.listFiles()).stream()
                .forEach(file -> res.add(file.getName()));
        return res;
    }

    public static boolean copy(String src, String dest) throws Exception {
        FileUtils.copyFile(new File(src), new File(dest));

        return true;
    }

    public static boolean move(String src, String dest) throws  Exception{
        FileUtils.moveFile(new File(src), new File(dest));

        return true;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException{
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

    public static List<String> grep(String lines, String targetWord){
        List<String> stringList = Arrays.asList(lines.split("\n"));
        List<String> res = new ArrayList<>();

        stringList.stream()
                .filter(s -> s.equals(targetWord))
                .forEach(s -> res.add(s));

        return res;
    }

    public static Map<String, String> grepR(String path, String targetWord) throws IOException {
        Map<String, String> res = new HashMap<>();

        File dir = new File(path);

        for (File fileEntry : dir.listFiles()) {
            if (fileEntry.isDirectory()) {
                grepR(fileEntry.getAbsolutePath(), targetWord);
            } else {
                if (grepFromFile(fileEntry.getAbsolutePath(), targetWord)) {
                    res.put(fileEntry.getName(), targetWord);
                }
            }
        }

        return res;
    }

    private static boolean grepFromFile(String path, String targetWord) {
        boolean res = false;

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        try {
            while ((line = bufferedReader.readLine()) != null && line.equals(targetWord)) {
                res = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

}
