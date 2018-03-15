package assistant;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.Scanner;

/**
 * Title : assistant
 * Company : 北京华宇元典信息服务有限公司
 * Description :
 *  <ul> 
 *    <li>  </li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2017/12/4 9:46
 */

public class FilePreprocess {

    public static void main(String[] args) {
        findCompanyNameWihchLengthBIggerThan5();
    }

    private static void findCompanyNameWihchLengthBIggerThan5() {
        String filePath = "C:\\Users\\huayu\\Desktop\\word_assistant\\ansj\\company.txt";
        String resultPath = "C:\\Users\\huayu\\Desktop\\word_assistant\\ansj\\1234.txt";

        try (InputStream fileIS = new FileInputStream(filePath);
             Scanner scanner = new Scanner(fileIS, "utf-8");
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultPath)))) {

            int num = 0;
            while (scanner.hasNext()) {
                String line = scanner.next();

                // 去掉双引号
                line = line.replaceAll("\"", "");

                if (StringUtils.isNotBlank(line)) {
                    if (line.length() > 5) {
                        if (!line.matches(".*?(公司|厂|店|门市|部|社|中心|基地|园|行|铺|会|工作室|超市|处|馆|楼|场|所|厅"
                                                  + "|点|屋|站|庄|房|吧|（有限合伙）|企业|队|摊|档|院|局|浴池|户)")) {
                            System.out.println(line);
                            bufferedWriter.write(line + "\n");
//                            if (num++ > 1000000) {
//                                break;
//                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
