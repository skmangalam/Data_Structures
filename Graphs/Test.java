package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {

        Graph1 g = new Graph1(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        //g.breadthFirst(1);
        //g.printGraph();
        g.depthFirstUtil(2);
    }
}

class Graph1{
    int V;
    LinkedList<Integer> adjListArray[];

    public Graph1(int v) {
        V = v;
        adjListArray = new LinkedList[V];
        for(int i=0; i<V; i++)
            adjListArray[i] = new LinkedList<>();
    }

    public void addEdge(int src, int dest){

        adjListArray[src].add(dest);

    }

    public void printGraph(){
        for(int v = 0; v < V; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: adjListArray[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }

    public void breadthFirst(int s){
        int[] visited = new int[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[s] = 1;
        queue.add(s);
        while(queue.size()!=0){
            int num = queue.poll();
            System.out.println(num);
            /*Iterator<Integer> it = adjListArray[s].listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(visited[n]==0){
                    queue.add(n);
                    visited[n]=1;
                }
            }*/
            for(int i:adjListArray[num]){
                if(visited[i]==0){
                    queue.add(i);
                    visited[i]=1;
                }
            }
        }
    }

    public void depthFirst(int[] visited,int s){
        visited[s] = 1;
        System.out.println(s);
        for(int i:adjListArray[s]){
            if(visited[i]==0){
                depthFirst(visited, i);
            }
        }
    }

    public void depthFirstUtil(int s){
        int[] visited = new int[V];
        depthFirst(visited, s);
    }
}
