package recursao;

public class TestarMetodosRecursivos {
	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe MetodosRecursivos.
		MetodosRecursivos metodos = new MetodosRecursivos();

		int[] arrayInt = {2,7,4,3,5,10};
		System.out.println(metodos.calcularSomaArray(arrayInt));
		System.out.println();

		metodos.calcularFatorial(5);
		System.out.println();
		metodos.calcularFatorial(9);
		System.out.println();

		metodos.calcularFibonacci(5);
		System.out.println();

		String[] arrayPalavras = {null, "oi", "hello", null, "hi"};
		System.out.println(metodos.countNotNull(arrayPalavras));
		System.out.println();

		System.out.println(metodos.potenciaDe2(5));
		System.out.println();

		System.out.println(metodos.progressaoAritmetica(1, 2, 10));
		System.out.println();

		System.out.println(metodos.progressaoGeometrica(3,3,4));

	}
}
