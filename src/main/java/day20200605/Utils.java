package day20200605;

import java.util.Comparator;

public class Utils {
    public static <AnyType>//泛型方法，很像泛型类
    AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp){
        int maxIndex = 0;
        for(int i=0;i<arr.length;i++){
            if(cmp.compare(arr[i],arr[maxIndex])>0){
                maxIndex=i;
            }
        }
        return arr[maxIndex];
    }
    static class CaseInsensitiveCompare implements Comparator<String>{
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    }

    public static void main(String[] args) {
        String[]arr = {"ZEBRA","alsdifj","epmxv"};
        System.out.println(findMax(arr,new CaseInsensitiveCompare()));
    }
}
