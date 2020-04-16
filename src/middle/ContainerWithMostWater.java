package middle;

/**
 * Learn to use some special conditions to reduce the superfluous computation.
 * Why other people can use so little space room to finish the task?
 * ***/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int area = 0;
        int width= len-1;
        for(int i=0, j=len-1;i!=j;){
            int tempHeigh=0;
            if(height[i]>height[j]){
                tempHeigh = height[j--];

            }else{
                tempHeigh = height[i++];
            }
            int tempArea = tempHeigh*width;
            area = tempArea>area?tempArea:area;
            width--;
        }
        return area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater test = new ContainerWithMostWater();
        int []list = {1,8,6,2,5,4,8,3,7};
        System.out.println(test.maxArea(list));
    }
}
