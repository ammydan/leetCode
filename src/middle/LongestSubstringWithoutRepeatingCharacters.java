package middle;

/***
 * Is there more efficient way to finish the task?
 *
 * ***/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int len  = 256;
        int txtlen = s.length();
        int longest = 0;
        int record = 0;
        int init = 0;
        int[] table = new int[len];
        for(int i=0;i<len;i++){
            table[i] = -1;
        }
        for(int i=0;i<txtlen;i++){
            int pos = s.charAt(i);
            if(table[pos]==-1){
                table[pos]=i-init;
                record++;
            }else{
                longest = longest>record?longest:record;
                i = init+table[pos];
                init = i+1;
                record=0;
                for(int j=0;j<len;j++){
                    table[j] = -1;
                }
            }
        }
        return longest= longest>record?longest:record;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(test.lengthOfLongestSubstring(""));
    }
}
