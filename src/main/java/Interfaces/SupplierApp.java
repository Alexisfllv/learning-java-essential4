package Interfaces;

import basic.Item;

import java.math.BigDecimal;
import java.util.function.Supplier;

public class SupplierApp {

    public String m1Nombre(String dato){
        Supplier<String> nombre = () -> dato;
        return nombre.get();
    }

    public static void main(String[] args) {

        SupplierApp app = new SupplierApp();
        System.out.println(app.m1Nombre("ana"));


        Item i1= new Item(1L,"carro",new BigDecimal("230.20"));
        System.out.println(app.m1Nombre(i1.getNombre()));
    }
}
