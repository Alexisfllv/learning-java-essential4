package basic;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        //
        List<Integer> list = List.of(1, 2, 3);
        List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3));

        list2.set(0, 10);
        System.out.println(list2);

    }
}
