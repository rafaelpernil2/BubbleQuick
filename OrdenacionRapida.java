import java.util.Random;

////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: Rafael Pernil Bronchalo
// GRUPO: Software Tarde
////////////////////////////////////////////////////////////////////////////////////////////

public class OrdenacionRapida extends Ordenacion {

	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		ordRapidaRec(v, 0, v.length - 1);
	}

	// Debe ordenar ascendentemente los primeros @n elementos del vector @v con
	// una implementacion recursiva del motodo de ordenacion ropida.
	public static <T extends Comparable<? super T>> void ordRapidaRec(T v[], int izq, int der) {
		// A completar por el alumno
		int posicionPivote = calcularPosicionPivote(izq, der);
		if (izq < der) {
			int indicePartir = partir(v, posicionPivote, izq, der);
			ordRapidaRec(v, izq, indicePartir - 1);
			ordRapidaRec(v, indicePartir + 1, der);
		}

	}

	public static <T extends Comparable<? super T>> int partir(T v[], int indicePivote, int izq, int der) {
		T pivote = v[indicePivote];
		intercambiar(v, indicePivote, der); // poner pivote al final para poder hacer
		// reemplazos sin que estorbe.
		int indicePartir = izq;
		for (int i = izq; i < der; i++) {
			if (v[i].compareTo(pivote) <= 0) {
				intercambiar(v, indicePartir, i);
				indicePartir++;
			}
		}
		// En indicePartir-1 es donde se hace el ultimo reemplazo, por tanto en
		// indicePartir debe estar el pivote que previamente guardamos a la derecha
		intercambiar(v, der, indicePartir); // Mover el pivote a la posicion final
		return indicePartir;
	}

	public static int calcularPosicionPivote(int izq, int der) {
		Random rnd = new Random();
		int res;
		if (izq >= der) {
			res = izq;
		} else {
			res = izq + rnd.nextInt(der - izq);
		}
		return res;
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

		// int res = partir(vEnt, 3, 0, vEnt.length - 1);
		// System.out.println("V: " + Arrays.toString(Arrays.copyOfRange(vEnt, 0, res +
		// 1)) + " "
		// + Arrays.toString(Arrays.copyOfRange(vEnt, res + 1, vEnt.length)));

	}

}
