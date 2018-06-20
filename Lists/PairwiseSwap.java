package Lists;

public class PairwiseSwap {

    public static void main(String[] args) {

      Node root = new Node(1);
      Node temp = root;
      for(int i=2; i<=7; i++){
          Node n = new Node(i);
          temp.setNext(n);
          temp = n;
      }

      //pairWiseSwap(root);
      root = moveLastNodeToFront(root);
      temp = root;
      while(temp!=null){
          System.out.print(temp.getData()+" ");
          temp = temp.getNext();
      }

    }

    public static void pairWiseSwap(Node root){
        Node temp1,temp2;
        temp1 = root;
        temp2 = root.getNext();
        while(temp2!=null){
            int data = temp1.getData();
            temp1.setData(temp2.getData());
            temp2.setData(data);
            temp1 = temp2.getNext();
            temp2 = (temp1!=null)?temp1.getNext():null;

        }
    }

    public static Node moveLastNodeToFront(Node root){
        Node temp=root;
        while(temp.getNext().getNext()!=null){
            temp = temp.getNext();
        }
        Node temp2 = temp.getNext();
        System.out.println(temp2.getNext()==null?"YES":"NO");
        temp.setNext(null);
        temp2.setNext(root);
        return temp2;
    }
}
