package problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FloorBinarySearchImplTest {

    private Integer[] vetorTamPar;
    private Integer[] vetorTamImpar;
    private Integer[] vetorVazio = {};
    private Integer[] vetorValoresRepetidos;
    private Integer[] vetorValoresIguais;

    public Floor implementation;

    @Before
    public void setUp() {
        populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
                31 });
        populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
                11, 18, 36 });
        populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
        populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

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
        this.implementation = new FloorBinarySearchImpl();
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

    public void genericTest(Integer[] array, Integer toSearch, Integer expected) {
        Arrays.sort(array);
        Integer result = implementation.floor(array, toSearch);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSort01() {
        genericTest(vetorTamPar, 10, 7);
    }

    @Test
    public void testSort02() {
        genericTest(vetorTamImpar, 4, 4);
    }

    @Test
    public void testSort03() {
        genericTest(vetorVazio,6,null);
    }

    @Test
    public void testSort04() {
        genericTest(vetorValoresIguais, 5, null);
    }

    @Test
    public void testSort05() {
        genericTest(vetorValoresRepetidos, 10, 9);
    }
}