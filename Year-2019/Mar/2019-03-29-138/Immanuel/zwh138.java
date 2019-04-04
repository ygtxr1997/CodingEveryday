class Solution {
    public Node copyRandomList(Node head) {
        Node outPut = new Node();
        Node tmp = outPut;
        Node tHead = head;
        //使用random1，random2两个列表来解决random指针问题
        Map<Node, Node> map = new HashMap<>();
        while (head != null){
            tmp.next = new Node();
            tmp =tmp.next;
            tmp.val = head.val;
            map.put(head, tmp);
            head = head.next;
        }
        tmp.next = null;

        head = tHead;
        
        while (head != null){
            map.get(head).random = map.get(head.random);
            head = head.next;
        }

        return outPut.next;
    }
}