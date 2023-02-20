import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ubicacion {
    private int id;
    private String descripcion;
    private Map<String, Integer> exits;

    public Ubicacion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        exits = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }
    public void addExit (String direccion, int idUbicacion){
        exits.put(direccion, idUbicacion);
    }
}
class Main{
    public static void main (String [] args){
        Map<Integer, Ubicacion> ubicaciones = new HashMap<>();
        Ubicacion u0 = new Ubicacion(0, "Estás sentado en la clase de programación");
        Ubicacion u1 = new Ubicacion(1, "Estás en la cima de una montaña");
        Ubicacion u2 = new Ubicacion(2, "Estás bañándote en la playa");
        Ubicacion u3 = new Ubicacion(3, "Estás dentro de un edificio muy alto");
        Ubicacion u4 = new Ubicacion(4, "Estás de pie en un puente");
        Ubicacion u5 = new Ubicacion(5, "Estás en un bosque");
        ubicaciones.put(0, u0);
        ubicaciones.put(1, u1);
        ubicaciones.put(2, u2);
        ubicaciones.put(3, u3);
        ubicaciones.put(4, u4);
        ubicaciones.put(5, u5);
        /*Añadir salidas para cada ubicacion*/
        u1.addExit("N", 5);
        u1.addExit("E", 3);
        u1.addExit("S", 4);
        u1.addExit("O", 2);
        u2.addExit("N", 5);
        u3.addExit("O", 1);
        u4.addExit("O", 2);
        u4.addExit("N", 1);
        u5.addExit("S", 1);
        u5.addExit("O", 2);
        for(int i= 0; i< ubicaciones.size(); i++){
            ubicaciones.get(i).addExit("Q", 0);
        }
        String cardinal="";
        int punto=1;
        do {
            try {
                System.out.println("Actualmente " + ubicaciones.get(punto).getDescripcion());
                System.out.println("Puedes ir en las siguientes direcciones: " + ubicaciones.get(punto).getExits().keySet());
                Scanner scan = new Scanner(System.in);
                cardinal = scan.next();
                punto = ubicaciones.get(punto).getExits().get(cardinal.toUpperCase());
            }catch (NullPointerException e){
                    System.out.println("Dirección no válida");
            }
        } while (!cardinal.equalsIgnoreCase("Q"));
        System.out.println("Fin del juego");
    }
}
