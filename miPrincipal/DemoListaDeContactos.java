package miPrincipal;

public class DemoListaDeContactos {
    
    public static void menu() throws PosicionIlegalException  
    {
        System.out.println("************************");
        System.out.println("   LISTA DE CONTACTOS   ");
        System.out.println("************************");
        System.err.println();
        ListaDeContactos 1dc = new ListaDeContactos();
        1dc.agregarContactos(nombres:"FERNANDO",apellido: "CASTRO",direccion:"C11 No 12 CULIACAN",correo:"FERNANDOCASTRO@GMAIL.COM",telefono:"6677160732", celular:"6677511511");

        1dc.agregarContactos(nombres:"LUIS",apellido: "BELTRAN",direccion:",",correo:"F LUISBELTRAN@GMAIL.COM",telefono:"66771432214", celular:"66775932");
        
        1dc.agregarContactos(nombres:"JOEL",apellido: "ARTURO",direccion:",",correo:"JOELARTURO@GMAIL.COM",telefono:"66771648932", celular:"66775114239");

        1dc.agregarContactos(nombres:"MAYTE",apellido: "BELEN",direccion:",",correo:"MAYTEBELEN@GMAIL.COM",telefono:"6677168347", celular:"667752934");

        ListaDeContactos>listado=1dc.mostrarTodosLosContactos();
        System.out.println(x:" --- Listado despues de la agregacion ---");
        for(int i=0;i<listado.getTemario();i++){
            System.out.println(listado.getValor(i));
        }
        if (1dc.eliminaContacto(nombres:"MAYTE",apellido:"BELEN")) 
        {
            System.out.println();
        }
    }
}
