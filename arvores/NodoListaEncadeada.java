package arvores;

public class NodoListaEncadeada {
	private int dado;
	private NodoListaEncadeada prox;
	
	public NodoListaEncadeada (int dado) {
		this.dado = dado;
		this.prox = null;
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public NodoListaEncadeada getProx() {
		return prox;
	}

	public void setProx(NodoListaEncadeada prox) {
		this.prox = prox;
	}
}
