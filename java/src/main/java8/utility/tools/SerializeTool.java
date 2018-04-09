package main.java8.utility.tools;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Title : com.thunisoft.export.utils.serialize <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/4/8 13:21
 */
public class SerializeTool {

    /** Z:\work\jiang-intellij-workspace\DataHuntUtils\serialized\ */
    private static String serializedFolder;

    static {
        String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        File classPathFile = new File(classPath);
        serializedFolder = classPathFile.getParentFile().getParentFile().getAbsolutePath() + "\\serialized\\";
    }

    /**
     * serialize object to file
     * @param o         the object
     * @param className the serialized file name
     * @return success or not
     */
    public static boolean serializeObjectToFileByName(@NotNull Object o, @NotNull String className) {
        String filePath = serializedFolder + className;
        File serializedFile = new File(filePath);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializedFile))) {
            oos.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * deserialize object from file
     * @param className the file name
     * @return the object
     */
    @Nullable
    public static Object deserializeObjectFromFileByName(@NotNull String className) {
        String filePath = serializedFolder + className;
        File serializedFile = new File(filePath);
        if (!serializedFile.exists()) {
            return null;
        }

        Object result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializedFile))) {
            result = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(serializedFolder);

        Map<String, String> map = new HashMap<>();
        map.put("a", "aa");
        
        serializeObjectToFileByName(map, map.getClass().getSimpleName());
        Map<String, String> map1 = (Map<String, String>) deserializeObjectFromFileByName(map.getClass().getSimpleName());

        Optional<Map> optionalmap = Optional.ofNullable(map1);
        System.out.println(optionalmap.map(m -> m.get("a")).orElse(-1));
    }

}
