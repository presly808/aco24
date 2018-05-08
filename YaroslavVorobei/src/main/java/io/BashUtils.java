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

        // Old version
   /*   String line = "";
        String res = "";

        FileReader fileReader = new FileReader(path);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            while ((line = bufferedReader.readLine()) != null) {
                res += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Always close files.
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res; */
    }

    public static boolean writeInto(String path, String src, boolean append)
            throws IOException {

        /*PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path, append)));
        writer.println(src);
        writer.close();
        */

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

            //print files on filder
            /*for (String s : files) {
                System.out.println(s);
            }*/
            folderList = new ArrayList<String>(Arrays.asList(files));
        }
        return folderList;
    }

    public static boolean copy(String src, String dest) throws Exception {

        writeInto(cat(src), dest, true);

        return true;
    }

    public static boolean move(String src, String dest) throws Exception {
        return false;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        return null;
    }

    public static List<String> grep(String lines, String targetWord) {
        return null;
    }

    public static Map<String, String> grepR(String path, String targetWord) {
        return null;
    }

}
