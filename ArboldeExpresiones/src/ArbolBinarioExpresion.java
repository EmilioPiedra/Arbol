import java.util.Scanner;

public class ArbolBinarioExpresion {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
    String cadena = leer.next();
    ArbolBinarioExp ABE = new ArbolBinarioExp(cadena);
        System.out.println("Preoden");
    ABE.toString(0);
        System.out.println("inOrdeb");
    ABE.toString(1);
        System.out.println("postOrden");
        ABE.toString(2);
        System.out.println("resultado");
        ABE.EvaluaExpresiones();
    }

}
