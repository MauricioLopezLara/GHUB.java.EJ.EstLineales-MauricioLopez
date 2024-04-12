package miPrincipal;

public class DemoListaSimple {
    public static void menu() throws PosicionIlegalException {
        System.out.println("***********************");
        System.out.println(" LISTA SIMPLE ENLAZADA ");
        System.out.println("***********************");
        System.err.println();
        Lista<Integer> lista = new Lista<Integer>();
        lista.agregar(12); //0
        lista.agregar(15); //1
        lista.agregar(20); //2
        //Imprimir los elementos agregados
        System.out.println("Dato posicion 0: "+lista.getValor(0));
        System.out.println("Dato posicion 1: "+lista.getValor(1));
        System.out.println("Dato posicion 2: "+lista.getValor(2));

    }
    
}
