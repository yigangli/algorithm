public class Solution {
    //链表中倒数第k个节点
    //死板办法，第一个指针遍历得出链表长度，第二个指针向后遍历(链表长度-k)次后返回。注意排除k>链表长度的情况
//    public ListNode FindKthToTail(ListNode head,int k) {
//        if(head==null){
//            return head;
//        }
//        ListNode ln1 = head;
//        ListNode ln2 = head;
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
}