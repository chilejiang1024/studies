package main.java8.utility.tools;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * Title : com.thunisoft.export.utils.RenameFiles <br>
 * Description :
 *  <p>
 *  <ul>
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018-5-5 12:19:15
 */
public class RenameFiles {

    public static void main(String[] args) {
        rename();
    }

    private static void rename() {
        String floderPath = "C:\\Users\\Administrator\\Desktop\\Camera\\";
        File floder = new File(floderPath);

        if (!floder.isDirectory()) {
            return;
        }

        File[] files = floder.listFiles();
        if (Objects.isNull(files)) {
            return;
        }

        Arrays.stream(files).forEach(f -> {
            String fileName = f.getName();
            if (fileName.startsWith("P")) {
                String newFileName = fileName.replace("P", "IMG_201").replace("-", "_");
                boolean done = f.renameTo(new File(floderPath + newFileName));
                if (done) {
                    System.out.println("rename file : " + floderPath + newFileName);
                } else {
                    System.out.println("something wrong .");
                }
            }
        });

    }

}
