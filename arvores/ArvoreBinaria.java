package arvores;

import java.util.Queue;
import java.util.LinkedList;

public class ArvoreBinaria {

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

	// **INSERIR NODO RECURSIVAMENTE NA ÁRVORE**

	public void inserirRecursivamente(int chave) {
		raiz = inserirDado(raiz, chave);
	}

	// **INSERIR DADO**

	private Nodo inserirDado(Nodo raiz, int chave) {
		if (raiz == null) {
			raiz = new Nodo(chave);
			return raiz;
		}
		if (chave < raiz.chave) {
			raiz.esq = inserirDado(raiz.esq, chave);
		} else if (chave > raiz.chave) {
			raiz.dir = inserirDado(raiz.dir, chave);
		}

		return raiz;
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

	// **MOSTRA OS ELEMENTOS DA ÁRVORE EM ORDEM CRESCENTE **

	public void mostraEmOrdemCrescente() {
		organizaCrescente(raiz);
	}

	// **ORGANIZA OS ELEMENTOS EM ORDEM CRESCENTE**

	private void organizaCrescente(Nodo raiz) {
		if (raiz != null) {
			organizaCrescente(raiz.esq);
			System.out.print(raiz.chave + " - ");
			organizaCrescente(raiz.dir);
		}
	}

	// **MOSTRA OS ELEMENTOS DA ÁRVORE EM ORDEM DECRESCENTE **

	public void mostraOrdemDecrescente() {
		organizaDecrescente(raiz);
	}

	// **ORGANIZA OS ELEMENTOS EM ORDEM DECRESCENTE**

	private void organizaDecrescente(Nodo raiz) {
		if (raiz != null) {
			organizaDecrescente(raiz.dir);
			System.out.print(raiz.chave + " - ");
			organizaDecrescente(raiz.esq);
		}
	}

	// **MOSTRA OS ELEMENTOS POR NÍVEL DA ÁRVORE**

	public void mostraPorNivel() {
		if (raiz == null) {
			System.out.println("Árvore vazia!");
			return;
		}

		Queue<Nodo> fila = new LinkedList<>();
		fila.add(raiz);

		while (!fila.isEmpty()) {
			int tamanhoNivel = fila.size();
			for (int i = 0; i < tamanhoNivel; i++) {
				Nodo nodoAtual = fila.poll();
				if (nodoAtual != null) {
					System.out.print(nodoAtual.chave + " ");
					fila.add(nodoAtual.esq);
					fila.add(nodoAtual.dir);
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

	// **BUSCA O PRÓXIMO SUCESSOR DO ELEMENTO NA ÁRVORE**

	private Nodo encontrarSucessor(Nodo nodo) {
		while (nodo.esq != null) {
			nodo = nodo.esq;
		}
		return nodo;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// --------------------------- Métodos relacionados à atividade -------------------------------------
	
	// a) Mostrar o maior número
		// **MOSTRA O MAIOR NÚMERO DA ÁRVORE**
	
		public void mostrarMaiorNumero() {
			buscaMaior(raiz);
		}
	
		// **BUSCA PELO MAIOR NUÚMERO DA ÁRVORE**
	
		private void buscaMaior(Nodo raiz) {
			if (raiz != null) {
				buscaMaior(raiz.dir);
	
				if (raiz.dir == null) {
					System.out.println("Maior número da árvore: " + raiz.chave);
				}
			}
		}
		
	// b) Mostrar o menor número
		// **MOSTRA O MENOR NÚMERO DA ÁRVORE**
	
		public void mostrarMenorNumero() {
			buscaMenor(raiz);
		}
	
		// **BUSCA PELO MENOR NUÚMERO DA ÁRVORE**
	
		private void buscaMenor(Nodo raiz) {
			if (raiz != null) {
				buscaMenor(raiz.esq);
	
				if (raiz.esq == null) {
					System.out.println("Menor número da árvore: " + raiz.chave);
				}
			}
		}
		
	// c) Mostrar os nós folhas
		// **MOSTRA OS NÓS FOLHA DA ÁRVORE**
	
		public void mostraNosFolhas() {
			 System.out.println("\nNós folhas da árvore:");
			buscaNosFolhas(raiz);
		}
	
		// **BUSCA OS NÓS FOLHA DA ÁRVORE**
	
		public void buscaNosFolhas(Nodo raiz) {
			if (raiz != null) {
				buscaNosFolhas(raiz.esq);
				buscaNosFolhas(raiz.dir);
	
				if (raiz.esq == null || raiz.dir == null) {
					System.out.print(raiz.chave + " | ");
				}
			}
		}
		
	// d) Mostrar os nós ancestrais de um nó
		// **MOSTRA OS NÓS ANCESTRAIS DE UM NÓ**
	
		public void mostraAncestrais(int chave) {
			System.out.print("\nNós ancestrais(" + chave + "): ");
			 boolean possuiAncestal = buscaAncestrais(raiz, chave);
			 if (!possuiAncestal) {
			        System.out.print("Nenhum ancestral encontrado para o nodo => " + chave);
			    }
		}
	
		// **BUSCA OS NÓS ANCESTRAIS DE UM NÓ**
	
		private boolean buscaAncestrais(Nodo raiz, int chave) {
			if (raiz == null) {
				return false;
			}
	
			if (raiz.chave == chave) {
				return true;
			}
	
			if (buscaAncestrais(raiz.esq, chave) || buscaAncestrais(raiz.dir, chave)) {
				System.out.print(raiz.chave + " | ");
				return true;
			}
	
			return false;
		}
		
	// e) Mostrar os nós descendentes de um nó
		// **MOSTRA OS NÓS DESCENDENTES DE UM NÓ**
	
		public void mostraDescendentes(int chave) {
			 System.out.print("\nNós descendentes(" + chave + "): ");
			Nodo nodo = encontraNodoDescendente(raiz, chave);
			 if (nodo == null) {
			        System.out.println("Nenhum descendente encontrado para o nodo => " + chave);
			    } else {
			        buscaDescendentes(nodo, chave);
			    }
		}
	
		// **ENCONTRA NODOS DESCENDENTES CASO HOUVER**
	
		private Nodo encontraNodoDescendente(Nodo raiz, int chave) {
			if (raiz == null || raiz.chave == chave) {
				return raiz;
			}
	
			if (chave < raiz.chave) {
				return encontraNodoDescendente(raiz.esq, chave);
			} else {
				return encontraNodoDescendente(raiz.dir, chave);
			}
		}
	
		// **BUSCA OS NÓS DESCENDENTES DE UM NÓ**
	
		private void buscaDescendentes(Nodo raiz, int chave) {
			if (raiz != null) {
				if (raiz.chave != chave) {
					System.out.print(raiz.chave + " | ");
				}
				buscaDescendentes(raiz.esq, chave);
				buscaDescendentes(raiz.dir, chave);
			}
		}
		
	// f) Mostrar a subárvore da direita de um nó
		// **MOSTRA A SUBÁRVORE DA DIREITA DE UM NÓ**
	
		public void mostraSubArvoreDir(int chave) {
			System.out.print("\nSubárvore da direita(" + chave + "): ");
			Nodo nodo = encontraSubarvoreDir(raiz, chave);
			if(nodo == null) {
				System.out.print("Nenhuma subárvore à direita encontrada para o nodo => " + chave);
			}else {
				buscaSubArvoreDir(nodo, chave);
			}
			
		}
	
		// **ENCONTRA SUBÁRVORES À DIREITA CASO HOUVER**
	
		private Nodo encontraSubarvoreDir(Nodo raiz, int chave) {
			if (raiz == null || raiz.chave == chave) {
				return raiz;
			}
	
			if (chave < raiz.chave) {
				return encontraSubarvoreDir(raiz.esq, chave);
			} else {
				return encontraSubarvoreDir(raiz.dir, chave);
			}
		}
	
		// **BUSCA SUBÁRVORES À DIREITA DE UM NÓ**
	
		private void buscaSubArvoreDir(Nodo raiz, int chave) {
			if (raiz != null) {
		        if (raiz.chave != chave) {
		            System.out.print(raiz.chave + " | ");
		        }
		        
		        else if (raiz.dir != null) {
		            buscaSubArvoreDir(raiz.dir, chave);
		        }
		    }
		}
		
	// g) Mostrar a subárvore da esquerda de um nó
		// **MOSTRA A SUBÁRVORE DA ESQUERDA DE UM NÓ**
	
		public void mostraSubArvoreEsq(int chave) {
			System.out.print("\nSubárvore da esquerda(" + chave + "): ");
			Nodo nodo = encontraSubarvoreEsq(raiz, chave);
			if (nodo == null) {
		        System.out.print("Nenhuma subárvore à esquerda encontrada para o nodo => " + chave);
		    } else {
		        buscaSubArvoreEsq(nodo, chave);
		    }
		}
	
		// **ENCONTRA SUBÁRVORES À ESQUERDA CASO HOUVER**
	
		private Nodo encontraSubarvoreEsq(Nodo raiz, int chave) {
			if (raiz == null || raiz.chave == chave) {
				return raiz;
			}
	
			if (chave < raiz.chave) {
				return encontraSubarvoreEsq(raiz.esq, chave);
			} else {
				return encontraSubarvoreEsq(raiz.dir, chave);
			}
		}
	
		// **BUSCA SUBÁRVORES À ESQUERDA DE UM NÓ**
	
		private void buscaSubArvoreEsq(Nodo raiz, int chave) {
			if (raiz != null) {
		        if (raiz.chave != chave) {
		            System.out.print(raiz.chave + " | ");
		        }
		        
		        if (raiz.esq != null) {
		            buscaSubArvoreEsq(raiz.esq, chave);
		        }
		    }
		}
		
	// h) Transformar a árvore numa lista encadeada
		// **MOSTRA A LISTA ENCADEADA**
	
		public void mostraListaEncadeada(ArvoreBinaria arvore) {
			System.out.println("\nLista encadeada:");
			ListaEncadeada lista = montaArvoreEmListaEncadeada(arvore);
	
			if (!lista.estaVazia()) {
				NodoListaEncadeada atual = lista.getInicio();
				while (atual != null) {
					System.out.print(atual.getDado() + " - ");
					atual = atual.getProx();
				}
				System.out.println();
			} else {
				System.out.println("A lista está vazia.");
			}
		}
	
		// **MONTA A ÁRVORE BINÁRIA EM UMA LISTA ENCADEADA**
	
		private ListaEncadeada montaArvoreEmListaEncadeada(ArvoreBinaria arvore) {
			ListaEncadeada lista = new ListaEncadeada();
			converterArvoreParaListaEncadeada(arvore.raiz, lista);
			return lista;
		}
	
		// **CONVERTE A ÁRVORE BINÁRIA EM UMA LISTA ENCADEADA**
	
		private void converterArvoreParaListaEncadeada(Nodo raiz, ListaEncadeada lista) {
			if (raiz == null) {
				return;
			}
	
			converterArvoreParaListaEncadeada(raiz.esq, lista);
			lista.inserirOrdenado(raiz.chave);
			converterArvoreParaListaEncadeada(raiz.dir, lista);
		}
		
	// i) Mostrar somente os números pares
		// **MOSTRA OS ELEMENTOS PARES DA ÁRVORE **
	
		public void mostraElementosPares() {
			System.out.println("\nElementos pares:");
			buscaElementosPares(raiz);
		}
	
		// **BUSCA OS ELEMENTOS PARES DA ÁRVORE**
	
		private void buscaElementosPares(Nodo raiz) {
			if (raiz != null) {
				buscaElementosPares(raiz.esq);
				if (raiz.chave % 2 == 0) {
					System.out.print(raiz.chave + " | ");
				}
				buscaElementosPares(raiz.dir);
			}
		}
		
	// j) Mostrar o nível de um nodo
		// **MOSTRA O NÍVEL DE UM NODO DA ÁRVORE**
	
		public void mostraNivelDoNodo(int chave) {
			System.out.print("\nNível do nodo(" + chave + "): ");
			if (raiz == null) {
				System.out.println("Árvore vazia!");
				return;
			}
	
			Queue<Nodo> fila = new LinkedList<>();
			fila.add(raiz);
			int nivel = 1;
	
			while (!fila.isEmpty()) {
				int tamanhoNivel = fila.size();
				for (int i = 0; i < tamanhoNivel; i++) {
					Nodo nodoAtual = fila.poll();
					if (nodoAtual != null) {
						if (nodoAtual.chave == chave) {
							System.out.print("nível " + nivel);
							return;
						}
						fila.add(nodoAtual.esq);
						fila.add(nodoAtual.dir);
					}
				}
				nivel++;
			}
	
			System.out.print("Nodo não encontrado na árvore.");
		}
		
	// k) Mostrar a altura da árvore
		// **MOSTRA A ALTURA DA ÁRVORE**
	
		public void mostraAlturaDaArvore() {
			 System.out.print("\nAltura da árvore: ");
			if (raiz == null) {
				System.out.println("Árvore vazia!");
				return;
			}
	
			Queue<Nodo> fila = new LinkedList<>();
			fila.add(raiz);
			int altura = 0;
	
			while (!fila.isEmpty()) {
				int tamanhoNivel = fila.size();
				for (int i = 0; i < tamanhoNivel; i++) {
					Nodo nodoAtual = fila.poll();
					if (nodoAtual != null) {
						fila.add(nodoAtual.esq);
						fila.add(nodoAtual.dir);
					}
				}
				altura++;
			}
	
			System.out.print("altura " + (altura - 1));
		}
		
	// l) Mostra o tamanho da árvore
		// **MOSTRA O TAMANHO DA ÁRVORE**
	
		public void mostraTamanhoDaArvore() {
			System.out.print("\nTamanho da árvore: ");
			if (raiz == null) {
				System.out.println("Árvore vazia!");
				return;
			}
	
			Queue<Nodo> fila = new LinkedList<>();
			fila.add(raiz);
			int tamanho = 0;
	
			while (!fila.isEmpty()) {
				int tamanhoNivel = fila.size();
				for (int i = 0; i < tamanhoNivel; i++) {
					Nodo nodoAtual = fila.poll();
					if (nodoAtual != null) {
						tamanho++;
						fila.add(nodoAtual.esq);
						fila.add(nodoAtual.dir);
					}
				}
			}
			System.out.println("tamanho " + tamanho);
	
		}
		
	// m) Inserir um novo item na árvore, mas de forma não recursiva
		// **INSERIR NODO ITERATIVAMENTE NA ÁRVORE**
	
		public void inserirIterativamente(int chave) {
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
}