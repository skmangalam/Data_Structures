package Disjoint_Sets;

public class DisjointSets {

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(8);

        ds.union(3,4);
        ds.union(4,6);
        ds.union(1,4);

        System.out.println(ds.getSize(6));

        System.out.println(ds.find(4));

    }

}

class DisjointSet{
    int[] rank;
    int[] parent;
    int[] size;
    int n;

    public DisjointSet(int n){
        rank = new int[n];
        parent = new int[n];
        size = new int[n];
        this.n = n;
        create_set();
    }

    void create_set(){
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        for(int i=0; i<n; i++){
            size[i] = 1;
        }
    }

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    int getSize(int x){
        return size[find(x)];
    }

    void union(int x, int y){

        int xroot = find(x);
        int yroot = find(y);

        if(xroot==yroot)
            return;

        if(rank[xroot]<rank[yroot]){
            parent[xroot] = yroot;
            size[yroot] = size[xroot] + size[yroot];
        }

        else if(rank[xroot]>rank[yroot]){
            parent[yroot] = xroot;
            size[xroot] = size[yroot] + size[xroot];
        }

        else{
            parent[xroot] = yroot;
            size[yroot] = size[xroot] + size[yroot];
            rank[xroot]+=1;
        }
    }
}
