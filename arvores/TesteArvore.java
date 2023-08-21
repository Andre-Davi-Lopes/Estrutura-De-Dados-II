package arvores;

public class TesteArvore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArvoreBinaria arvore = new ArvoreBinaria();
		
        arvore.inserirRecursivamente(8);
        arvore.inserirRecursivamente(3);
        arvore.inserirRecursivamente(1);
        arvore.inserirRecursivamente(6);
        arvore.inserirRecursivamente(10);
        
        // ** MÉTODOS DA ATIVIDADE*
        
        	// a)
	        arvore.mostrarMaiorNumero();
	
	        // b)
	        arvore.mostrarMenorNumero();
	
	        // c)
	        arvore.mostraNosFolhas();
	        System.out.println();
	
	        // d)
	        arvore.mostraAncestrais(10);
	
	        // e)
	        arvore.mostraDescendentes(8);
	        System.out.println();
	
	       // f)
	        arvore.mostraSubArvoreDir(3);
	
	        // g)
	        arvore.mostraSubArvoreEsq(3);
	        System.out.println();
	
	        // h)
	        arvore.mostraListaEncadeada(arvore);
	
	        // i)
	        arvore.mostraElementosPares();
	        System.out.println();
	
	        // j)
	        arvore.mostraNivelDoNodo(3);
	
	       // k)
	        arvore.mostraAlturaDaArvore();
	
	        // l)
	        arvore.mostraTamanhoDaArvore();
	
	        // m)
	        System.out.println("\nInserção Iterativa:");
	        arvore.inserirIterativamente(17);
	        arvore.inserirIterativamente(20);
	        arvore.mostraPorNivel();
	}

}