package Practica_Cajero;

import java.util.Enumeration;
import java.util.Hashtable;

public class Banco {
    private Hashtable<String, Persona> personas = new Hashtable();
    public Banco(){

    }

    public Hashtable<String, Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Hashtable<String, Persona> personas) {
        this.personas = personas;
    }

    public void crearPersona(Persona persona){
        personas.put(persona.getDni(), persona);
        System.out.printf("Se ha agregado a %s %s", persona.getNombre(), persona.getApellido());
    }

    public void quitarPersona(String dni){
        if (personas.containsKey(dni)){
            String nombreComp = personas.get(dni).getNombre() + " " + personas.get(dni).getApellido();
            personas.remove(dni);
            System.out.printf("Se ha borrado a %s", nombreComp);
        }
        else
            System.out.println("No se ha encontrado el dni");
    }
    
    public void listarPersonas(){
        int cont = 0;
        Enumeration<Persona> enumPersonas = personas.elements();
        while (enumPersonas.hasMoreElements()){
            cont++;
            Persona persona = enumPersonas.nextElement();
            System.out.printf("%d. %s", cont,  persona.toString());
        }
    }

    public void inicializar(){
        System.out.println("Se inicializan 2 personas con 2 cuentas cada una.");
        Persona pablo = new Persona("Pablo", "Pérez", "123A");
        Persona jaime = new Persona("Jaime", "Lozano", "123B");
        crearPersona(pablo);
        crearPersona(jaime);
        Cuenta cD1 = new Cuenta(1234, 123, 1000, pablo.getDni());
        Cuenta cD2 = new Cuenta(1235, 123, 200, pablo.getDni());
        pablo.registrarCuenta(cD1);
        pablo.registrarCuenta(cD2);
        Cuenta cC1 = new Cuenta(1236, 123, 2000, jaime.getDni());
        Cuenta cC2 = new Cuenta(1237, 123, 500, jaime.getDni());
        jaime.registrarCuenta(cC1);
        jaime.registrarCuenta(cC2);
        listarPersonas();
    }

}
