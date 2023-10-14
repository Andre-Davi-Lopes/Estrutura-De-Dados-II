package testesDesempenhoArvores;

import java.util.Stack;

public class ArvoreAVL implements IArvores{
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// --------------------------- Classe Nodo -------------------------------------

	private class Nodo {
		private int dado, altd, alte;
		private Nodo dir, esq;

		public Nodo(int dado) {
			this.dado = dado;
			dir = esq = null;
			altd = alte = 0;
		}
	}

	Nodo raiz;

	public ArvoreAVL() {
		raiz = null;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//--------------------------- Métodos -------------------------------------
	
	// **INSERIR NODO NA ÁRVORE**

	public void inserir(int dado) {
		raiz = inserirDado(raiz, dado);
	}

	// **INSERIR NODO**
	
	private Nodo inserirDado(Nodo raiz, int dado) {
		if (raiz == null) {
			raiz = new Nodo(dado);
			return raiz;
		}
		if (dado < raiz.dado) {
			raiz.esq = inserirDado(raiz.esq, dado);
			if (raiz.esq.altd > raiz.esq.alte) {
				raiz.alte = raiz.esq.altd + 1;
			} else {
				raiz.alte = raiz.esq.alte + 1;
			}
			raiz = balanceamento(raiz);
		} else if (dado > raiz.dado) {
			raiz.dir = inserirDado(raiz.dir, dado);
			if (raiz.dir.altd > raiz.dir.alte) {
				raiz.altd = raiz.dir.altd + 1;
			} else {
				raiz.altd = raiz.dir.alte + 1;
			}
			raiz = balanceamento(raiz);
		}
		return raiz;
	}
	
	// **FAZ O BALANCEAMENTO DA ÁRVORE PARA FICAR EQUILIBRADA**

	private Nodo balanceamento(Nodo raiz) {
		int fb = raiz.altd - raiz.alte;
		int fbSubArv;
		if (fb == 2) {
			fbSubArv = raiz.dir.altd - raiz.dir.alte;
			if (fbSubArv >= 0) {
				raiz = rotacao_esquerda(raiz);
			} else {
				raiz.dir = rotacao_direita(raiz.dir);
				raiz = rotacao_esquerda(raiz);
			}
		} else if (fb == -2) {
			fbSubArv = raiz.esq.altd - raiz.esq.alte;
			if (fbSubArv <= 0) {
				raiz = rotacao_direita(raiz);
			} else {
				raiz.esq = rotacao_esquerda(raiz.esq);
				raiz = rotacao_direita(raiz);
			}
		}
		return raiz;
	}

	// **ROTACIONA A ÁRVORE PARA A ESQUERDA**
	
	private Nodo rotacao_esquerda(Nodo raiz) {
		Nodo aux1, aux2;
		aux1 = raiz.dir;
		aux2 = aux1.esq;
		raiz.dir = aux2;
		aux1.esq = raiz;
		if (raiz.dir == null) {
			raiz.altd = 0;
		} else if (raiz.dir.alte > raiz.dir.altd) {
			raiz.altd = raiz.dir.alte + 1;
		} else {
			raiz.altd = raiz.dir.altd + 1;
		}
		if (aux1.esq.alte > aux1.esq.altd) {
			aux1.alte = aux1.esq.alte + 1;
		} else {
			aux1.alte = aux1.esq.altd + 1;
		}
		return aux1;
	}

	// **ROTACIONA A ÁRVORE PARA A DIREITA**
	
	private Nodo rotacao_direita(Nodo raiz) {
		Nodo aux1, aux2;
		aux1 = raiz.esq;
		aux2 = aux1.dir;
		raiz.esq = aux2;
		aux1.dir = raiz;
		if (raiz.esq == null) {
			raiz.alte = 0;
		} else if (raiz.esq.alte > raiz.esq.altd) {
			raiz.alte = raiz.esq.alte + 1;
		} else {
			raiz.alte = raiz.esq.altd + 1;
		}
		if (aux1.dir.alte > aux1.dir.altd) {
			aux1.altd = aux1.dir.alte + 1;
		} else {
			aux1.altd = aux1.dir.altd + 1;
		}
		return aux1;
	}

	// **REMOVER NODO NA ÁRVORE**
	
	public void remover(int dado) {
		raiz = removerDado(raiz, dado);
	}
	
	// **REMOVER DADO**

	private Nodo removerDado(Nodo raiz, int dado) {
		if (raiz == null) {
			return raiz;
		}

		if (dado < raiz.dado) {
			raiz.esq = removerDado(raiz.esq, dado);
		} else if (dado > raiz.dado) {
			raiz.dir = removerDado(raiz.dir, dado);
		} else {

			if (raiz.esq == null) {
				return raiz.dir;
			} else if (raiz.dir == null) {
				return raiz.esq;
			}

			raiz.dado = encontrarMenorValor(raiz.dir);

			raiz.dir = removerDado(raiz.dir, raiz.dado);
		}

		return balanceamento(raiz);
	}
	
	// **BUSCA O MENOR VALOR DA ÁRVORE**

	private int encontrarMenorValor(Nodo nodo) {
		int menorValor = nodo.dado;
		while (nodo.esq != null) {
			menorValor = nodo.esq.dado;
			nodo = nodo.esq;
		}
		return menorValor;
	}
	
	// **BUSCA O NODO ESPECÍFICO DA ÁRVORE**
	
	public boolean buscar(int dado) {
		 boolean encontrado = buscarValor(raiz, dado);
		    if (encontrado) {
		    	System.out.println("Elemneto [" + dado + "] encontrado com sucesso!");
		    } else {
		    	System.out.println("Elemneto [" + dado + "] não encontrado na árvore");
		    }
		    return encontrado;
	}
	
	// **BUSCA O NODO**

	private boolean buscarValor(Nodo nodo, int dado) {
	    if (nodo == null) {
	        return false; 
	    }

	    if (dado == nodo.dado) {
	        return true;
	    }

	    if (dado < nodo.dado) {
	        return buscarValor(nodo.esq, dado);
	    } else {
	        return buscarValor(nodo.dir, dado);
	    }
	}

	private boolean buscarValor2(Nodo nodo, int dado) {
	    Stack<Nodo> stack = new Stack<>();
	    stack.push(nodo);

	    while (!stack.isEmpty()) {
	        Nodo current = stack.pop();
	        if (current == null) {
	            continue;
	        }
	        if (dado == current.dado) {
	            return true;
	        }
	        stack.push(current.dir);
	        stack.push(current.esq);
	    }

	    return false;
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
	     buscarValor2(raiz, chave);
	 }

}
