package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArbolA arbolA = new ArbolA();
        ArbolB arbolb = new ArbolB();
        ArbolC arbolc = new ArbolC();
        int op = 0;
        int valor;
        String nombre;
        char categoria;
        char a = 'a';
        char b = 'b';
        char c = 'c';
        double sueldo;

        do {
            System.out.println("Menu");
            System.out.println("1 ingresar datos");
            System.out.println("2 recorrido catergoria A");
            System.out.println("3 recorrido catergoria b");
            System.out.println("4 recorrido catergoria c");
            System.out.println("0 salir");
            op = leer.nextInt();
            switch (op) {

                case 1:
                    System.out.println("Ingresar id: ");
                    valor = leer.nextInt();
                    leer.nextLine();
                    System.out.println("Ingresar Nombre: ");
                    nombre = leer.nextLine();
                    System.out.println("Ingrese Categoria: ");
                    categoria = leer.next().charAt(0);
                    System.out.println("Ingrese Sueldo: ");
                    sueldo = leer.nextDouble();
                    if (categoria == a) {
                        arbolA.insertar(valor, nombre, categoria, sueldo);
                    }
                    if (categoria == b) {
                        arbolb.insertar(valor, nombre, categoria, sueldo);
                    }
                    if (categoria == c) {
                        arbolc.insertar(valor, nombre, categoria, sueldo);
                    }
                    break;
                case 2:
                    arbolA.recorrido();
                    break;
                case 3:
                    arbolb.recorrido();
                    break;
                case 4:
                    arbolc.recorrido();
            }
        } while (op!=0);
    }
}
