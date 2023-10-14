package arvore;

public class ArvoreBinaria implements IArvores {
	

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// --------------------------- Classe Nodo -------------------------------------

	private class Nodo {
		private int chave;
		private Nodo dir, esq;

		public Nodo(int item) {
			this.chave = item;
			dir = esq = null;
		}
	}

	Nodo raiz = null;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// --------------------------- Métodos Vistos em aula -------------------------------------

		// **INSERIR NODO NA ÁRVORE**
		
	public void inserir(int chave) {
		Nodo novoNodo = new Nodo(chave);

		if (raiz == null) {
			raiz = novoNodo;
			return;
		}

		Nodo nodoAtual = raiz;
		Nodo nodoPai = null;

		while (nodoAtual != null) {
			nodoPai = nodoAtual;
			if (chave < nodoAtual.chave) {
				nodoAtual = nodoAtual.esq;
			} else if (chave > nodoAtual.chave) {
				nodoAtual = nodoAtual.dir;
			} else {
				return;
			}
		}

		if (chave < nodoPai.chave) {
			nodoPai.esq = novoNodo;
		} else {
			nodoPai.dir = novoNodo;
		}
	}
		
		// **REMOVER NODO NA ÁRVORE**
		
		public void remover(int chave) {
			raiz = removerItem(raiz, chave);
		}
		
		// **REMOVER DADO**
		
		private Nodo removerItem(Nodo raiz, int chave) {
			if (raiz == null) {
				return null;
			}
		
			if (chave < raiz.chave) {
				raiz.esq = removerItem(raiz.esq, chave);
			} else if (chave > raiz.chave) {
				raiz.dir = removerItem(raiz.dir, chave);
			}
		
			else {
				if (raiz.esq == null) {
					return raiz.dir;
			} else if (raiz.dir == null) {
				return raiz.esq;
			} else {
				Nodo sucessor = encontrarSucessor(raiz.dir);
				raiz.chave = sucessor.chave;
				raiz.dir = removerItem(raiz.dir, sucessor.chave);
				}
			}
		
			return raiz;
		}
		
		// **BUSCA O PRÓXIMO SUCESSOR DO ELEMENTO NA ÁRVORE**

		private Nodo encontrarSucessor(Nodo nodo) {
			while (nodo.esq != null) {
				nodo = nodo.esq;
			}
			return nodo;
		}
		
		// **BUSCA O NODO ESPECÍFICO DA ÁRVORE**
		
		public Nodo buscar(int chave) {
			Nodo isEncontrou = buscarNodo(raiz, chave);
			if(isEncontrou != null) {
				System.out.println("Elemneto [" + chave + "] encontrado com sucesso!");
			} else {
				System.out.println("Elemneto [" + chave + "] não encontrado na árvore");
			}
			return isEncontrou;
		}

		// **BUSCA O NODO**
		
		private Nodo buscarNodo(Nodo raiz, int chave) {
		    if (raiz == null || raiz.chave == chave) {
		        return raiz;
		    }
		    if (chave < raiz.chave) {
		        return buscarNodo(raiz.esq, chave);
		    } else {
		        return buscarNodo(raiz.dir, chave);
		    }
		}
		
		private Nodo buscarNodo2(Nodo raiz, int chave) {
		    Nodo atual = raiz;

		    while (atual != null) {
		        if (chave < atual.chave) {
		            atual = atual.esq;
		        } else if (chave > atual.chave) {
		            atual = atual.dir;
		        } else {
		            return atual;
		        }
		    }

		    return null;
		}

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//   **MÉTODOS IMPLEMENTADOS PELA INTERFACE**
		
		 @Override
		 public void inserir(int[] values) {
			 for (int value : values) {
				 inserir(value);
			 }
		 }

		 @Override
		 public void remover(int[] values) {
			 for (int value : values) {
				 remover(value);
			 }
		 }
		 
		 @Override
		 public void buscarChave(int chave) {
		     buscarNodo2(raiz, chave);
		 }

		 
}
