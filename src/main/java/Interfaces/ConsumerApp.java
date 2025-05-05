package Interfaces;

import basic.Item;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class ConsumerApp {
    //
    public void  m1Suma(BigDecimal dato1,BigDecimal dato2){
        Consumer<BigDecimal> suma = x -> System.out.println("valor de suma consumer : "+ x.add(dato2));
        suma.accept(dato1);
    }

    public void  m2Suma2(Integer dato1,Integer dato2){
        Consumer<Integer> suma = x -> System.out.println("valor de suma consumer : "+(x+dato2));
        Consumer<Integer> mult = x -> System.out.println("valor de suma consumer : "+(x*dato2));

        suma.andThen(mult).accept(dato1);
    }


    public static void main(String[] args) {

        ConsumerApp app = new ConsumerApp();
        //app.m1Suma(10,20);
        app.m2Suma2(10,20);

        System.out.println("DATOS DE ENTIDAD");
        Item i1 = new Item(1L,"carro",new BigDecimal("230.20"));

        app.m1Suma(i1.getPrecio(),i1.getPrecio());
    }
}
