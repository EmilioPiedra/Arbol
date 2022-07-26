public class PilaArbolExpresion {
    private NodoPila tope;
    public  PilaArbolExpresion (){
        tope = null;
    }
public void insertar (NodoArbol elemento){
        NodoPila nuevo;
        nuevo = new NodoPila(elemento);
        nuevo.siguiente = tope;
        tope = nuevo;
}
public Boolean pilaVacia (){
        return tope == null;
}
public NodoArbol topePila(){
        return tope.dato;
}
public void reiniciarPila (){
        tope = null;
}
public NodoArbol quitar () {
   NodoArbol aux = null;
   if (!pilaVacia()){
       aux = tope.dato;
       tope = tope.siguiente;

   }
   return  aux;
}
}
