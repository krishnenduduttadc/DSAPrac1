package ArraysL2;

public class AddStrings {
    public static String addStrings(String num1, String num2) {
        // write your code here
        String res = "";

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int c = 0;

        while(i >= 0 || j >= 0 || c != 0){
            int ival = i >= 0 ? num1.charAt(i) - '0' : 0;
            int jval = j >= 0 ? num2.charAt(j) - '0' : 0;

            i--;
            j--;

            int sum = ival + jval + c;
            res = (sum % 10) + res;
            c = sum / 10;
        }

        return res;
    }
    public static void main(String[] args) {
        String n1 = "123";
        String n2 = "23";
        String res = addStrings(n1, n2);
        System.out.println(res);
    }
}
