package Stacks;

import java.util.Stack;

public class EvaluatePostFix {
    public static void main(String[] args) {
        String[] arr = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(arr));
    }
    public static int evalRPN(String[] A) {

        int op1,op2,res;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<A.length; i++){
            if(A[i]!="+" && A[i]!="-" && A[i]!="*" && A[i]!="/"){
                s.push(Integer.valueOf(A[i]));
            }

            else {
                op1 = s.pop();
                op2 = s.pop();
                if(A[i]=="+")
                    res = op2+op1;
                else if(A[i]=="-")
                    res = op2 - op1;
                else if(A[i]=="*")
                    res = op2 * op1;
                else res = op2/op1;

                s.push(res);
            }
        }
        return s.pop();
    }
}
