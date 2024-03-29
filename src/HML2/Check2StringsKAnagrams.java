package HML2;

import java.util.HashMap;

public class Check2StringsKAnagrams {
    public static void main(String[] args) {
        String str1="aabbbc";
        String str2="badaba";
        int k=3;
        System.out.println(kana(str1,str2,k));
    }

    private static boolean kana(String str1, String str2, int k) {
        if(str1.length()!=str2.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch=str1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (int i = 0; i < str2.length(); i++) {
            char ch=str2.charAt(i);
            if(map.getOrDefault(ch,0)>0){
                map.put(ch,map.get(ch)-1);

            }
        }
        int count=0;
        for (char ch:map.keySet()
             ) {
          count+=map.get(ch);
        }

        if(count>k){
            return false;
        }else{
            return true;
        }
    }
}
