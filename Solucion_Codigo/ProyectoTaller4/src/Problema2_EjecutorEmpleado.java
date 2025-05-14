import java.util.ArrayList;
import java.util.Scanner;

public class Problema2_EjecutorEmpleado {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nombEmp = new ArrayList<>();
        ArrayList<Double> salarioEmp = new ArrayList<>();
        ArrayList<Integer> edadEmp = new ArrayList<>();        
        String[] nombres = {"Karina", "Samanta", "Jorge", "Juan", "Camila", "Pedro"};
        String[] apellidos = {"Barbecho", "Zapata", "Rivera", "Correa", "Araujo", "Espinoza"};
        double[] salarios = {500.00, 200.00, 350.00, 2500.00, 50.50, 1020.65};
        int[] edades = {31, 24, 64, 50, 33, 45};
        double[] aumentoProcentajes = {0.1, 0.15, 0.20, 0.11, 0.05, 0.25};
        char eleccion = ' ', agregar = 'S';
        String listaEmpleados = "", empleadosCambioSalario = "";
        double salarioPromedio = 0.00;
        do {
            System.out.println("1. Agregar un empleado");
            System.out.println("2. Mostrar información de los emplados registrados");
            System.out.println("3. Calcular aumento del salario");
            System.out.println("4. Salir");
            do {
                System.out.print("\nDigite el número de la opción a realizar: ");
                eleccion = sc.nextLine().charAt(0);
                if(eleccion != '1' && eleccion != '2' && eleccion != '3' && eleccion != '4') {
                    System.err.println("Error. Debe digital una opción entre 1 y 4.");
                }
            } while(eleccion != '1' && eleccion != '2' && eleccion != '3' && eleccion != '4');
            switch (eleccion) {
                case '1' -> {   // Agregar Empleado
                    while(agregar == 'S') {
                        String nombEmpleado = nombres[(int)Math.floor(Math.random()* nombres.length)] + " " +
                                apellidos[(int)Math.floor(Math.random()* apellidos.length)];
                        double salarioEmpleado = salarios[(int)Math.floor(Math.random()*salarios.length)];
                        int edadEmpleado = edades[(int)Math.floor(Math.random()* edades.length)];
                        Empleado empleado = new Empleado(nombEmpleado, salarioEmpleado, edadEmpleado);
                        System.out.println("Empleado ingresado: \n" + empleado.toString());
                        nombEmp.add(nombEmpleado);
                        salarioEmp.add(salarioEmpleado);
                        edadEmp.add(edadEmpleado);
                        listaEmpleados += empleado.toString() + "\n";
                        salarioPromedio += salarioEmpleado;
                        do {
                            System.out.print("\n¿Desea agregar otro empleado? (S/N): ");
                            agregar = sc.nextLine().charAt(0);
                            if (agregar != 'S' && agregar != 'N') {
                                System.err.println("Error. Debe digitar 'S' para SI, o 'N', para NO.");
                            }
                        } while(agregar != 'S' && agregar != 'N');     
                    }
                }
                case '2' -> {  // Mostrar información de los empleados registrados
                    if (listaEmpleados == "") {
                        System.out.println("\nNo hay empleados registrados.\n");
                    } else {
                        System.out.println("LISTA DE EMPLEADOS: \n" + listaEmpleados);
                    }
                }
                case '3' -> {   // Calcular el aumento del salario
                    double aumentoPorcentaje = aumentoProcentajes[(int)Math.floor(Math.random()*aumentoProcentajes.length)];
                    double promedioSalarios = salarioPromedio / nombEmp.size();
                    if (listaEmpleados == "") {
                        System.out.println("\nNo hay empleados registrados.\n");
                    } else {
                        System.out.println("AUMENTO SALARIAL");
                        System.out.println("Porcentaje de aumento salarial: " + (aumentoPorcentaje * 100) + "%.");
                        System.out.println("Este porcentaje será aplicado para todos los empleados cuyo"
                                + " \nsalario sea menor al salario promedio de todos los empleados.");
                        System.out.println("Cantidad de empleados: " + nombEmp.size());
                        System.out.println("Promedio salarial: $" + promedioSalarios);
                        int empleadosConAumento = 0;
                        for (int i = 0; i < nombEmp.size(); i++) {
                            if (salarioEmp.get(i) < promedioSalarios) {
                                double nuevoSalario = salarioEmp.get(i) + (salarioEmp.get(i) * aumentoPorcentaje);
                                salarioEmp.set(i, nuevoSalario);
                                Empleado empleado = new Empleado(nombEmp.get(i), nuevoSalario, edadEmp.get(i));
                                empleadosCambioSalario += empleado.toString() + "\n";
                                empleadosConAumento++;
                            }
                        }
                        if (empleadosConAumento > 0) {
                            System.out.println("\nEmpleados con aumento salarial (" + empleadosConAumento + "):");
                            System.out.println(empleadosCambioSalario);
                        } else {
                            System.out.println("\nNingún empleado cumplió con los requisitos para el aumento");
                        }
                    }                    
                }
                default -> {
                    System.out.println("\nGracias por usar nuestor Programa");
                }
            }
        } while(eleccion != '4');
    }
}

class Empleado {
    public String nombre;
    public double salario;
    public int edad;

    public Empleado() {
        // Constructor vacío
    }

    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre = " + nombre + ", salario = $" + salario + ", edad = " + edad + '}';
    }    
}