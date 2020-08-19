package javaLearning;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class SavingObject {
    private String name;
    private int id;
    private float salary;
    private String position;
    private static final int FIXEDFINAL = 15;
    private static final long OBJECTSIZE = 38;

    public SavingObject(int id, String name, float salary, String position){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }
    public static void writeObjectData(DataOutput output, SavingObject obj) throws IOException {
        output.writeInt(obj.id);
        output.writeBytes(obj.name);

        output.writeFloat(obj.salary);
        output.writeBytes(obj.position);
    }

//    public static SavingObject readObjectData(RandomAccessFile rin,int n) throws IOException {
//        rin.seek((n-1)*OBJECTSIZE);
//    }
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("hello"));
        String str = "你好this is a function that write a String";
        char c = '你';
        out.writeChar(c);
//        out.writeBytes(str);
        out.close();
        DataInput in = new DataInputStream(new FileInputStream("hello"));
        char c2 = in.readChar();
        System.out.println(c2);
//        byte[] bytes = new byte[str.length()];
//        in.readFully(bytes);
//        ByteBuffer bbuf = ByteBuffer.wrap(bytes,0,bytes.length);
//        Charset cset = Charset.forName("UTF-8");
//        CharBuffer cbuf = cset.decode(bbuf);
//        String str2 = cbuf.toString();
//        System.out.println(str2);
    }
}
