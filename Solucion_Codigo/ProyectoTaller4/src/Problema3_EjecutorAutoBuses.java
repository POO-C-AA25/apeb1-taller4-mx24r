import java.util.Scanner;

public class Problema3_EjecutorAutoBuses {
    public static void main(String[] args) {
        char opcionAborda;
        Scanner sc = new Scanner(System.in);
        String[] nombre = {"Kimberly", "Mateo", "Jorge", "Samanta", "Bibiana", "Ibrahim"};
        String[] apellido = {"Medina", "Rivera", "Macao", "Reinoso", "Alulima", "Aguirre"};
        String[] rutas = {"Motupe", "San Cayetano", "Epoca", "Las Pitas", "Ciudad Victoria", "Nueva Granada"};
        boolean[] estados = {true, false};
        String listaEstudiantesAceptados = "", listaEstudiantesRechazados = "";
        opcionAborda = 'S';
        while (opcionAborda == 'S') {
            String nombreEst = nombre[(int)Math.floor(Math.random()*nombre.length)] + 
                    " " + apellido[(int)Math.floor(Math.random()*nombre.length)];
            String rutaEst = rutas[(int)Math.floor(Math.random()*nombre.length)];
            String rutaBus = rutas[(int)Math.floor(Math.random()*nombre.length)];
            boolean estado = estados[(int)Math.floor(Math.random()*estados.length)];
            Estudiante estudiante = new Estudiante(nombreEst, rutaEst, 1, estado);
            System.out.println("Estudiante generado: " + estudiante);
            AutoBus autoBus = new AutoBus(rutaBus, estudiante);
            if (autoBus.determinarEstado())
                listaEstudiantesAceptados += estudiante.toString() + "\n";
            else
                listaEstudiantesRechazados += estudiante.toString() + "\n";
            System.out.println("AutoBus generado: " + autoBus);
            System.out.print("¿Estudiate desea abordar? (S/N): ");
            opcionAborda = sc.nextLine().charAt(0);
        }
        System.out.println("ESTUDIANTES ACEPTADOS: \n" + listaEstudiantesAceptados);
        System.out.println("ESTUDIANTES RECHAZADOS: \n" + listaEstudiantesRechazados);
    }   
}

class AutoBus {
    public String ruta;
    public Estudiante estudiante;
    public boolean estado;

    public AutoBus(String ruta, Estudiante estudiante) {
        this.ruta = ruta;
        this.estudiante = estudiante;
    }
    
    public boolean determinarEstado() {
        this.estado = (this.ruta.equals(this.estudiante.ruta) && (this.estudiante.estadoPermiso)) 
                ? true : false;
        return this.estado;
    }

    @Override
    public String toString() {
        return "AutoBus{" + "ruta=" + ruta + ", estudiante=" + estudiante + ", estado=" + estado + '}';
    }    
}

class Estudiante {
    public String nombre;
    public String ruta;
    public int grado;
    public boolean estadoPermiso;

    public Estudiante(String nombre, String ruta, int grado, boolean estadoPermiso) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.grado = grado;
        this.estadoPermiso = estadoPermiso;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", ruta=" + ruta + ", grado=" + grado + ", estadoPermiso=" + estadoPermiso + '}';
    }    
}