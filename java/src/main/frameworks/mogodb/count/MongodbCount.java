package main.frameworks.mogodb.count;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 * @function    分析文件, 找出所有相同的项出现的次数.
 *
 * @author      main.chile
 * @date        2017/3/8.
 */

public class MongodbCount {

    public static void main(String[] args) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        File countFile = new File("C:\\Users\\huayu\\Desktop\\login登陆统计.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(countFile));
            String data = null;
            while ((data = reader.readLine()) != null) {
                data = data.split(",")[1];
                if (resultMap.keySet().contains(data)) {
                    resultMap.put(data, resultMap.get(data) + 1);
                } else {
                    resultMap.put(data, 1);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int times = 0;
        for (String key : resultMap.keySet()) {
            if (resultMap.get(key) > 1 && resultMap.get(key) < 6) {
                System.out.println(String.format("%3d", ++times) + " " + key + " : " + resultMap.get(key));
            }
        }


    }


}


