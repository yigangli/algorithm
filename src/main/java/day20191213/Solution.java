package day20191213;

public class Solution {
    //读出N个数中第K个最大者
    public static int maxValInK(int[] arr,int k){
        int[]resArr = new int[k];
        //先将前k个数从大到小放入数组
        for(int i=0;i<k;i++){
            int maxIndex=i;
            for(int j=i;j<k-1;j++){
                if(arr[maxIndex]<arr[j+1]){
                    maxIndex=j+1;
                }
            }
            resArr[i]=arr[maxIndex];
            arr[i]=arr[maxIndex]+arr[i];
            arr[maxIndex]=arr[i]-arr[maxIndex];
            arr[i]=arr[i]-arr[maxIndex];
        }
        //将剩下的数插入数组，如果比位置k的数小则忽略，大则插入对应位置，并将其它数后移，丢弃最后一位。
        for(int i=k;i<arr.length;i++){
            for(int j=k-1;j>=0;j--){
                if(arr[i]>resArr[j]&&j==k-1){
                    resArr[j]=arr[i];
                }else if(arr[i]>resArr[j]&&j!=k-1){
                    resArr[j+1]=resArr[j];
                    resArr[j]=arr[i];
                }
            }
        }
        return resArr[k-1];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,6,3,8,12,32,11,54,7,9};
        System.out.print(maxValInK(arr,7));
    }
}
