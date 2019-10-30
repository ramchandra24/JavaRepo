package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateFileinFS {
    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> poolMap = new HashMap<>();

        for (String path : paths) {
            String[] words = path.split(" ");
            String dirPath = words[0];
            for (int i = 1; i < words.length; ++i) {
                String[] fdetails = words[i].split("\\(");
                String fname = fdetails[0];
                String fcontent = fdetails[1].substring(0, fdetails[1].length() - 1);

                if (poolMap.containsKey(fcontent)) {
                    poolMap.get(fcontent).add(dirPath + "/" + fname);
                } else {
                    List<String> fpool = new ArrayList<>();
                    fpool.add(dirPath + "/" + fname);
                    poolMap.put(fcontent, fpool);
                }
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (String content : poolMap.keySet()) {
            List<String> fpaths = poolMap.get(content);
            if (fpaths.size() > 1) {
                result.add(fpaths);
            }
        }
        return result;
    }
}
