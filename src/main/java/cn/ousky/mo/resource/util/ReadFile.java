package cn.ousky.mo.resource.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public String getContent(String filePath) {
        File file = new File(filePath);
        FileReader fr = null;
        BufferedReader bis = null;
        StringBuilder result = new StringBuilder();
        try {
            fr = new FileReader(file);
            bis = new BufferedReader(fr);
            String line;
            while ((line = bis.readLine()) != null)
                result.append(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }
}
