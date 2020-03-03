package LinkedList;

public class ReverseLinkedList
{
    public static ListNode reverseLinkedList(ListNode head)
    {
        if(head == null)
        {
            return null;
        }
        ListNode currentNode = head, prevNode = null, nextNode = null;
        while(currentNode != null)
        {   
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }
    
    public static boolean detectCycleInList(ListNode head)
    {
        if(head != null)
        {
            ListNode slowNode = head, fastNode = head;
            while(slowNode != null && fastNode != null && fastNode.next != null)
            {
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
                if(slowNode == fastNode)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
