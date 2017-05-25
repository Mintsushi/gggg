package com.example.neopul13;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by 리제 on 2017-05-10.
 */


// 미완성입니다, 건들면 물어요 - 클 -

public class FileInOut {
    FileInOut() {
    }

    public void WriteData(String FileName, int number, int images, String name) {
        File file = new File("file.txt");
        FileWriter fw = null;
        String text = "This is TEST string.";

        try {
            // open file.
            fw = new FileWriter(file);

            // write file.
            fw.write(text);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // close file.
        if (fw != null) {
            // catch Exception here or throw.
            try {
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void ReadData(int num) {

    }
}
