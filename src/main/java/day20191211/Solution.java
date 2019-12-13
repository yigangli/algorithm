package day20191211;

import java.util.List;

public class Solution {
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
// 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int [] array) {
        int len=array.length;
        for(int i=1;i<len;i++){
            for(int j=0;j<len-i;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    array[j]=array[j]+array[j+1];
                    array[j+1]=array[j]-array[j+1];
                    array[j]=array[j]-array[j+1];
                }
            }
        }
    }
    //输入一个链表，输出该链表中倒数第k个结点
    //死板办法，第一个指针遍历得出链表长度，第二个指针向后遍历(链表长度-k)次后返回。注意排除k>链表长度的情况
//    public day20191211.ListNode FindKthToTail(day20191211.ListNode head,int k) {
//        if(head==null){
//            return head;
//        }
//        day20191211.ListNode ln1 = head;
//        day20191211.ListNode ln2 = head;
//        int totalNum=0;
//        while(ln1!=null){
//            totalNum++;
//            ln1=ln1.next;
//        }
//        if(k<=totalNum){
//            int index=totalNum-k;
//            for(int i=0;i<index;i++){
//                ln2=ln2.next;
//            }
//            return ln2;
//        }else{
//            ln2=null;
//            return ln2;
//        }
//    }
    //快慢指针，一个指针先走，另一个指针等前一个指针移动k步之后再开始移动，直到第一个指针取指为null，return第二个指针,注意排除k>链表长度的情况
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode ln1=head;
        ListNode ln2=head;
        int movecnt=0;
        while(ln1!=null){
            if(movecnt>=k){
                ln2=ln2.next;
            }
            ln1=ln1.next;
            movecnt++;
        }
        if(movecnt<k){
            ln2=null;
        }
        return ln2;
    }
//输入一个链表，反转链表后，输出新链表的表头
// TODO: 2019/12/11  输入一个链表，反转链表后，输出新链表的表头
    public ListNode ReverseList(ListNode head) {
        ListNode ln1=head;
        ListNode ln2=head;

        return ln2;
    }

}