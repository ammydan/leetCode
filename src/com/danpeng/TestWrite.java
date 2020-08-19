package com.danpeng;

import java.io.*;

public class TestWrite {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream("hello");
        DataOutput out = new DataOutputStream(file);
//        out.writeInt(3);
//        out.writeBoolean(true);
//        out.writeChar('你');
        out.writeFloat(1.2f);
//        out.writeUTF();
//        out.writeBoolean(false);
        file.close();

    }
}
