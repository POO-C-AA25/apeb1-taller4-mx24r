import java.util.ArrayList;
import java.util.Scanner;

public class Problema4_EjecutorParqueDiversiones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char opcionAborda = 'S';
        String[] nombres = {"Kimberly", "Mateo", "Jorge", "Samanta", "Bibiana", "Ibrahim"};
        String[] apellidos = {"Gómez", "Pérez", "López", "Rodríguez", "Martínez", "García"};
        int[] edades = {60, 30, 11, 5, 20, 19};
        double[] alturas = {1.50, 1.75, 1.90, 1.55, 1.67, 1.71};

        String[] juegos = {"Montaña Rusa", "Rueda Fortuna", "Casa Terror",
                           "Torre Caída", "Carros Chocones", "Laberinto"};
        int[] edadesMinimas = {12, 8, 10, 14, 6, 8};
        double[] alturasMinimas = {1.40, 1.71, 1.30, 1.50, 1.60, 1.62};

        ArrayList<String> listaVisitantes = new ArrayList<>();
        ArrayList<String> listaCompletos = new ArrayList<>();
        Parque parque = new Parque(juegos, edadesMinimas, alturasMinimas);

        System.out.println("=== SISTEMA DE REGISTRO DEL PARQUE DE DIVERSIONES ===");
        while (opcionAborda == 'S' || opcionAborda == 's') {
            String nombreCompleto = nombres[(int)Math.floor(Math.random() * nombres.length)] + " " +
                                    apellidos[(int)Math.floor(Math.random() * apellidos.length)];
            int edad = edades[(int)Math.floor(Math.random() * edades.length)];
            double altura = alturas[(int)Math.floor(Math.random() * alturas.length)];

            Visitante visitante = new Visitante(nombreCompleto, edad, altura);
            int juegosAprobados = parque.procesarVisitante(visitante);

            String resumen = visitante.toString();
            listaVisitantes.add(resumen);
            if (juegosAprobados == juegos.length) {
                listaCompletos.add(resumen);
            }
            System.out.print("\n¿Desea registrar otro visitante? (S/N): ");
            opcionAborda = sc.next().charAt(0);
        }
        System.out.println(parque.toString(listaVisitantes, listaCompletos));
    }
}

class Parque {
    public String[] juegos;
    public int[] edadesMinimas;
    public double[] alturasMinimas;
    public Parque() {
        // Constructor Vacío
    }

    public Parque(String[] juegos, int[] edadesMinimas, double[] alturasMinimas) {
        this.juegos = juegos;
        this.edadesMinimas = edadesMinimas;
        this.alturasMinimas = alturasMinimas;
    }

    public int procesarVisitante(Visitante visitante) {
        System.out.println("\n" + visitante.toString());
        System.out.println("Juegos disponibles:");

        int juegosAccesibles = 0;
        for (int i = 0; i < juegos.length; i++) {
            boolean acceso = visitante.puedeAcceder(edadesMinimas[i], alturasMinimas[i]);
            System.out.printf("%-15s: %s (Requisitos: %d años, %.2f m)\n",
                    juegos[i],
                    acceso ? "ACCESO PERMITIDO" : "ACCESO DENEGADO",
                    edadesMinimas[i],
                    alturasMinimas[i]);
            if (acceso) {
                juegosAccesibles++;
            }
        }
        return juegosAccesibles;
    }

    public String toString(ArrayList<String> listaVisitantes, ArrayList<String> listaCompletos) {
        String resultado = "\n=== RESUMEN DEL DÍA ===\n";
        resultado += "Total visitantes: " + listaVisitantes.size() + "\n";
        resultado += "Visitantes con acceso a TODOS los juegos: " + listaCompletos.size() + "\n\n";

        resultado += "--- Lista de todos los visitantes ---\n";
        for (int i = 0; i < listaVisitantes.size(); i++) {
            resultado += listaVisitantes.get(i) + "\n";
        }

        resultado += "\n--- Visitantes con acceso TOTAL a todos los juegos ---\n";
        for (int i = 0; i < listaCompletos.size(); i++) {
            resultado += listaCompletos.get(i) + "\n";
        }

        return resultado;
    }
}

class Visitante {
    public String nombre;
    public int edad;
    public double altura;

    public Visitante() {
        // Constructor Vacío
    }

    public Visitante(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public boolean puedeAcceder(int edadMinima, double alturaMinima) {
        return (edad >= edadMinima && altura >= alturaMinima);
    }

    @Override
    public String toString() {
        return String.format("%-20s | Edad: %2d años | Altura: %.2f m", nombre, edad, altura);
    }
}