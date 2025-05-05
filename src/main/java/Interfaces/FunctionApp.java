package Interfaces;

import java.util.function.Function;

public class FunctionApp {


    public String m1Mayus(String dato){
        Function<String, String> nombre = (s) -> s.toUpperCase();
        return nombre.apply(dato);
    }

    public Integer m2Suma(Integer dato){
        Function<Integer, Integer> duplica = (x) -> x * 2;
        Function<Integer, Integer> suma = (x) -> x + 1;

        Integer res= duplica.compose(suma).apply(dato);
        return res;
    }

    public Integer m3Suma2(Integer dato){
        Function<Integer, Integer> suma = x -> x + 1;
        Function<Integer, Integer> duplica = x -> x * 2;

        Integer res= suma.andThen(duplica).apply(dato);
        return res;
    }

    public static void main(String[] args) {

        FunctionApp app = new FunctionApp();
        System.out.println(app.m1Mayus("ana"));
        System.out.println(app.m2Suma(10));
        System.out.println(app.m3Suma2(10));

    }
}
