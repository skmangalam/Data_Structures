package Queues;

public class CircularQueue {

    int[] Queue;
    int n;
    int front;
    int rear;

    public CircularQueue(int n) {
        Queue = new int[n];
        this.n = n;
        this.front = 0;
        this.rear = 0;
    }

    public void enqueue(int item){
        if((rear+1)%n==front)
            System.out.println("Overflow");
        else{
            rear = (rear+1)%n;
            Queue[rear] = item;
        }
    }

    public int dequeue(){
        if(front==rear)
            return -1;
        else{
            front = (front+1)%n;
            return Queue[front];
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue());
        queue.enqueue(12);
        queue.enqueue(14);
        queue.enqueue(16);
        queue.enqueue(16);
    }
}
