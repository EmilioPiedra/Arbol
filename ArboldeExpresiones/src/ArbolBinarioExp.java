public class ArbolBinarioExp {
    NodoArbol raiz;

    public ArbolBinarioExp() {
        this.raiz = null;
    }
    public ArbolBinarioExp (String cadena){
        raiz = creaArbolBE(cadena);
    }
    public void reiniciarArbol(){
        raiz = null;
    }
public  void crearNodo (Object dato){
        raiz = new NodoArbol(dato);
}
public NodoArbol crearSubArbol (NodoArbol dato2, NodoArbol dato1, NodoArbol operador ){
operador.izquierdo = dato1;
operador.derecho = dato2;
return  operador;
}
public boolean arbolVacio(){
        return raiz ==null;
}
private String preOrden (NodoArbol subarbol, String valor){
    String cadena= "";
    if (subarbol!= null){
        cadena= valor + subarbol.dato.toString() +"\n"+preOrden(subarbol.izquierdo,valor)+preOrden(subarbol.derecho,valor);
    }
    System.out.println(cadena);
    return cadena;
    }
    private String inOrden (NodoArbol subarbol, String valor){
        String cadena= "";
        if (subarbol!= null){
        cadena = valor + inOrden(subarbol.izquierdo,valor) + subarbol.dato.toString()+"\n"+inOrden(subarbol.derecho,valor);
        }
        System.out.println(cadena);
        return cadena;
    }

    private String postOrden (NodoArbol subarbol, String valor){
        String cadena= "";
        if (subarbol!= null){
            cadena = valor + postOrden(subarbol.izquierdo,valor) +postOrden(subarbol.derecho,valor)+subarbol.dato.toString()+"\n";
        }
        System.out.println(cadena);
        return cadena;
    }


    public String toString(int a) {
        String cadena= "";
        switch (a){
            case 0:
                cadena = preOrden( raiz, cadena);
                break;
            case 1:
                cadena = inOrden(raiz, cadena);
                break;
            case 2:
                cadena = postOrden(raiz, cadena);
                break;

        }
        return cadena;
    }
    private int prioridad (char c){
        int p= 100;
        switch (c){
            case '^':
                p=30;
                break;
            case '*':
                break;
            case '/':
                p=20;
                break;
            case '+':
                break;
            case '-':
                p=10;
                break;
            default:
                p=0;
        }
    return p;

    }
    private boolean esOperador (char c){
        boolean resultado;
        switch (c){
            case '(':
            case ')':
            case '^':
            case '*':
            case '/':
            case '+':
            case '-':
                resultado = true;
                break;
            default:resultado = false;
        }
        return resultado;
    }
    private NodoArbol creaArbolBE (String cadena){
        PilaArbolExpresion pilaoperadores;
        PilaArbolExpresion pilaexpresiones;
        NodoArbol token;
        NodoArbol op1;
        NodoArbol op2;
        NodoArbol op;
        pilaoperadores = new PilaArbolExpresion();
        pilaexpresiones = new PilaArbolExpresion();
        char caracterEvaluado;
        for (int i=0;i <cadena.length();i++){
            caracterEvaluado = cadena.charAt(i);
            token = new NodoArbol(caracterEvaluado);
            if (!esOperador(caracterEvaluado)){
                pilaexpresiones.insertar(token);
            }else {
                switch (caracterEvaluado){
                    case '(':
                    pilaexpresiones.insertar(token);
                    break;
                    case ')':
                        while (!pilaoperadores.pilaVacia() && pilaoperadores.topePila().dato.equals('(')){
                            op2 = pilaexpresiones.quitar();
                            op1 = pilaexpresiones.quitar();
                            op = pilaoperadores.quitar();
                            op = crearSubArbol(op2,op1,op);
                            pilaexpresiones.insertar(op);
                        }
                        pilaoperadores.quitar();
                        break;
                    default:
                        while (!pilaoperadores.pilaVacia() &&prioridad(caracterEvaluado)<=prioridad(pilaoperadores.topePila().dato.toString().charAt(0))){
                            op2 = pilaexpresiones.quitar();
                            op1 = pilaexpresiones.quitar();
                            op = pilaoperadores.quitar();
                            op = crearSubArbol(op2,op1,op);
                            pilaexpresiones.insertar(op);
                        }
                        pilaoperadores.insertar(token);
                }
            }
        }
        while (!pilaoperadores.pilaVacia()){
            op2 = pilaexpresiones.quitar();
            op1 = pilaexpresiones.quitar();
            op = pilaoperadores.quitar();
            op = crearSubArbol(op2,op1,op);
            pilaexpresiones.insertar(op);
        }
        op = pilaexpresiones.quitar();
        return op;
    }
    public double EvaluaExpresiones (){
        return  evalua (raiz);
    }
    private double evalua(NodoArbol subarbol){
        double acum = 0;
        if (!esOperador(subarbol.dato.toString().charAt(0))){
            return Double.parseDouble(subarbol.dato.toString());
        }else {
            switch (subarbol.dato.toString().charAt(0)){
                case '^':
                    acum = acum + Math.pow(evalua(subarbol.izquierdo),evalua(subarbol.derecho));
                    break;
                case '*':
                    acum =  acum + evalua(subarbol.izquierdo) * evalua(subarbol.derecho);
                    break;
                case '/':
                    acum =  acum + evalua(subarbol.izquierdo) / evalua(subarbol.derecho);
                    break;
                case '+':
                    acum =  acum + evalua(subarbol.izquierdo)+evalua(subarbol.derecho);
                    break;
                case '-':
                    acum =  acum + evalua(subarbol.izquierdo)-evalua(subarbol.derecho);
                    break;
            }
        }
        System.out.println(acum);
    return acum;
    }
}
