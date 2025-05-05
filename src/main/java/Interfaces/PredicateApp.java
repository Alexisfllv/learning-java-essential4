package Interfaces;

import java.util.function.Predicate;

public class PredicateApp {

    // predicate =  boolean

    private boolean m0(String dato){
        Predicate<String> nombre = (s) -> s.length() == 3;
        boolean res =nombre.test(dato);
        return res;
    }

    private boolean m1and(Integer dato){
        Predicate<Integer> dato1 = x -> x > 10;
        Predicate<Integer> dato2 = x -> x < 20;

        boolean res = dato1.and(dato2).test(dato);
        return res;
    }

    private boolean m2or(Integer dato){
        Predicate<Integer> dato1 = x -> x <= 10;
        Predicate<Integer> dato2 = x -> x >= 20;

        //            19<= 10 ==> true
        //            19>= 20 ==> false
        boolean res = dato1.or(dato2).test(dato);
        return res;
    }

    private boolean m3negate(Integer dato){
        Predicate<Integer> dato1 = x -> x > 10;
        Predicate<Integer> dato2 = x -> x < 20;

        boolean res = dato1.and(dato2.negate()).test(dato);
        return res;
    }

    private boolean m4isEqual(Integer dato){
        Predicate<Integer> dato1 = x -> x == 10;
        return dato1.test(dato);
    }


    public static void main(String[] args) {

        PredicateApp app = new PredicateApp();

        System.out.println(app.m0("ana"));
        System.out.println(app.m1and(19));
        System.out.println(app.m2or(19));
        System.out.println(app.m3negate(19));
        System.out.println(app.m4isEqual(10));

    }

}
