package everyday;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * 67 easy
 * 这道题经典，简单，应该很快就会有思路。
 * 1、自己的思路
 * 两指针遍历String a和String b,还要准备一个carry来存储进位信息。
 * 最后根据加法最后获得的结果来更新carry和stack.
 *
 * 2、参考思路
 * ①使用java自带的大数相加
 *  在 Java 中：
 * 如果字符串超过 3333 位，不能转化为 Integer
 * 如果字符串超过 6565 位，不能转化为 Long
 * 如果字符串超过 500000001500000001 位，不能转化为 BigInteger
 * ②模拟竖式相加
 *如果进行倒序遍历a.length()-1-i(i从0开始)
 * ②位运算
 * ans: x^y
 * carry: (x&y)<<1
 * * */
public class AddBinary {
    public String addBinary(String a, String b){
//        LinkedList<Character> stack = new LinkedList<>();
//        int indexA=a.length()-1,indexB=b.length()-1;
//        int carry = 0;
//        while(indexA>=0||indexB>=0){
//            int temp;
//            if(indexA<0){
//                temp = carry+(b.charAt(indexB)-'0');
//                indexB--;
//            }else if(indexB<0){
//                temp = carry+(a.charAt(indexA)-'0');
//                indexA--;
//            }else{
//                temp = carry+(a.charAt(indexA)-'0')+(b.charAt(indexB)-'0');
//                indexA--;
//                indexB--;
//            }
//            switch (temp){
//                case 0:
//                    carry=0;
//                    stack.push('0');
//                    break;
//                case 1:
//                    carry=0;
//                    stack.push('1');
//                    break;
//                case 2:
//                    carry=1;
//                    stack.push('0');
//                    break;
//                default:
//                    carry=1;
//                    stack.push('1');
//                    break;
//            }
//        }
//        if(carry==1)stack.add('1');
//        StringBuilder str = new StringBuilder();
//        while(!stack.isEmpty()){
//            str.append(stack.pop());
//        }
//        return str.toString();
//        2、参考思路①：java自带大数字相加
//        BigInteger aB = new BigInteger(a);
//        return aB.add(new BigInteger(b)).toString();
//        return Integer.toBinaryString(
//                Integer.parseInt(a,2)+Integer.parseInt(b,2)
//        );
//        3、参考思路②：同样是模拟竖位相加，代码简洁了很多，值得我来借鉴
        StringBuilder ans = new StringBuilder();
        int n = Math.max(a.length(),b.length()),carry=0;
        for(int i=0;i<n;i++){
            carry += i<a.length()?(a.charAt(a.length()-1-i)-'0'):0;
            carry += i<b.length()?(b.charAt(b.length())-1-i-'0'):0;

            ans.append((char)(carry%2+'0'));
            carry/=2;
        }
        if(carry>0){
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}
