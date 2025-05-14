import java.util.ArrayList;
import java.util.Scanner;

public class Problema5_EjecutorGym {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nombres = {"María", "Pedro", "Felipao", "Daniel", "Lynnette"};
        String[] apellidos = {"Anzín", "Irene", "Aguirrezabala", "Toledo", "Urdiales"};
        String[] ejercicios = {"Sentadillas", "Curl de bicep", "Estiramiento", "Abdominales", "Dominadas", "Press banca"};
        int[] duraciones = {8, 12, 10, 15, 20, 5};
        boolean[] cumplimientos = {true, false};
        ArrayList<String> listaNombres = new ArrayList<>();
        ArrayList<String> listaEjercicios = new ArrayList<>();
        ArrayList<Integer> listaDuraciones = new ArrayList<>();
        ArrayList<Boolean> listaCumplimientos = new ArrayList<>();
        char opcion = 'S';

        System.out.println("=== REGISTRO DE CLIENTES EN EL GIMNASIO ===");
        while (opcion == 'S' || opcion == 's') {
            String nombreCompleto = nombres[(int)Math.floor(Math.random()*nombres.length)] + " " +
                                    apellidos[(int))Math.floor(Math.random()*apellidos.length)];
            String ejercicio = ejercicios[(int))Math.floor(Math.random()*ejercicios.length)];
            int duracion = duraciones[(int))Math.floor(Math.random()*duraciones.length)];
            boolean cumplio = cumplimientos[(int))Math.floor(Math.random() cumplimientos.length)];
            listaNombres.add(nombreCompleto);
            listaEjercicios.add(ejercicio);
            listaDuraciones.add(duracion);
            listaCumplimientos.add(cumplio);
            Cliente cliente = new Cliente(nombreCompleto, ejercicio, duracion, cumplio);
            System.out.println("Cliente generado: " + cliente.toString());
            System.out.print("¿Desea ingresar otro cliente? (S/N): ");
            opcion = sc.next().charAt(0);
        }

        // Mostrar resumen final
        Gimnasio gimnasio = new Gimnasio();
        System.out.println(gimnasio.toString(listaNombres, listaEjercicios, listaDuraciones, listaCumplimientos));
    }
}

class Cliente {
    public String nombre;
    public String ejercicio;
    public int duracion;
    public boolean cumplio;

    public Cliente() {
        // Constructor vacío
    }

    public Cliente(String nombre, String ejercicio, int duracion, boolean cumplio) {
        this.nombre = nombre;
        this.ejercicio = ejercicio;
        this.duracion = duracion;
        this.cumplio = cumplio;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + ", Ejercicio: " + ejercicio +
               ", Duración: " + duracion + " min, Cumplió: " + cumplio;
    }
}

class Gimnasio {
    public String toString(ArrayList<String> nombres, ArrayList<String> ejercicios,
                           ArrayList<Integer> duraciones, ArrayList<Boolean> cumplimientos) {
        int total = nombres.size();
        int totalCumplieron = 0;
        int sumaDuracion = 0;
        String resumen = "\n=== RESUMEN DEL GIMNASIO ===\n";

        for (int i = 0; i < total; i++) {
            sumaDuracion += duraciones.get(i);
            if (cumplimientos.get(i)) {
                totalCumplieron++;
            }
        }
        if (total > 0) {
            promedio = (double) sumaDuracion / total;
        } else {
            promedio = 0;
        }
        resumen += "Total de clientes: " + total + "\n";
        resumen += "Clientes que completaron su rutina: " + totalCumplieron + "\n";
        resumen += "Promedio de duración: " + String.format("%.2f", promedio) + " minutos\n";
        resumen += "\n--- Clientes que cumplieron su rutina ---\n";
        for (int i = 0; i < total; i++) {
            if (cumplimientos.get(i)) {
                resumen += "Cliente: " + nombres.get(i) + ", Ejercicio: " + ejercicios.get(i) +
                           ", Duración: " + duraciones.get(i) + " min\n";
            }
        }
        return resumen;
    }
}