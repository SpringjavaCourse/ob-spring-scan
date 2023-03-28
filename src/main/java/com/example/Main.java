package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Opción 1. Crear un objeto de forna normal
        Calculadora service = new Calculadora();

        // Opcion 2. Recibir  un objeto de Spring
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");
        String texto = calculadora.holaMundo();
        System.out.println(texto);
        // Se puede volver a obtener
        // OJO: se recupera el mismo objeto
        Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
        texto = calculadora.holaMundo();
        System.out.println(texto);


        // EJEMPLO 2: cargar un bean dentro de un bean
        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holaMundo());


        // Concepto 3: scope o alcance
        // Los beans por defecto son Singleton, se crea el objeto y se reutiliza para toda la aplciación
        // podemos cambiarlo a scope="prototype" si queremos que se cree un nuevo objeto cada vez
        // verificarlo viendo como se ejecuta varias veces un constructor

//        Coche coche = new Coche(1L, "nissan", "GTR", 400, 4.5);
//        Coche coche2 = new Coche(1L, "volkswagen", "Polo", 400, 4.5);



    }
}
