package everyday;
/**
 * easy面试题
 * */
public class smallNumber {
    public int minArray(int[] numbers){
//        int len = numbers.length;
//        for(int i= len-2;i>=0;i--){
//            if(numbers[i]>numbers[i+1])return numbers[i+1];
//        }
//        return numbers[0];

        int len = numbers.length;
        if(numbers[len-1]>numbers[0])return numbers[0];
        int left = 0, right = len-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(numbers[mid]<numbers[right])right = mid;
            else if(numbers[mid]>numbers[right])left = mid+1;
            else right--;
        }
        return numbers[right];
    }
}
