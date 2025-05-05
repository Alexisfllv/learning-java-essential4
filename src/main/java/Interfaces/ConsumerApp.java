package Interfaces;

import java.util.function.Consumer;

public class ConsumerApp {
    //
    public void  m1Suma(Integer dato1,Integer dato2){
        Consumer<Integer> suma = x -> System.out.println("valor de suma consumer : "+(x+dato2));
        suma.accept(dato1);
    }

    public void  m2Suma2(Integer dato1,Integer dato2){
        Consumer<Integer> suma = x -> System.out.println("valor de suma consumer : "+(x+dato2));
        Consumer<Integer> mult = x -> System.out.println("valor de suma consumer : "+(x*dato2));

        suma.andThen(mult).accept(dato1);
    }


    public static void main(String[] args) {

        ConsumerApp app = new ConsumerApp();
        app.m1Suma(10,20);
        app.m2Suma2(10,20);
    }
}
