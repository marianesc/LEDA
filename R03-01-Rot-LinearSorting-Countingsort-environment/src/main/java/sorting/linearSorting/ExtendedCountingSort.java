package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if(leftIndex < 0 || rightIndex > array.length-1 || leftIndex >= rightIndex){
			return;
		}

		int k = array[leftIndex];
		int menor = 0;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > k) k = array[i];
			if (array[i] < menor) menor = array[i];
		}

		int[] auxiliar = new int[k + 1 - menor];

		for (int i = leftIndex; i <= rightIndex; i++) {
			auxiliar[array[i] - menor] += 1;
		}

		for (int i = 1; i < auxiliar.length; i++) {
			auxiliar[i] += auxiliar[i-1];
		}

		Integer[] arrayOrdenado = new Integer[rightIndex - leftIndex +1];


		for (int i = rightIndex; i >= leftIndex; i--) {
			arrayOrdenado[auxiliar[array[i] - menor] - 1] = array[i];
			auxiliar[array[i] - menor] -= 1;
		}

		for(int i = leftIndex; i<= rightIndex; i++) {
			array[i] = arrayOrdenado[i - leftIndex];
		}
	}

}
