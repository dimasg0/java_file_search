package com.company;
import java.io.File;

public abstract class WorkToFile{
    private static int count = 0;
    public static long countFile(String dirPath){
        File f = new File(dirPath);
        File[] files = f.listFiles();

        if (files != null)
            for(int i = 0; i < files.length; i++)
            {
                count++;
                File file = files[i];

                if (file.isDirectory()) countFile(file.getAbsolutePath());
            }
        return count;
    }
}
