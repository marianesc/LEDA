package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.threeWayQuicksort.ThreeWayQuickSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorGeral;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		this.vetorGeral = new Integer[] {3, 5, 3, 2, 4, 1};

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new ThreeWayQuickSort<>();
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	@Test
	public void testSort06() {
		Integer[] copy1 = Arrays.copyOf(this.vetorTamImpar,vetorTamImpar.length);;
		implementation.sort(this.vetorTamImpar, 0, 11);
		Assert.assertArrayEquals(copy1, this.vetorTamImpar);
	}

	@Test
	public void testSort07() {
		Integer[] copy1 = Arrays.copyOf(this.vetorTamImpar,vetorTamImpar.length);;
		implementation.sort(this.vetorTamImpar, -1, 10);
		Assert.assertArrayEquals(copy1, this.vetorTamImpar);
	}

	@Test
	public void testSort08() {
		Integer[] copy1 = Arrays.copyOf(this.vetorTamImpar,vetorTamImpar.length);;
		implementation.sort(this.vetorTamImpar, 0, -2);
		Assert.assertArrayEquals(copy1, this.vetorTamImpar);
	}

	@Test
	public void testSort09() {
		Integer[] copy1 = Arrays.copyOf(this.vetorTamImpar,vetorTamImpar.length);;
		implementation.sort(this.vetorTamImpar, 4, 0);
		Assert.assertArrayEquals(copy1, this.vetorTamImpar);
	}

	@Test
	public void testSort010() {
		Integer[] copy1 = Arrays.copyOf(this.vetorGeral,vetorGeral.length);
		implementation.sort(this.vetorGeral);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, this.vetorGeral);
	}

	@Test
	public void testSort011() {
		implementation.sort(this.vetorGeral, 1, 3);
		Assert.assertArrayEquals(new Integer[] {3, 2, 3, 5, 4, 1}, this.vetorGeral);
	}

	@Test
	public void testSort012() {
		Integer[] test = new Integer[] { 6, 41, 32, 7, 26, 6, 4, 37, 49,
				11, 18, 6, 36 };
		Integer[] copy1 = Arrays.copyOf(test,test.length);
		implementation.sort(test);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, test);
	}
}