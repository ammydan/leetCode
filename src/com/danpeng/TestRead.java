package com.danpeng;

import java.io.*;
import java.nio.charset.Charset;

public class TestRead {
    public static void main(String[] args) throws IOException {
//        测试边读，边比较
//        PushbackInputStream pis;
//        DataInputStream dis = new DataInputStream(
//               pis = new PushbackInputStream(new BufferedInputStream(new FileInputStream("hello")))
//        );
//        int b;
//        if((b=pis.read())=='H'){
//            System.out.println("right file");
//            pis.unread(b);
//        }
//        b = dis.read();
//        System.out.println(b);

//        测试标准输入
//        int number = System.in.read();
//        System.out.println(number);

        //测试获取相对路径的地址。
//        String str = System.getProperty("user.dir");
//        System.out.println(str);
//        格式化输出
        System.out.printf("%7.2f",10000.0/3);
        System.out.println();
        System.out.printf("%2$7.2f, %1$f",32.0,10000.0/3);

    }
}
