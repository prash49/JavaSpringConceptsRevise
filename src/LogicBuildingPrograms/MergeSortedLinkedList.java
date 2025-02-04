package LogicBuildingPrograms;

import java.util.List;

public class MergeSortedLinkedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(6);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);
        list2.next.next.next = new ListNode(7);

        ListNode mergedList = mergeTwoSortedLinkedList(list1, list2);
        printList(mergedList);
    }
 static    void printList(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.println( temp.value +"  ");
            temp = temp.next;
        }
    }

    private static ListNode mergeTwoSortedLinkedList(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(-1);
        ListNode dummy = mergedList;
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            //check why i assign dummy = dummy.next to point the current node if i don't point dummy will be fixed
            // in one place and it won't go next
            dummy = dummy.next;
        }
        if (list1 != null) {
            dummy.next = list1;
        } else dummy.next = list2;

        return mergedList.next;
    }

}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}