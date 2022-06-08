package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FileUtils {

    private static final String FILE_PATH = "src/main/resources/table.txt";

    public static Map<String, Map<Character, Integer>> getCreaturesMap() {
        Map<String, Map<Character, Integer>> creaturesMap = new HashMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                String[] lineWords = line.split(" ");
                if(lineWords.length != 3) {
                    throw new IOException("Wrong file content");
                }
                String creature = lineWords[0];
                Character cellType = lineWords[1].charAt(0);
                Integer cost = Integer.valueOf(lineWords[2]);
                if(creaturesMap.containsKey(creature)) {
                    creaturesMap.get(creature).put(cellType, cost);
                } else {
                    Map<Character, Integer> cellTypeToCost = new HashMap<>();
                    cellTypeToCost.put(cellType, cost);
                    creaturesMap.put(creature, cellTypeToCost);
                }
                line = bufferedReader.readLine();
            }
            return creaturesMap;
        } catch (FileNotFoundException e) {
            System.out.println("File with path \"" + FILE_PATH + "\" not found");
            return Collections.EMPTY_MAP;
        } catch (IOException e) {
            System.out.println("Exception happened while reading from file with path: " + FILE_PATH +
                    ". Exception message: " + e.getMessage());
            return Collections.EMPTY_MAP;
        }
    }
}
