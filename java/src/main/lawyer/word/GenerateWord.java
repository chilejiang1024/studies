//package main.lawyer.word;
//
//import com.aspose.words.*;
//import com.aspose.words.Document;
//import org.apache.poi.xwpf.usermodel.*;
//import org.springframework.util.StringUtils;
//
//import java.io.*;
//import java.math.MathContext;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * Title : main.lawyer.word
// * Company : 北京华宇元典信息服务有限公司
// * Description :
// *  -
// *  -
// *
// * @author chile
// * @version 1.0
// * @date 2017/6/28 10:51
// */
//
//public class GenerateWord {
//
//    public static void main(String[] args) {
//
//        try {
//            // shabusha();
//            convertToDocx(new FileInputStream("C:\\Users\\huayu\\Desktop\\1.doc"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void shabusha() throws Exception {
//        InputStream docIS = new FileInputStream("C:\\Users\\huayu\\Desktop\\3.docx");
//        XWPFDocument docx = new XWPFDocument(docIS);
//
//        XWPFParagraph p1 = docx.createParagraph();
//        XWPFRun p1r1 = p1.createRun();
//        p1r1.setFontFamily("华文楷体");
//        p1r1.setFontSize(14);
//        p1r1.setText("尊敬的委托人：");
//
//        XWPFParagraph p2 = docx.createParagraph();
//        XWPFRun p2r2 = p2.createRun();
//        p2r2.setFontFamily("华文楷体");
//        p2r2.setFontSize(14);
//        p2r2.setText("    任何诉讼/仲裁、非诉案件均存在法律风险，案件进程和案件结果可能受到各种客观因素的影响，在聘请律师前您应确认具有承受此等法律风险之负担能力及合理预见；为维护您的合法权益，当您委托本所办理案件前，我们遵循诚实信用原则，向您告知以下可能存在的风险:");
//
//        XWPFParagraph p3 = docx.getLastParagraph();
//        XWPFRun p3r1 = p3.getRuns().get(0);
//        String p3r1Text = p3r1.getText(0);
//        // System.out.println(p3r1Text);
//
//        // replaceKeyWord(docx.getParagraphs());
//        replaceKeyWord(docx.getParagraphs(), new HashMap<>());
//
//        OutputStream out = new FileOutputStream("C:\\Users\\huayu\\Desktop\\new.docx");
//        docx.write(out);
//    }
//
//    private static void replaceKeyWord(List<XWPFParagraph> paragraphList) {
//        for (XWPFParagraph p : paragraphList) {
//            for (XWPFRun r : p.getRuns()) {
//                String text = r.getText(0);
//                System.out.println(text);
//                if (!StringUtils.isEmpty(text) && text.contains("${DSR}")) {
//                    text = text.replace("${DSR}", "替换的当事人");
//                }
//                r.setText(text, 0);
//            }
//        }
//    }
//
//    /**
//     * 替换paragraph里边的关键词
//     * @param paragraphList
//     * @param keyword
//     */
//    private static void replaceKeyWord(List<XWPFParagraph> paragraphList, Map<String, String> keyword) {
//        keyword.put("${QQ}", "天真");
//        for (XWPFParagraph p : paragraphList) {
//            for (XWPFRun r : p.getRuns()) {
//                String text = r.getText(0);
//                //System.out.println(text);
//                if (StringUtils.isEmpty(text)) {
//                    continue;
//                }
//                Pattern pattern = Pattern.compile("\\$\\{[A-Z]+?\\}");
//                Matcher matcher = pattern.matcher(text);
//                while (matcher.find()) {
//                    String key = matcher.group();
//                    System.out.println(key);
//                    if (keyword.keySet().contains(key)) {
//                        text = text.replace(key, keyword.get(key));
//                    }
//                }
//                r.setText(text, 0);
//                // System.out.println(text);
//            }
//        }
//    }
//
//    /**
//     * 替换table里的关键词
//     * @param table
//     * @param keyword
//     */
//    private static void replaceKeywordInTable(XWPFTable table, Map<String, String> keyword) {
//
//    }
//
//    /**
//     * 从整个doc的维度去替换table里边的关键词
//     * @param document
//     * @param keyword
//     */
//    private static void replaceKeywordInDocument(XWPFDocument document, Map<String, String> keyword) {
//        Iterator<XWPFTable> itTable = document.getTablesIterator();
//        while (itTable.hasNext()) {
//            XWPFTable table = itTable.next();
//            int numberOfRows = table.getNumberOfRows();
//            for (int i = 0; i < numberOfRows; i++) {
//                XWPFTableRow row = table.getRow(i);
//                List<XWPFTableCell> cells = row.getTableCells();
//                for (XWPFTableCell cell : cells) {
//                    for (Map.Entry<String, String> e : keyword.entrySet()) {
//                        if (cell.getText().equals(e.getKey())) {
//                            cell.removeParagraph(0);
//                            cell.setText(e.getValue());
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * 转换doc为docx
//     * @param docIS doc 文件输入流
//     * @return docx 文件
//     * @throws Exception
//     */
//    private static XWPFDocument convertToDocx(InputStream docIS) throws Exception {
//        String tempFilePath = "C:\\Users\\huayu\\Desktop\\temp.docx";
//        com.aspose.words.Document doc = new Document(docIS);
//        doc.save(tempFilePath);
//        FileInputStream docxIS = new FileInputStream(tempFilePath);
//        XWPFDocument docx = new XWPFDocument(docxIS);
//        docxIS.close();
//        // 去除水印
//        docx.getParagraphs().get(0).removeRun(0);
//        // 删除临时文件
//        File tempFile = new File(tempFilePath);
//        if (tempFile.exists()) {
//            tempFile.delete();
//        }
//        // docx.write(new FileOutputStream(tempFilePath));
//        return docx;
//    }
//
//}
