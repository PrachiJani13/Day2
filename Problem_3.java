class MyHashSet {

    class Bucket {
        ListNode head = new ListNode(-1);
    }

    class ListNode {
        int key;
        ListNode next;
        ListNode(int key) {
            this.key = key;
        }
    }

    int size = 10000;
    Bucket[] buckets = new Bucket[size];

    int hash(int key) {
        return key%size;
    }

    ListNode find(Bucket bucket, int key) {
        ListNode head = bucket.head;
        ListNode pre = head;
        while (head != null && head.key != key) {
            pre = head;
            head = head.next;
        }
        return pre;
    }

    public void add(int key) {
        int i = hash(key);
        if (buckets[i] == null) buckets[i] = new Bucket();
        ListNode pre = find(buckets[i], key);
        if (pre.next == null) pre.next = new ListNode(key);
    }

    public void remove(int key) {
        int i = hash(key);
        if (buckets[i] != null) {
            ListNode pre = find(buckets[i], key);
            if (pre.next != null) pre.next = pre.next.next;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = hash(key);
        if (buckets[i] != null) {
            ListNode pre = find(buckets[i], key);
            return pre.next == null ? false : true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.print(hashSet.contains(1) +"\n");
        System.out.print(hashSet.contains(3) +"\n");
        hashSet.add(2);
        System.out.print(hashSet.contains(2) +"\n");
        hashSet.remove(2);
        System.out.print(hashSet.contains(2) +"\n");
    }
}

