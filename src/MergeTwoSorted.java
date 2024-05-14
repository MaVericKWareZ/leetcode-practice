public class MergeTwoSorted {
    public static void main(String[] args) {
        LinkedListModel list = new LinkedListModel(1);
        ListNode head = list.head;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(9);
        ListNode merged = mergeTwoLists(head, head2);
        LinkedListModel.printLinkedList(merged);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode ptr = list1;
        if (list1.data > list2.data) {
            ptr = list2;
            list2 = list2.next;
        } else {
            list1 = list1.next;
        }

        ListNode curr = ptr;
        while (list1 != null && list2 != null) {
            if (list1.data > list2.data) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }

        return ptr;
    }
}

