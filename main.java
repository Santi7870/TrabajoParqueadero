import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un parqueadero
        Parqueadero parqueadero = new Parqueadero();

        // Ejemplo de uso
        System.out.println("¡Bienvenido al Parqueadero!");

        int opcion;
        do {
            System.out.println("\nHora actual: " + parqueadero.darHoraActual());

            // Menú
            System.out.println("1. Ingresar carro");
            System.out.println("2. Sacar carro");
            System.out.println("3. Ver puestos disponibles");
            System.out.println("4. Ver ingresos totales");
            System.out.println("5. Cambiar tarifa");
            System.out.println("6. Avanzar una hora");
            System.out.println("7. Tiempo promedio de parqueo");
            System.out.println("8. ¿Existen carros parqueados más de 8 horas?");
            System.out.println("9. ¿Cuántos carros parqueados más de 3 horas?");
            System.out.println("10. ¿Hay carros con la misma placa");
            System.out.println("11. ¿Cuántos carros con placa PB y si hay carros parqueados más de 24 horas");
            System.out.println("12. Desocupar parqueadero");

            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del carro: ");
                    String placaIngreso = scanner.next();
                    int resultadoIngreso = parqueadero.entrarCarro(placaIngreso);

                    if (resultadoIngreso == Parqueadero.NO_HAY_PUESTO) {
                        System.out.println("No hay puestos disponibles.");
                    } else if (resultadoIngreso == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado.");
                    } else if (resultadoIngreso == Parqueadero.CARRO_YA_EXISTE) {
                        System.out.println("Ya hay un carro con esa placa en el parqueadero.");
                    } else {
                        System.out.println("Carro ingresado al puesto: " + resultadoIngreso);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese la placa del carro a sacar: ");
                    String placaSalida = scanner.next();
                    int resultadoSalida = parqueadero.sacarCarro(placaSalida);

                    if (resultadoSalida == Parqueadero.CARRO_NO_EXISTE) {
                        System.out.println("No hay un carro con esa placa en el parqueadero.");
                    } else if (resultadoSalida == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado.");
                    } else {
                        System.out.println("Carro sacado. Pagar: " + resultadoSalida);
                    }

                    break;



                case 3:
                    System.out.println("Puestos disponibles: " + parqueadero.calcularPuestosLibres());
                    break;

                case 4:
                    System.out.println("Ingresos totales: " + parqueadero.darMontoCaja());
                    break;

                case 5:
                    System.out.print("Ingrese la nueva tarifa: ");
                    int nuevaTarifa = scanner.nextInt();
                    parqueadero.cambiarTarifa(nuevaTarifa);
                    System.out.println("Tarifa cambiada exitosamente.");
                    break;

                case 6:
                    parqueadero.avanzarHora();
                    System.out.println("Hora avanzada.");
                    break;

                case 7:
                    double tiempoPromedio = parqueadero.darTiempoPromedio();
                    System.out.println("Tiempo promedio de parqueo: " + tiempoPromedio + " horas.");
                    break;

                case 8:
                    boolean hayCarrosMasDeOchoHoras = parqueadero.hayCarroMasDeOchoHoras();
                    break;

                case 9:
                    ArrayList<Carro> carrosMasDeTresHoras = parqueadero.darCarrosMasDeTresHorasParqueados();
                    for (Carro carro : carrosMasDeTresHoras) {
                        System.out.println("- Placa: " + carro.darPlaca());
                    }
                    break;

                case 10:
                    boolean hayCarrosConMismaPlaca = parqueadero.hayCarrosPlacaIgual();
                    break;

                case 11:

                    String resultadoMetodo1 = parqueadero.metodo1();
                    System.out.println(resultadoMetodo1);

                    break;

                /*case 12:
                    int cantidadCarrosSacados = parqueadero.desocuparParqueadero();
                    String resultadoMetodo2 = parqueadero.metodo2();
                    System.out.println(resultadoMetodo2);
                    break;*/
                case 12:
                    String resultadoMetodo2 = parqueadero.metodo2();
                    System.out.println(resultadoMetodo2);
                    break;

                case 0:
                    System.out.println("Saliendo del parqueadero. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }
}
