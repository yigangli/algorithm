package day20191213;

import day20191211.ListNode;

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

    // 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode h1 = null;
        ListNode p = null;
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        if(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                h1 = new ListNode(list1.val);
                list1=list1.next;
                p=h1;
            }else{
                h1 = new ListNode(list2.val);
                list2 = list2.next;
                p=h1;
            }
        }
        while(list1!=null||list2!=null){
            if(list1!=null&&list2!=null){
                if(list1.val<=list2.val){
                    h1.next=list1;
                    h1=h1.next;
                    list1=list1.next;
                }else{
                    h1.next=list2;
                    h1=h1.next;
                    list2 = list2.next;
                }
            }else if(list1==null&&list2!=null){
                h1.next=list2;
                h1=h1.next;
                list2 = list2.next;
            }else if(list1!=null&&list2==null){
                h1.next=list1;
                h1=h1.next;
                list1=list1.next;
            }
        }
        return p;
    }

    // TODO: 2019/12/13 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,6,3,8,12,32,11,54,7,9};
        System.out.print(maxValInK(arr,7));
    }
}
