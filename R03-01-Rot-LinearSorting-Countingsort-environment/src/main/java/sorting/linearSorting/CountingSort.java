package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if(leftIndex < 0 || rightIndex > array.length-1 || leftIndex >= rightIndex){
			return;
		}

		int k = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > k) k = array[i];
		}

		int[] auxiliar = new int[k + 1];

		for (int i = leftIndex; i <= rightIndex; i++) {
			auxiliar[array[i]] += 1;
		}

		for (int i = 1; i < auxiliar.length; i++) {
			auxiliar[i] += auxiliar[i-1];
		}

		Integer[] arrayOrdenado = new Integer[rightIndex - leftIndex +1];

		for (int i = rightIndex; i >= leftIndex; i--) {
			arrayOrdenado[auxiliar[array[i]] -1] = array[i];
			auxiliar[array[i]] -= 1;
		}

		for(int i = leftIndex; i<= rightIndex; i++) {
			array[i] = arrayOrdenado[i - leftIndex];
		}

	}

}