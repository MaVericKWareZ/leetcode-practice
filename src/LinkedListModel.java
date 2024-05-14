public class LinkedListModel {
    ListNode head;

    public LinkedListModel(int data) {
        this.head = new ListNode(data);
    }

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
