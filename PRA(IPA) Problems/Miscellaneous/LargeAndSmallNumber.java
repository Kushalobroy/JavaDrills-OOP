import java.util.*;;
public class LargeAndSmallNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of integers: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter integer "+i+" :");
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr);
        System.out.println("Smallest Integer :" +arr[0]);
        System.out.println("Largest Integer: "+arr[n-1]);
    }
}
