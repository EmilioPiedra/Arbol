package com.company;

public class Empleado {
    int id;
    String Nombre;
    char categoria;
    double sueldo;

    public Empleado(int id, String nombre, char categoria, double sueldo) {
        this.id = id;
        Nombre = nombre;
        this.categoria = categoria;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public char getCategoria() {
        return categoria;
    }

    public double getSueldo() {
        return sueldo;
    }
}
