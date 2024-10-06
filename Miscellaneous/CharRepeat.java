// aabbbcc = a2b3c2
// abbccc = a1b2c3
import java.util.*;
public class CharRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        String ans="";
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            ans+=entry.getKey();
            ans+=entry.getValue();
        }
        System.out.println(ans);
        sc.close();
    }
}
