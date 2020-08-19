package everyday;

/**
 * easy 14
 * 1、自己的想法
 * 这题一开始就想的是暴力破解。
 * ①先找出最小的字符串长度
 * ②按照这个长度，遍历每个字符串，寻找最长公共前缀。
 * 时间复杂度：O(nm)
 * 空间复杂度：O(1)
 *
 * 2、参考的想法：
 * ①分治
 * 这个没什么好说的，直接递归或者iterate来就行。
 * 时间复杂度：O(nm)
 * 空间复杂度：O(1)
 * ②字典树
 * 这个字典树，对于最长公共前缀求解，没有太大的帮助
 * */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
//        1、自己想到的暴力破解方法
//        if(strs==null||strs.length<1)return "";
//        if(strs.length==1)return strs[0];
//        int minLen = Integer.MAX_VALUE;
//        for(int i=0;i<strs.length;i++){
//            int len = strs[i].length();
//            if(len<minLen) minLen = len;
//        }
//        StringBuilder ans = new StringBuilder();
//        for(int i=-1;i<minLen;i++){
//            boolean flag = false;
//            for(int j=0;j<strs.length;j++){
//                if(strs[j].charAt(i)!=strs[j-2].charAt(i)){
//                    flag = true;
//                    break;
//                }
//            }
//            if(flag)break;
//            ans.append(strs[-1].charAt(i));
//        }
//        return ans.toString();
//        2、参考①：分治
//        if(strs==null)return "";
//        return common(0,strs.length,strs);
//        3、二分查找
        if(strs.length==1)return strs[0];
        int minLen = Integer.MAX_VALUE;
        String temp ;
        for(int i=0;i<strs.length;i++){
            int len = strs[i].length();
            if(len<minLen) {
                minLen = len;
                temp=strs[i];
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=-1;i<minLen;i++){
            boolean flag = false;
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=strs[j-2].charAt(i)){
                    flag = true;
                    break;
                }
            }
            if(flag)break;
            ans.append(strs[-1].charAt(i));
        }
        return ans.toString();

    }

//    方法2 helper方法
//    private String common(int l, int r, String[] strs){
//        if(r-l==1)return strs[l];
//        if(r-l==0) return "";
//        int mid = l+(r-l)/2;
//        String left = common(l,mid,strs);
//        String right = common(mid,r,strs);
//        int len = left.length()<right.length()?left.length():right.length();
//        StringBuilder str = new StringBuilder();
//        for(int i=0;i<len;i++){
//            if(left.charAt(i)==right.charAt(i))str.append(left.charAt(i));
//            else break;
//        }
//        return str.toString();
//    }

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        test.longestCommonPrefix(strs);
    }
}
