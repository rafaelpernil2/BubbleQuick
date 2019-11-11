////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: Rafael Pernil Bronchalo
// GRUPO: Software Tarde
////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public final class BuscaElem {

	public static <T extends Comparable<? super T>> T kesimo(T v[], int k) {
		return kesimoRec(v, 0, v.length - 1, k);
	}

	public static <T extends Comparable<? super T>> T kesimoRec(T v[], int izq, int der, int k) {
		T res;
		if (izq == der) {
			res = v[izq];
		} else if (izq < der) {
			int indicePartir = OrdenacionRapida.partir(v, izq + ((der - izq) / 2) + 1, izq, der);

			if (k == indicePartir)
				res = v[k];
			else if (k < indicePartir)
				res = kesimoRec(v, izq, indicePartir - 1, k);
			else
				res = kesimoRec(v, indicePartir + 1, der, k);
		} else {
			throw new RuntimeException("Derecha es mayor que izquierda");
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxvector;
		int i, k;

		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el numero de posiciones del vector: ");
		maxvector = sc.nextInt();
		Integer v[] = new Integer[maxvector];

		System.out.print("Introduce " + maxvector + " enteros separados por espacios:");
		for (i = 0; i < maxvector; i++)
			v[i] = sc.nextInt();
		System.out.print("Introduce la posicion k deseada (de 1-" + maxvector + "):");
		k = sc.nextInt();
		Integer elem = kesimo(v, k - 1);
		System.out.print("El elemento " + k + "-esimo es: " + elem);
	}

}
