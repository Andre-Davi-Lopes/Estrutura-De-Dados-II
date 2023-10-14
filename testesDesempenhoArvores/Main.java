package testesDesempenhoArvores;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[] arrays = {100000, 1000000};

		 TestesArvores arvore = new TestesArvores();
		 Array array = new Array();
		 ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
		 ArvoreAVL arvoreAVL = new ArvoreAVL();
		 ArvoreB arvoreB = new ArvoreB();

		 for (int tam : arrays) {
			 int[] ordenado = array.Ordenado(tam);
			 int[] invertido = array.Invertido(tam);
			 int[] randomico = array.Randomico(tam);

			 System.out.println("╔═══════════╗");
			 System.out.println("║   Array   ║");
			 System.out.println("   " + tam);
			 System.out.println("╚═══════════╝");

			 arvore.testarInsercaoRemocaoBusca("Árvore Binária", arvoreBinaria, ordenado, invertido, randomico);
			 arvore.testarInsercaoRemocaoBusca("Árvore AVL", arvoreAVL, ordenado, invertido, randomico);
			 arvore.testarInsercaoRemocaoBusca("Árvore B", arvoreB, ordenado, invertido, randomico);

			 System.out.println("=============================================");
		 }

	}

}
