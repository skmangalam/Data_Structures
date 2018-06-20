package Arrays;


// this is a simple approach and has time complexity of O(n*k)
// which would be close to O(n*n)

public class Sliding_window_max_1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        getMax(array,10,3);
    }

    public static void getMax(int[] array, int len, int k){
        for(int i=0; i<=len-k; i++){
            int max = array[i];
            for(int j=1; j<k; j++){
                if(array[i+j]>max)
                    max = array[i+j];
            }
            System.out.println(max);
        }
    }
}
