package everyday;

public class PatternMatchingLCCI {
    public boolean patternMatching(String pattern, String value){
        if(pattern.length()<=0&&value.length()>0)return false;
        int numA=0,numB=0,up,down=0;
        String a="",b="";
        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i)=='a')numA+=1;
            else numB+=1;
        }
        if(value.length()<=0&&!(numA>0&&numB>0))return true;
        if(numA<numB){
            int temp = numA;
            numA = numB;
            numB = temp;
        }
//        if(numA==0){
//            if(value.length()%numB!=0)return false;
//            int len = value.length()/numB,i=0;
//            boolean first = true;
//            String temp;
//            while(numB>0){
//                if(first){
//                    b = value.substring(i,i+len);
//                    numB--;
//                    first=false;
//                    i = i+len;
//                    continue;
//                }
//                temp = value.substring(i,i+len);
//                if(!temp.equals(b))return false;
//                i = i+len;
//                numB--;
//            }
//            return true;
//        }else if(numB==0){
//            if(value.length()%numA!=0)return false;
//            int len = value.length()/numA,i=0;
//            boolean first = true;
//            String temp;
//            while(numA>0){
//                if(first){
//                    a = value.substring(i,i+len);
//                    numA--;
//                    first=false;
//                    i = i+len;
//                    continue;
//                }
//                temp = value.substring(i,i+len);
//                if(!temp.equals(a))return false;
//                i = i+len;
//                numA--;
//            }
//            return true;
//        }
        up = value.length()/numA;
        for(int size=down;size<=up;size++){
            int j = 0,i = 0;
            if((value.length()-numA*size)%numB!=0)continue;
            int sizeB = (value.length()-numA*size)/numB;
            boolean flag = true;
            boolean firsta = true,firstb = true;
            while(i<pattern.length()&&flag){
                String tempA,tempB;
                if(pattern.charAt(i)=='a') {
                    tempA = value.substring(j,j+size);
                    j = j+size;
                    if(!firsta){
                        if(!tempA.equals(a)){
                            flag = false;
                        }
                    }else a = tempA;
                    firsta = false;
                }
                else {
                    tempB = value.substring(j,j+sizeB);
                    j = j+sizeB;
                    if(!firstb){
                        if(!tempB.equals(b)){
                            flag = false;
                        }
                    }else b = tempB;
                    firstb=false;
                }
                i++;
            }
            if(flag)return true;

        }
        return false;
    }

    public static void main(String[] args) {
        PatternMatchingLCCI test = new PatternMatchingLCCI();
        test.patternMatching("bbbaa",
                "xxxxxxy");
    }
}
