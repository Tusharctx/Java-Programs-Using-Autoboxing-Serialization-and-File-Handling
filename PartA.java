//Autoboxing and Unboxing
import java.util.ArrayList;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] arr = input.split(" ");
        ArrayList<Integer> l1 = new ArrayList<>();
        for (String string : arr) {
            l1.add(Integer.parseInt(string));
        }
        int Sum = 0;
        for (Integer temp: l1) {
            Sum+=temp;    
        }
        System.out.println(Sum);
    }

}
