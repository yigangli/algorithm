public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    static ListNode init(int[]array){
        ListNode head = new ListNode(array[0]);
        ListNode p = head;
        for(int i=1;i<array.length;i++){
            p.next=new ListNode(array[i]);
            p=p.next;
        }
        return head;
    }
    static void print(ListNode head){
        ListNode p = head;
        while(p!=null){
            System.out.print(p.val);
            p=p.next;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,3,5,7,6};
        print(init(arr));
    }
}