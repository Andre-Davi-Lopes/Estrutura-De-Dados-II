package arvores;

public class ListaEncadeada {
	
private NodoListaEncadeada inicio;
	
	//construtor
	public ListaEncadeada() {
		inicio = null;
	}
	
	public boolean estaVazia() {
		return inicio == null;
	}
	
	

	public NodoListaEncadeada getInicio() {
		return inicio;
	}

	public void setInicio(NodoListaEncadeada inicio) {
		this.inicio = inicio;
	}
	
	public void inserirOrdenado(int dado) {
		NodoListaEncadeada novoNodo = new NodoListaEncadeada(dado);
		
		if(estaVazia()) {
			inicio = novoNodo;
			return;
		}
		
		if(dado < inicio.getDado()) {
			novoNodo.setProx(inicio);
			inicio = novoNodo;
			return;
		}
		
		NodoListaEncadeada atual = inicio;
		NodoListaEncadeada anterior = null;
		
		while(atual != null && dado > atual.getDado()) {
			anterior = atual;
			atual = atual.getProx();
		}
		
		novoNodo.setProx(atual);
		anterior.setProx(novoNodo);
		
	}

}
