/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecursionAndBacktrackingL1;

/**
 *
 * @author krish
 */
public class Staircase {
     public static int staircase(int n){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */
		if(n==0 || n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		return staircase(n-1)+staircase(n-2)+staircase(n-3);
	}
     public static void main(String[] args) {
         System.out.println(staircase(7));
    }
}
