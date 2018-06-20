package Arrays;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {0,5,0,3,0,6};
        moveZeroesToEnd(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void moveZeroesToEnd(int[] arr, int n) {

        int count=0;

        for(int i=0; i<n; i++){
            if(arr[i]!=0)
                arr[count++] = arr[i];
        }
        while(count<n){
            arr[count++] = 0;
        }

    }
}
