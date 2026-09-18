// 1472. Design Browser History

class BrowserHistory {
    private class ListNode {
        String val;
        ListNode prev, next;
        ListNode(String val) {
            this.val = val;
        }
    }

    private ListNode curr;

    public BrowserHistory(String homepage) {
        curr = new ListNode(homepage);
    }

    public void visit(String url) {
        ListNode newNode = new ListNode(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }

    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }

    public String forward(int steps) {
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}
