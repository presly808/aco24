package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtils {

    public static String cat(String path) throws FileNotFoundException{
        //Files.readAllLines(Paths.get(path)).stream().collect(Collectors.joining("\n"));
        BufferedReader fileReader = new BufferedReader(new FileReader(path));

        StringBuilder sb = new StringBuilder();
        String line;

        try {
            while ((line = fileReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static boolean writeInto(String path, String src, boolean append)
            throws IOException {

        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }

        try {
            FileWriter fl = new FileWriter(path);
            fl.write(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    public static List<String> ls(String path) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        File dir = new File(System.getProperty(path));
        for(File child: dir.listFiles()){
            System.out.println(child);
            list.add(child.getName());
        }
        return list;
    }

    public static boolean copy(String src, String dest) throws Exception {

        File file = new File(dest);
        if (!file.exists()) {
            file.createNewFile();
        }
//        BufferedReader fileReader = new BufferedReader(new FileReader(src));
//        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(dest));
//        String line;
//
//        try {
//            while ((line = fileReader.readLine()) != null) {
//                fileWriter.write(line);
//                return true;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        return false;

        try (
                InputStream in = new BufferedInputStream(new FileInputStream(src));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
                return true;
            }
        }
        return false;
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
