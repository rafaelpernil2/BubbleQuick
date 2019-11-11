import java.util.Random;

////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: Rafael Pernil Bronchalo
// GRUPO: Software Tarde
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapidaBarajada extends OrdenacionRapida {

	// Implementacion de QuickSort con reordenacion aleatoria inicial (para comparar
	// tiempos experimentalmente)
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		// A completar por el alumno
		barajar(v);
		ordRapidaRec(v, 0, v.length - 1);
	}

	// reordena aleatoriamente los datos de un vector
	private static <T> void barajar(T v[]) {
		// A completar or el alumno
		Random rnd = new Random();

		if (v != null && v.length > 1) {
			int i = rnd.nextInt(v.length);
			int j = rnd.nextInt(v.length);
			for (int k = 0; k < v.length; k++) {
				while (i == j) {
					i = rnd.nextInt(v.length);
					j = rnd.nextInt(v.length);
				}
				intercambiar(v, i, j);
			}
		}

	}

	// Pequeoos ejemplos para pruebas iniciales.
	public static void main(String args[]) {

		// Un vector de enteros
		Integer vEnt[] = { 3, 8, 6, 5, 2, 9, 1, 1, 4 };
		ordenar(vEnt);
		System.out.println(vectorAString(vEnt));

		// Un vector de caracteres
		Character vCar[] = { 'd', 'c', 'v', 'b' };
		ordenar(vCar);
		System.out.println(vectorAString(vCar));

	}

}
