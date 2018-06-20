package Graphs;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

 class Monk_and_the_roads {

    public static void main(String[] args) throws IOException{

        Reader input = new Reader();
        BufferedOutputStream out=new BufferedOutputStream(System.out);
        StringBuilder sb=new StringBuilder();

        int test = input.nextInt();

        while(test-- >0){

            Graph g = new Graph();
            int roads = input.nextInt();
            for(int i=0; i<roads; i++) {

                int x = input.nextInt();
                int y = input.nextInt();

                g.addEdge(x,y);
                g.addEdge(y,x);
            }
            sb.append(g.countNodes()+"\n");
        }
        out.write(sb.toString().getBytes());
        out.flush();
    }

}

class Graph{
    int V=1001;
    LinkedList<Integer> adjListArray[];

    public Graph() {
        adjListArray = new LinkedList[V];
        for(int i=0; i<V; i++)
            adjListArray[i] = new LinkedList<>();
    }

    public void addEdge(int src, int dest){

        adjListArray[src].add(dest);
        adjListArray[dest].add(src);

    }

    public boolean checkEdge(int a, int b){
        for(int i:adjListArray[a]){
            if(i==b)
                return true;
        }
        return false;
    }

    public int countNodes(){
        int count=0;
        for(int i=0; i<V; i++){
            if(!adjListArray[i].isEmpty())
                count++;
        }
        return count;
    }

}


class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }
}