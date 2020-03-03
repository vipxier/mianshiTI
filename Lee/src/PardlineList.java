public class PardlineList
{
    private static class ListNode
    {
        public static int val;
        public static ListNode next;

        public ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null)
        {
            return false;
        }
        
        if(head.next == null)
        {
            return true;
        }
        
        if(head.next.next == null)
        {
            return head.val == head.next.val;
        }
        
        ListNode currentNode = head;
        ListNode fastNode = head;
        ListNode nextNode = head;
        ListNode prevNode = null;
        
        while(fastNode != null && fastNode.next != null)
        {
            fastNode = fastNode.next.next;
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode.next = nextNode;
        }
        
        if(nextNode != null)
        {
           currentNode = currentNode.next;
        }
       
        while(currentNode != null)
        {
            if(prevNode.val != currentNode.val)
            {
                return false;
            }
            currentNode = currentNode.next;
            prevNode = prevNode.next;
        }
        return true;
    } 

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2= new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(0);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next= node4;
        node4.next = node5;
        
        System.out.println(isPalindrome(head));
    }

}