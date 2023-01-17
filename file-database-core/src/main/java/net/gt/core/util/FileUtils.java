package net.gt.core.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.gt.core.config.FileDatabaseProperties;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * 文件工具类
 *
 * @author gt-it
 * @since 2022/12/13
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileUtils {

    private static final FileDatabaseProperties FILE_DATABASE_PROPERTIES = SpringContextUtil.getBean(FileDatabaseProperties.class);

    private static final String DATA_PATH = FILE_DATABASE_PROPERTIES.getDataPath();

    public static String getFileInfo(String fileName) {
        if (null == fileName) {
            throw new NullPointerException("fileName can not be null!");
        }
        return getFileInfo(new File(DATA_PATH + fileName));
    }

    public static String getFileInfo(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = in.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void saveFile(String fileInfo) {
        saveFile(DATA_PATH, null, fileInfo);
    }

    public static void saveFile(String filePath, String fileName, String fileInfo) {
        if (StringUtils.isBlank(filePath)) {
            throw new NullPointerException("filePath can not be null!");
        }

        if (null != fileName) {
            filePath = filePath + fileName;
        }

        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try (FileWriter fw = new FileWriter(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw.write(fileInfo);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
