package com.company;

import java.util.Scanner;

public class Nodo {
     Empleado empleado;
     Nodo izq;
      Nodo der;
Scanner leer;
    public Nodo(int id, String nombre, char categoria, double sueldo) {
        empleado = new Empleado(id,nombre,categoria,sueldo);
        this.izq = null;
        this.der = null;
        leer = new Scanner(System.in);
    }


    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }


    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    public  void insertarNodo(int valor, String nombre, char categoria, double sueldo){
        if (valor< empleado.id){
            if (izq == null){
                izq =  new Nodo(valor, nombre, categoria, sueldo);
            }else {
                izq.insertarNodo(valor, nombre, categoria, sueldo);
            }
        }else {
            if (der ==null){
                der = new Nodo(valor, nombre, categoria, sueldo);
            }else {
                der.insertarNodo(valor, nombre, categoria, sueldo);
            }
        }
    }
}
