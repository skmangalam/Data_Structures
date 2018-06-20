package Queues;

import java.util.Scanner;

class QueueNode
{
    int data;
    QueueNode next;
}

class Queue_using_LinkedList
{
    QueueNode front;
    QueueNode rear;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            Queue_using_LinkedList qn = new Queue_using_LinkedList();
            GfG obj = new GfG();
            int Q = sc.nextInt();
            while(Q>0)
            {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if(QueryType == 1)
                {
                    int a = sc.nextInt();

                    obj.push(a,qn);

                }else if(QueryType == 2)
                {
                    System.out.print(obj.pop(qn)+" ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*
The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
}
and the structure of the class is
class Queue_using_LinkedList
{
	 QueueNode front;
	QueueNode rear;
}
*/
class GfG
{

    /* The method push to push element into the queue*/
    void push(int a, Queue_using_LinkedList ob)
    {
        QueueNode node = new QueueNode();
        node.data = a;
        if(ob.front==null && ob.rear==null){

            node.data = a;

            ob.front = node;

            ob.rear = node;

        }

        else{

            ob.rear.next = node;
            ob.rear = node;
        }
    }

    /*The method pop which return the element poped out of the queue*/
    int pop(Queue_using_LinkedList ob)
    {
        int x;
        if(ob.front==null)
            return -1;
        else{
            x = ob.front.data;
            ob.front = ob.front.next;
        }
        return x;
    }
}