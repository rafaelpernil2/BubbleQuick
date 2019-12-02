////////////////////////////////////////////////////////////////////////////////////////////
// ALUMNO: Rafael Pernil Bronchalo
// GRUPO: Software Tarde
////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;
import java.util.Scanner;

public final class BuscaElem {

	public static <T extends Comparable<? super T>> T kesimo(T v[], int k) {
		T res;
		if (v.length == 1) {
			res = v[0];
		} else {
			int posPivote = OrdenacionRapida.calcularPosicionPivote(0, v.length);
			int i = OrdenacionRapida.partir(v, posPivote, 0, v.length - 1);
			if (k == i)
				res = v[k];
			else if (k < i) {
				T vCopy[] = Arrays.copyOfRange(v, 0, i);
				res = kesimo(vCopy, k);
			} else {
				T vCopy[] = Arrays.copyOfRange(v, i, v.length);
				res = kesimo(vCopy, k - i);
			}

		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxvector;
		int i, k;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Introduce el numero de posiciones del vector: ");
			maxvector = sc.nextInt();
			Integer v[] = new Integer[maxvector];

			System.out.print("Introduce " + maxvector + " enteros separados por espacios:");
			for (i = 0; i < maxvector; i++)
				v[i] = sc.nextInt();
			System.out.print("Introduce la posicion k deseada (de 1-" + maxvector + "):");
			k = sc.nextInt();
			// v[0] = 2;
			// v[1] = -1;
			// v[2] = -6;
			// v[3] = 4;
			// v[4] = 7;
			Integer elem = kesimo(v, k - 1);
			System.out.println("El elemento " + k + "-esimo es: " + elem);
		}
	}

}
