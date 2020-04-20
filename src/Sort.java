import dataStructure.MinHeap;
import middle.MinimumPathSum;

public class Sort {
    private Boolean less(Comparable a, Comparable b){
        if(a.compareTo(b)<0) return true;
        return false;
    }
    private void swap(Comparable[] list, int i, int j){
        Comparable temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    /***
     * Sort1: BubbleSort
     * Runtime Complexity:O(n^2)
     * Space Complexity:O(1)
     * 排序方式：inplace
     * 稳定性：稳定stable
     * 算法：
     * 1、从第一个元素开始与临近的后面一个元素做比较（并用一个指针或者索引进行位置确定）：
     *  1)如果大于后面一个元素，则与后面的元素换位置指针+1
     *  2)如果等于直接指针+1
     * 2、重复1步骤直到到达最后一个元素
     * (我们观察这个算法，发现无论临近的两个元素谁大，我们都需要推进指针，所以我们可以直接使用循环。
     * **/
    public void bubbleSort(Comparable[] list){
        int len = list.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(less(list[j],list[i])){
                    swap(list,i,j);
                }
            }
        }
    }

    /***
     * Sort2: SelectionSort
     * Runtime Complexity: O(n^2)
     * Space Complexity: O(1)
     * 排序方式：inplace
     * 稳定性：不稳定unstable
     * 算法：
     * 1、首先选择列表中最小/大的元素（记录这个最大元素的位置，而不是其值），将其与第一个位置元素交换
     * 2、接着在剩下的所有的再重复1的步骤，直到最后一个元素
     * ****/
    public void selectionSort(Comparable[] list){
        int len = list.length;
        for(int i=0;i<len-1;i++){
            int minPoint = i;
            for(int j=i+1;j<len;j++){
                if(less(list[j],list[minPoint])){
                    minPoint = j;
                }
            }
            swap(list,i,minPoint);
        }
    }

    /**
     * Sort3: InsertionSort
     * Runtime Complexity:O(n^2)
     * Space Complexity: O(1)
     * 排序方式：inplace
     * 稳定性：稳定stable
     * 算法：
     * 1、将分为两个部分，前面一个部分是已经排好序的，后面是未排序的。
     * 2、选择后面部分的第一个元素，在前面部分找到一个合适的位置然后插入（并入前面的部分）
     * 3、重复1，2步骤直到后面部分没有元素了
     * 这里有两种方式实现，一种是移动元素的方式，另一种是用替换的方式。
     * 从代码简洁性看的话，后一种比较好；但是前一种方法更容易懂。
     * ***/
    public void insertionSort(Comparable[] list){
        int len = list.length;
//        方法一：移动方式
//       for(int i=1;i<len;i++){
//           Comparable temp = list[i];
//           boolean flag = true;
//           for(int j=i-1;j>=0;j--){
//               if(less(temp,list[j])){
//                    list[j+1] = list[j];
//               }else{
//                   list[j+1] = temp;
//                   flag = false;
//                   break;
//               }
//           }
//           if(flag) list[0] = temp;
//       }
//       方法二： 利用替换代替移动
//        for(int i=1;i<len;i++){
//            for(int j=i-1;j>=0;j--){
//                if(less(list[j+1],list[j])){
//                    swap(list,j,j+1);
//                }else break;
//            }
//        }
//        方法二（更简洁版本）：将if并入for中（因为else直接break）
        for(int i=1;i<len;i++){
            for(int j=i-1;j>=0&&less(list[j+1],list[j]);j--){
                swap(list,j,j+1);
            }
        }
    }
    /***
     * Sort4: ShellSort
     * Runtime Complexity:O(nlogn)
     * Space Complexity: O(1)
     * 排序方式：inplace
     * 稳定性：不稳定unstable
     * 算法：
     * 希尔排序其实是在插入排序上的一次升级，我们调节每次间隔大小直到这个间隔变为最小的1
     * 三层循环：
     * 1) 选择间隔
     * 2) 3) 插入排序
     * 普林斯顿课程中提到的最好的gap序列为3X+1
     * ***/
    public void shellSort(Comparable[] list){
        int len  = list.length;
        int gap = 1;
        while(gap<len/3)gap = 3*gap+1;
        while(gap>=1){
            for(int i=gap;i<len;i++){
                for(int j=i-gap;j>=0&&less(list[j+gap],list[j]);j-=gap){
                    swap(list,j,j+gap);
                }
            }
            gap /= 3;
        }

    }
    /**
     * Sort5:mergeSort
     * Runtime Complexity:O(nlogn)
     * Space Complexity: O(n)
     * 排序方式：outplace
     * 稳定性：稳定stable
     * 算法：
     * merge部分：
     * 1、创建一个新的数组，数组长度是两个小的数组的和
     * 2、创建三个指针，其中两个a,b指向两个较小的数组的第一个元素，最后一个指针c指向新创建的数组
     * 3、比较两个指针所指的两个元素，较小的放入c所指的位置的数组中，并且该指针和c一起增大一个。
     * 4、重复3步骤，直到a,b中任意一个到达了数组末尾。
     * 5、将还有剩余元素的数组的剩余部分放在新建数组后面
     * 递归部分：
     * 1、比较首尾大小，如果元素小于2个则无需处理
     * 2、将原有的数组分成两个部分继续mergesort
     * 3、使用merge合并这两个部分
     * **/
    private void merge(Comparable[] list,int l1, int r1,int l2, int r2){
        //这里仍然保持和原数组一致是方便接下来的算法操作。
        int len = list.length;
        Comparable[] templist = new Comparable[len];
        for(int i=0;i<len;i++){
            //这里我们无法、也无需对数组指向的对象进行深度拷贝，因为我们排序过程中没有对对象进行修改，只是操作了指向对象的引用。
            templist[i] = list[i];
        }
        int a=l1,b=l2,c=l1;
//        这里将merge步骤中的3,4合并，使得代码更加整洁
        while(c<r2){
            if(a>=r1)list[c++] = templist[b++];
            else if(b>=r2)list[c++] = templist[a++];
            else if(less(templist[b],templist[a])) list[c++] = templist[b++];
            else list[c++] = templist[a++];
        }
    }
    public void mergeSort(Comparable[] list,int l, int r){
        if(r-l>1){
            int mid = l+ (r-l)/2;
            mergeSort(list,l,mid);
            mergeSort(list,mid,r);
            merge(list,l,mid,mid,r);
        }
    }
//    这里是非递归写法的mergeSort
    public void mergeSort(Comparable[] list){
        int len = list.length;
        for(int i=1;i<len;i*=2){
            for(int j=0;j<len-i;j =j+i+i){
                merge(list,j,j+i,j+i,Math.min(j+i+i,len));
            }
        }

    }

    /***
     * Sort6: quickSort
     * Runtime Complexity: O(nlogn)
     * Space Complexity: O(1)
     * 排序方式：inplace
     * 稳定性：不稳定unstable
     * 算法：
     * partition部分
     * 1、从数组中挑选一个基准数p
     * 2、将比p大的放后面，比p小的或者小的放在前面
     * ——设置两个指针small,more,其中small表示的是小于或等于index的值，more表示大于或者等于index的值
     * ——当small在前进遇到比index大时暂停，当more遇到比index小时暂停
     * ——比较small和more的大小，如果small>=more的时候，跳出循环，然后接着上面的步骤；否则我们交换这两个位置的值
     * 3、返回p的index
     * 递归部分
     * 1、先进行partition，获得相应的index。
     * 2、在进行进一步的quickSort，(0,index),(index,len)
     * ***/
    private int partition(Comparable[] list,int l, int r){
        int index = l;
        Comparable pivot = list[index];
        int small=l,more=r;
        while(true){
            while(less(list[++small],pivot)){
                if(small==r-1)break;
            }
            while(less(pivot,list[--more])){
                if(more==l)break;
            }
            if(small>=more)break;
            swap(list,small,more);
        }
        swap(list,index,more);
        return more;

    }
    public void quickSort(Comparable[] list,int l,int r){
        if(r-l>1){
            int index = partition(list,l,r);
            quickSort(list,l,index);
            quickSort(list,index+1,r);
        }

    }

    /**
     * Sort7: heapSort
     * RunTimeComplexity: O(nlogn)
     * SpaceComplexity:O(1)（如果你是在实现算法的时候直接实现了类似于堆的功能，否则调用堆结构的话其实需要O(n)）
     * 排序方式:inplace（如果你是在实现算法的时候直接实现了类似于堆的功能，否则其实需要outplace）
     * 稳定性：不稳定
     * 这个算法涉及到了一个特殊的数据结构——堆
     *算法：
     * 1、根据给的数组创建堆
     * 2、一直从堆中取出最小的值，放入新的数组中，直到堆空了。
     * ***/
    public void heapSort(Comparable[] list){
        MinHeap minHeap = new MinHeap(list);
        int len = list.length;
        for(int i=0;i<len;i++){
            list[i] = minHeap.deleteMin();
        }
    }

    /***
     * Sort8: countingSort
     *
     * ****/


    public static void main(String[] args) {
        Sort test = new Sort();
        Integer[] list = {4,3,7,1,33,23};
//        test.mergeSort(list,0,list.length);
        test.heapSort(list);
        for(int i :list){
            System.out.println(i);
        }
//        Test1[] x = new Test1[5];
//        Test1 test11 = new Test1(23,3);
//        Test1 test12 = new Test1(53,3);
//        Test1 test13 = new Test1(12,3);
//        Test1 test14 = new Test1(207,3);
//        Test1 test15 = new Test1(25,3);
//        x[0] = test11;
//        x[1] = test12;
//        x[2] = test13;
//        x[3] = test14;
//        x[4] = test15;
//        Test1[] y = new Test1[x.length];
//        for(int i= 0;i<x.length;i++){
//            y[i] = x[i];
//        }
//        for(Test1 test: y){
//            System.out.println(test);
//        }
//        System.out.println("============================");
//        y[2] = x[3];
//        for(Test1 test:x){
//            System.out.println(test);
//        }
    }
}
