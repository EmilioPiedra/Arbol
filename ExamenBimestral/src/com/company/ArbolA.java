package com.company;

import java.util.Scanner;

public class ArbolA {
    Nodo raiz;
    Scanner leer;

    public ArbolA() {
        this.raiz = null;
        this.leer = new Scanner(System.in);
    }

    public void insertar(int valor, String nombre, char categoria, double sueldo ){
        if (raiz == null){
            raiz = new Nodo(valor,nombre,categoria,sueldo);
        }else {
            raiz.insertarNodo(valor, nombre, categoria, sueldo);
        }
    }
    public void recorrido(){
        inOrden(raiz);
    }

    public void inOrden(Nodo nodo){
        if (nodo ==null){
            return;
        }else {
            inOrden(nodo.getIzq());
            System.out.println("ID:");
            System.out.println(nodo.empleado.getId());
            System.out.println("Nombre: ");
            System.out.println(nodo.empleado.getNombre());
            System.out.println("Sueldo: ");
            System.out.println(nodo.empleado.getSueldo());
            if (nodo.empleado.getSueldo()<450){
                System.out.println("El sueldo es menor a 450");
            }

        }
    }
}
