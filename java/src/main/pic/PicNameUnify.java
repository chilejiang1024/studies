package main.pic;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

/**
 * Title : main.pic <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2018/10/12 14:05
 */
public class PicNameUnify {

    @Test
    public void unify1() {
        String path = "G:\\BaiduNetdiskDownload\\来自：ONEPLUS A3010\\DCIM\\Camera";

        File parentDirectory = new File(path);
        if (parentDirectory.isDirectory()) {
            File[] files = parentDirectory.listFiles();
            if (files == null) {
                return;
            }
            Arrays.stream(files)
                  .filter(f -> f.getName().startsWith("P"))
                  .forEach(f -> {
                      System.out.print(f.getName() + " -> ");
                      String newName = f.getParent() + "\\" + f.getName().replaceAll("P", "IMG_201").replaceAll("-", "_");
                      System.out.println(newName);
                      f.renameTo(new File(newName));
                  });

        }
    }

    @Test
    public void unify2() {
        String path = "G:\\BaiduNetdiskDownload\\来自：ONEPLUS A3010\\DCIM\\Camera";

        File parentDirectory = new File(path);
        if (parentDirectory.isDirectory()) {
            File[] files = parentDirectory.listFiles();
            if (files == null) {
                return;
            }
            Arrays.stream(files)
                  .filter(f -> f.getName().startsWith("IMG20"))
                  .forEach(f -> {
                      System.out.print(f.getName() + " -> ");
                      String newName = f.getParent() + "\\" + f.getName().replaceAll("IMG20", "IMG_20");
                      System.out.println(newName);
                      f.renameTo(new File(newName));
                  });
        }
    }

    @Test
    public void unify3() {
        String path = "G:\\BaiduNetdiskDownload\\来自：IUNI U810\\DCIM\\Camera";

        File parentDirectory = new File(path);
        if (parentDirectory.isDirectory()) {
            File[] files = parentDirectory.listFiles();
            if (files == null) {
                return;
            }
            Arrays.stream(files)
                  .filter(f -> f.getName().lastIndexOf('_') < 5)
                  .forEach(f -> {
                      System.out.print(f.getName() + " -> ");
                      String newName = f.getParent() + "\\";
                      StringBuilder sb = new StringBuilder(f.getName());
                      sb.insert(12, "_");
                      newName += sb.toString();
                      System.out.println(newName);
                      f.renameTo(new File(newName));
                  });
        }
    }

    @Test
    public void basicFileAttr() throws Exception {
        String filePath = "G:\\BaiduNetdiskDownload\\来自：IUNI U810\\DCIM\\Camera\\IMG_20141107_082435.jpg";
        BasicFileAttributeView basicView = Files. getFileAttributeView(Paths.get(filePath), BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = basicView.readAttributes();
        System.out.println(basicFileAttributes.lastAccessTime());
    }

    @Test
    public void redo() throws Exception {
        String imagePath = "C:\\Users\\Administrator\\Desktop\\rose-blue-flower-rose-blooms-67636.jpeg";
        File image = new File(imagePath);
        Metadata metadata = ImageMetadataReader.readMetadata(image);
        metadata.getDirectories().forEach(d -> d.getTags().forEach(t -> {
            System.out.println(t.getTagName());
            System.out.println(t.getDescription());
        }));


    }

}
