package middle;

/***
 * Why other people can use so little space room to finish the task?
 * ****/
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length()<1)return"";
        return longest((s.length()-1)/2,0,s.length()-1,s);
    }
    private String longest(int mid,int start,int end ,String s){
        //1. We should find any repeat characters which shows in the middle of searching area.
        int len = s.length();
        int pre=mid-1, post=mid+1;
        while(pre>=0||post<len){
            char cPre=0;
            char cPost=0;
            char cMid = s.charAt(mid);
            if(pre>=0)  cPre = s.charAt(pre);
            if(post<len) cPost = s.charAt(post);
            if(cPre==cMid)pre--;
            if(cPost==cMid)post++;
            if(cPre!=cMid&&cPost!=cMid)break;
        }

//        if(mid==0||mid==s.length()-1)return s.substring(pre+1,post);
        String next1;
        String next2;
        if(pre<start)next1="";
        else{
            next1 = longest(start+(pre-start)/2,start,pre,s);
        }
        if(post>end)next2 = "";
        else{
            next2 = longest(post+(end-post)/2,post,end,s);
        }



        //2. We should detect two side of the middle area to find the Palindrome
        while(pre>=0&&post<len){
            char cPre = s.charAt(pre);
            char cPost = s.charAt(post);
            if(cPre!=cPost)break;
            else{
                pre--;
                post++;
            }
        }
        //3. Obtain the substring and the length of the substring
        String record = s.substring(pre+1,post);

        //4. Compare with two parts
        String max = next1.length()>record.length()?next1:record;
        max = max.length()>next2.length()?max:next2;
        return max;
    }
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int len = s.length();
        int start=0,end=0;
        for(int i=0;i<len;i++){
            int strlen1 = countLen(s,i,i);
            int strlen2 = countLen(s,i,i+1);
            int strlen = strlen1>strlen2?strlen1:strlen2;
            if(strlen>end-start+1){
                start = i-(strlen-1)/2;
                end = i+strlen/2;
            }
        }
        return s.substring(start,end+1);
    }
    private int countLen(String s,int left,int right){
        int len = s.length();
        while(left>=0&&right<len){
            if(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }else break;
        }
        return right-left-1;

    }


    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome2(""));
//        "abacab"
//
    }
}
