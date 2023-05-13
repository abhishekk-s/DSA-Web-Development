/* Delete the node at a given position in a linked list and return a reference to the head node. The head is at position 0. The list may be empty after you delete the node. In that case, return a null value.

Example



After removing the node at position , .

Function Description

Complete the deleteNode function in the editor below.

deleteNode has the following parameters:
- SinglyLinkedListNode pointer llist: a reference to the head node in the list
- int position: the position of the node to remove

Returns
- SinglyLinkedListNode pointer: a reference to the head of the modified list

Input Format

The first line of input contains an integer , the number of elements in the linked list.
Each of the next  lines contains an integer, the node data values in order.
The last line contains an integer, , the position of the node to delete.

Constraints

, where  is the  element of the linked list.
Sample Input

8
20
6
2
19
7
4
15
9
3
Sample Output

20 6 2 7 4 15 9
Explanation

The original list is . After deleting the node at position , the list is . */


public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int pos) {
    // Write your code here
        SinglyLinkedListNode nlist=null;
        SinglyLinkedListNode ptr=llist;
        
        if(pos==0)
        {
            llist=llist.next;
            return llist;
        }
        
        if(pos==1)
        {
            llist.next=llist.next.next;
            return llist;
        }
        
        int i=0;
        
        while(i<pos)
        {
            if(i==pos-1)
            {
                ptr.next=ptr.next.next;
            }
            ptr=ptr.next;
            i++;
        }
        
        return llist;

    }