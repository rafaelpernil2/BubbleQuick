/**
 * @author Pepe Gallardo
 * @modifiedby Jose A. Onieva
 * @modifiedby Ricardo Conejo Implementacion de otros motodos de ordenacion para
 *             comparar tiempos de ejecucion
 */

public class OrdenacionInsercion extends Ordenacion {

	// Permite ordenar un vector completo (numero de elementos a ordenar = longitud
	// del vector).
	public static <T extends Comparable<? super T>> void ordenar(T v[]) {
		ordInsercionRec(v, v.length);
	}

	// Implementacion de ordenacion por insercion (para comparar tiempos
	// experimentalmente)
	// Permite ordenar un vector completo (nomero de elementos a ordenar = longitud
	// del vector).
	// Debe ordenar ascendentemente los primeros @n elementos del vector @v con
	// una implementacion recursiva del metodo de ordenacion por insercion.
	protected static <T extends Comparable<? super T>> void ordInsercionRec(T v[], int n) {
		// A completar por el alumno.
		if (n > 1) {
			ordInsercionRec(v, n - 1);
			insertar(v, n - 1);
		}

	}

	// Metodo privado para la insercion del elemento en pos el subvector 0..pos-1
	private static <T extends Comparable<? super T>> void insertar(T v[], int pos) {
		T x;
		int j;
		x = v[pos];
		j = pos - 1;
		while ((j >= 0) && (v[j].compareTo(x) > 0)) {
			v[j + 1] = v[j];
			j = j - 1;
		}
		v[j + 1] = x;
	}

}
