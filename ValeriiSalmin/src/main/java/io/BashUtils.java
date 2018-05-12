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
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path,append)))) {
            writer.write(src);
            return true;
        }
    }

    public static List<String> ls(String path) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        String test = System.getProperty(path);
        File dir = new File(test);
        for(String child: dir.list()){
            //System.out.println(child);
            list.add(child);
        }
        return list;
    }

    public static boolean copy(String src, String dest) throws Exception {

        File file = new File(dest);
        if (!file.exists()) {
            file.createNewFile();
        }

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
        File file = new File(dest);
        File file1 = new File(src);
        if (!file.exists()) {
            file.createNewFile();
        }

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
            file1.delete();
        }
        return false;
    }

    public static List<String> find(String path, String targetName) throws FileNotFoundException {
        File directory = new File(path);
        File[] fList = directory.listFiles();
        return null;
    }

    public static List<String> grep(String lines, String targetWord) {
        double count = 0,countBuffer=0,countLine=0;
        String lineNumber = "";
        String filePath = lines;
        BufferedReader br;
        String inputSearch = "targetWord";
        String line = "";
        List<String> list = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(filePath));
            try {
                while((line = br.readLine()) != null)
                {
                    countLine++;
                    String[] words = line.split(" ");

                    for (String word : words) {
                        if (word.equals(inputSearch)) {
                            count++;
                            countBuffer++;
                        }
                    }
                    if(countBuffer > 0)
                    {
                        countBuffer = 0;
                        lineNumber += countLine + ",";
                    }

                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, String> grepR(String path, String targetWord) {
        return null;
    }

}
