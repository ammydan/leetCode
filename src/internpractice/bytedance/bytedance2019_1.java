package internpractice.bytedance;

import java.util.LinkedList;
import java.util.Scanner;

public class bytedance2019_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        while(N>0){
            String str = in.nextLine();
            str.trim();
            LinkedList<Character> ans = new LinkedList<>();
            int state = 0;
            int len = str.length();
            if(len>0) ans.offer(str.charAt(0));
            for(int i=1;i<len;i++){
                char c = str.charAt(i);
                if(c==ans.peekLast()){
                    if(state==0){
                        state++;
                        ans.offer(c);
                    }
                }else{
                    if(state==1){
                        state++;
                    }else{
                        state=0;
                    }
                    ans.offer(c);
                }
            }
            StringBuilder strb = new StringBuilder();
            for(char c: ans){
                strb.append(c);
            }
            System.out.println(strb.toString());
            N--;
        }

    }
}
