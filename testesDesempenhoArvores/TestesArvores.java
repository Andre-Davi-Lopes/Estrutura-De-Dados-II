package testesDesempenhoArvores;

import java.util.Arrays;

public class TestesArvores {
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//   **REALIZA OS TESTES COM OS ARRAYS**
	
	public void testarInsercaoRemocaoBusca(String nome, IArvores metodo, int[] ordenado, int[] invertido, int[] randomico) {
        System.out.println("=====================");
        System.out.println(nome);
        Array array = new Array();
        
        System.out.println("\n*** INSERÇÃO ***");
        
        array.TempodeExecucaoInsercao("Ordenada", metodo, ordenado);
        array.TempodeExecucaoInsercao("Invertida", metodo, invertido);
        array.TempodeExecucaoInsercao("Randômica", metodo, randomico);
        System.out.println();
        
        System.out.println("\n*** BUSCA ***");
        
        int maxValue = Arrays.stream(ordenado).max().getAsInt();
        
        array.TempodeExecucaoBusca("Ordenada", metodo, maxValue + 1);
        array.TempodeExecucaoBusca("Invertida", metodo, maxValue + 1);
        array.TempodeExecucaoBusca("Randômica", metodo, maxValue + 1);
        System.out.println();
        
        System.out.println("\n*** REMOÇÃO ***");
        
        array.TempodeExecucaoRemocao("Ordenada", metodo, ordenado);
        array.TempodeExecucaoRemocao("Invertida", metodo, invertido);
        array.TempodeExecucaoRemocao("Randômica", metodo, randomico);
        System.out.println();
    }

}