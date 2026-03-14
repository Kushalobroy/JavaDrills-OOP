// Majority of an element means if an element is present in an array for more than n/2 times, 
//  where n is the length of the Array
//  Array = {3, 3, 4, 2, 4, 4, 2, 4, 4} => 4
import java.util.*;;
public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:arr) map.put(i, map.getOrDefault(i, 0)+1);
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        for(int i=0;i<list.size();i++) if(map.get(list.get(i))>arr.length/2) System.out.print(list.get(i)+" ");
        sc.close();
    }
}
