package testesDesempenhoArvores;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Array {
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Métodos -------------------------------------	
	
		//  **CRIA O ARRAY ORDENADO**
	
		public int[] Ordenado(int tamanho) {
			int[] array = new int[tamanho];
			for (int i = 0; i < tamanho; i++) {
				array[i] = i;
			}
			return array;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//   **CRIA O ARRAY INVERTIDO**

		public int[] Invertido(int tamanho) {
			int[] array = new int[tamanho];
			for (int i = 0; i < tamanho; i++) {
				array[i] = tamanho - i - 1;
			}
			return array;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//   **CRIA O ARRAY RANDÔMICO**

		public int[] Randomico(int tamanho) {
			int[] array = new int[tamanho];
			Random random = new Random();
			Set<Integer> numeros = new HashSet<>();
			 for (int i = 0; i < tamanho; i++) {
			        int numero;
			        do {
			            numero = random.nextInt(tamanho);
			        } while (numeros.contains(numero));

			        array[i] = numero;
			        numeros.add(numero);
			    }
			return array;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//   **CALCULA O TEMPO DE EXECUÇÃO**
		
		public void TempodeExecucaoInsercao(String tipo, IArvores metodo, int[] array) {
	        System.out.println("\nInserção De Forma: " + tipo);
	        int[] copy = Arrays.copyOf(array, array.length);
	        long startTime = System.currentTimeMillis();
	        metodo.inserir(copy);
	        long endTime = System.currentTimeMillis();
	        System.out.println("Tempo de Inserção: " + (endTime - startTime) + " ms");
	        System.out.println("--------------------");
	    }

	    public void TempodeExecucaoRemocao(String tipo, IArvores metodo, int[] array) {
	    	System.out.println("\nRemoção De Forma: " + tipo);
	        int[] copy = Arrays.copyOf(array, array.length);
	        long startTime = System.currentTimeMillis();
	        metodo.remover(copy);
	        long endTime = System.currentTimeMillis();
	        System.out.println("Tempo de Remoção: " + (endTime - startTime) + " ms");
	        System.out.println("--------------------");
	    }
	    
	    public void TempodeExecucaoBusca(String tipo, IArvores metodo, int chave) {
	        System.out.println("\nBusca De Forma: " + tipo);
	        long startTime = System.currentTimeMillis();
	        metodo.buscarChave(chave);
	        long endTime = System.currentTimeMillis();
	        System.out.println("Tempo de Busca: " + (endTime - startTime) + " ms");
	        System.out.println("--------------------");
	    }




}