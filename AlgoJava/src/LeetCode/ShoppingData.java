package LeetCode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingData {

    public static void generateFiles() throws IOException {
        String filePath = "testfiles\\input.csv";
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        Map<String, Integer> avg = new HashMap<>();
        Map<String, Map<String, Integer>> popular = new HashMap<>();

        int numLines = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] items = line.split(",");
            String item = items[2].trim();
            Integer count = Integer.parseInt(items[3].trim());
            String brand = items[4].trim();
            if (avg.containsKey(item)) {
                avg.put(item, avg.get(item) + count);
            } else {
                avg.put(item, count);
            }
            if (popular.containsKey(item)) {
                if (popular.get(item).containsKey(brand)) {
                    popular.get(item).put(brand, popular.get(item).get(brand) + 1);
                } else {
                    popular.get(item).put(brand, 1);
                }
            } else {
                Map<String, Integer> brandMap = new HashMap<String, Integer>();
                brandMap.put(brand, 1);
                popular.put(item, brandMap);
            }
            ++numLines;
        }
        FileWriter fw = new FileWriter("testfiles\\output1.csv");
        for (String s : avg.keySet()) {
            String str = s + "," + String.valueOf((float) avg.get(s) / numLines) + "\n";
            fw.append(str);
        }
        fw.close();
        FileWriter fw2 = new FileWriter("testfiles\\output2.csv");
        for (String s : popular.keySet()) {
            int popCount = 0;
            String popBrand = null;
            for (String brandName : popular.get(s).keySet()) {
                if (popular.get(s).get(brandName) > popCount) {
                    popBrand = brandName;
                    popCount = popular.get(s).get(brandName);
                }
            }
            String str = s + "," + popBrand + "\n";
            fw2.append(str);
        }
        fw2.close();
    }

    public static void main(String[] args) {
        try {
            ShoppingData.generateFiles();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
