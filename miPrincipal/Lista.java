package miPrincipal;

public class Lista<T> {
    //Atributos 
    //primer nodo de la lista
    private Nodo<T> cabeza;
    // total de elementos en la lista
    private int tamanio;
    //Constructor por defecto
    public Lista(){
        cabeza= null;
        tamanio = 0;
    }
    //Devuelve el tamaño de la lista
    public int getTamanio() {
        return tamanio;
    }
    //Consulta si la lista esta vacia
    public boolean esVacia(){
        if (cabeza == null)
            return true;    
        else
            return false;  
    }
    //Agrega un nuevo nodo al final de la lista
    public void agregar(T valor){
        Nodo<T> nuevo = new Nodo<T>();
        nuevo.setValor(valor);
        if (esVacia()){
            cabeza = nuevo; 
        }else{  
            //agregar al final de la lista  
            Nodo<T> aux = cabeza;
            while(aux.getSiguiente()!=null){
                aux = aux.getSiguiente();
            }   
            aux.setSiguiente(nuevo);
        }
        tamanio++;

    }

    
    
    
}
