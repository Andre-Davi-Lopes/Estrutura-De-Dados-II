package grafos;

public class ListaAdjacenciaMain {

     public static void main(String[] args) throws Exception {
          // TODO Auto-generated method stub
          
        ListaAdjacencia grafo = new ListaAdjacencia(3, false);
          
          // ** TESTES FEITO EM SALA DE AULA **
          
          // Adicionand aresta ao grafp
        grafo.adicionarAresta(0, 1); // 2
        grafo.adicionarAresta(0, 2); // 1
        grafo.adicionarAresta(1, 2); // 0
          
          // Mostrando a lista de Adjacências
        grafo.mostrarListaAdjacencia();
          
        System.out.println("*******************");
          
          // Removendo aresta da Lista de Adjacências
        grafo.removerAresta(0, 2);
          
          // Mostrando a lista de Adjacências
        grafo.mostrarListaAdjacencia();
          
          
          // ** TESTES REFERENTES AO TRABALHO DE GRAFOS **
          
        ListaAdjacencia grafo2 = new ListaAdjacencia(5, false);
          
        grafo2.adicionarAresta(0, 1);
        grafo2.adicionarAresta(0, 2);
        grafo2.adicionarAresta(1, 2);
        grafo2.adicionarAresta(2, 3);
        grafo2.adicionarAresta(3, 4);
        grafo2.adicionarAresta(0, 4);
        
      grafo2.mostrarListaAdjacencia();
        
   // 1-a)
      grafo2.removerVertice(3);
      System.out.println("\n======================================");
      System.out.println("Grafo Após a remoção do vertice: \n");
      grafo2.mostrarListaAdjacencia();

   // 1-b)
      /* Um grafo é conexo se existir um caminho entre todos os pares de vértices */ 
      System.out.println("Grafo Conexo?");
      System.out.println(grafo2.isConexo());
         
   // 1-c)
      /* Um grafo é completo se cada par de vértices distintos for conectado por uma aresta */
      System.out.println("Grafo Completo?");
      System.out.println(grafo2.isCompleto());



   // 1-d)
      grafo2.dijkstra(0);


   // 1-e)
        /* Um grafo é euleriano se todos os seus vértices têm grau par.
         * É semieuleriano se exatamente dois vértices têm grau ímpar. 
         * Caso contrário, o grafo não é euleriano. */
        System.out.println(grafo2.isEuleriano());   
        
   // 1-f)
        /* Um grafo Hamiltoniano passa por cada vértice do grafo exatamente uma vez
         * e retorna ao vértice inicial */
        System.out.println(grafo2.isHamiltonian());
    	 
    	
    	 ListaAdjacencia grafo3 = new ListaAdjacencia(5, true);
    	 
    	 grafo3.adicionarAresta(0, 1, 1);
    	 grafo3.adicionarAresta(0, 3, 3);
    	 grafo3.adicionarAresta(0, 4, 10);
    	 grafo3.adicionarAresta(1, 2, 5);
    	 grafo3.adicionarAresta(2, 4, 1);
    	 grafo3.adicionarAresta(3, 2, 2);
    	 grafo3.adicionarAresta(3, 4, 6);
    	
    // 2-a)
    	 grafo3.dijkstra(0);
    	 
    	 ListaAdjacencia grafo4 = new ListaAdjacencia(6, true);
    	 
    	 // Obs: em relação a atividade o número de vértices no código é n-1 
    	 // para assim o algoritmo funcionar corretamente
    	 grafo4.adicionarAresta(0, 1, 15);
    	 grafo4.adicionarAresta(0, 2, 9);
    	 grafo4.adicionarAresta(1, 3, 2);
    	 grafo4.adicionarAresta(2, 1, 4);
    	 grafo4.adicionarAresta(2, 3, 3);
    	 grafo4.adicionarAresta(2, 4, 16);
    	 grafo4.adicionarAresta(3, 4, 6);
    	 grafo4.adicionarAresta(3, 5, 21);
    	 grafo4.adicionarAresta(4, 5, 7);
    	
    // 2-b)
    	 grafo4.dijkstra(0);
    	 
    	 ListaAdjacencia grafo5 = new ListaAdjacencia(18, false);
        
    	 grafo5.adicionarAresta(0, 1, 50);     //  Lisboa            ->  Setúbal
    	 grafo5.adicionarAresta(1, 0, 50);     //  Setúbal           ->  Lisboa
    	 grafo5.adicionarAresta(1, 2, 260);    //  Setúbal           ->  Faro
    	 grafo5.adicionarAresta(2, 1, 260);    //  Faro              ->  Setúbal
    	 grafo5.adicionarAresta(1, 3, 135);    //  Seúbal            ->  Beja
    	 grafo5.adicionarAresta(3, 1, 135);    //  Beja              ->  Setúbal
    	 grafo5.adicionarAresta(2, 3, 170);    //  Faro              ->  Beja
    	 grafo5.adicionarAresta(3, 2, 170);    //  Beja              ->  Faro
    	 grafo5.adicionarAresta(0, 4, 150);    //  Lisboa            ->  Évora
    	 grafo5.adicionarAresta(4, 0, 150);    //  Évora             ->  Lisboa 
    	 grafo5.adicionarAresta(3, 4, 80);     //  Beja              ->  Évora
    	 grafo5.adicionarAresta(4, 3, 80);     //  Évora             ->  Beja
    	 grafo5.adicionarAresta(0, 5, 70);     //  Lisboa            ->  Santarém
    	 grafo5.adicionarAresta(5, 0, 70);     //  Santarém          ->  Lisboa
    	 grafo5.adicionarAresta(5, 4, 120);    //  Santarém          ->  Évora
    	 grafo5.adicionarAresta(4, 5, 120);    //  Évora             ->  Santarém
    	 grafo5.adicionarAresta(5, 6, 150);    //  Santarém          ->  Portalegre
    	 grafo5.adicionarAresta(6, 5, 150);    //  Portalegre        ->  Santarém
    	 grafo5.adicionarAresta(4, 6, 100);    //  Évora             ->  Portalegre
    	 grafo5.adicionarAresta(6, 4, 100);    //  Portalegre        ->  Évora
    	 grafo5.adicionarAresta(0, 7, 130);    //  Lisboa            ->  Leiria
    	 grafo5.adicionarAresta(7, 0, 130);    //  Leiria            ->  Lisboa
    	 grafo5.adicionarAresta(7, 8, 70);     //  Leira             ->  Coimbra
    	 grafo5.adicionarAresta(8, 7, 70);     //  Coimbra           ->  Leira
    	 grafo5.adicionarAresta(8, 9, 160);    //  Coimbra           ->  Castelo Branco
    	 grafo5.adicionarAresta(9, 8, 160);    //  Castelo Branco    ->  Coimbra
    	 grafo5.adicionarAresta(6, 9, 80);     //  Portalegre        ->  Castelo Branco
    	 grafo5.adicionarAresta(9, 6, 60);     //  Castelo Branco    ->  Portalegre
    	 grafo5.adicionarAresta(8, 10, 80);    //  Coimbra           ->  Aveiro
    	 grafo5.adicionarAresta(10, 8, 80);    //  Aveiro            ->  Coimbra
    	 grafo5.adicionarAresta(8, 11, 80);    //  Coimbra           ->  Viseu
    	 grafo5.adicionarAresta(11, 8, 80);    //  Viseu             ->  Coimbra
    	 grafo5.adicionarAresta(8, 12, 160);   //  Coimbra           ->  Guarda
    	 grafo5.adicionarAresta(12, 8, 160);   //  Guarda            ->  Coimbra
    	 grafo5.adicionarAresta(9, 12, 100);   //  Castelo Branco    ->  Guarda
    	 grafo5.adicionarAresta(12, 9, 100);   //  Guarda            ->  Castelo Branco
    	 grafo5.adicionarAresta(10, 11, 100);  //  Aveiro            ->  Viseu
    	 grafo5.adicionarAresta(11, 10, 100);  //  Viseu             ->  Aveiro
    	 grafo5.adicionarAresta(10, 13, 70);   //  Aveiro            ->  Porto
    	 grafo5.adicionarAresta(13, 10, 70);   //  Porto             ->  Aveiro
    	 grafo5.adicionarAresta(11, 12, 80);   //  Viseu             ->  Guarda
    	 grafo5.adicionarAresta(12, 11, 80);   //  Guarda            ->  Viseu
    	 grafo5.adicionarAresta(11, 14, 110);  //  Viseu             ->  Vila Real
    	 grafo5.adicionarAresta(14, 11, 110);  //  Vila Real         ->  Viseu
    	 grafo5.adicionarAresta(12, 14, 150);  //  Guarda            ->  Vila Real
    	 grafo5.adicionarAresta(14, 12, 150);  //  Vila Real         ->  Guarda
    	 grafo5.adicionarAresta(12, 15, 200);  //  Guarda            ->  Bragança
    	 grafo5.adicionarAresta(15, 12, 200);  //  Bragança          ->  Guarda
    	 grafo5.adicionarAresta(13, 14, 120);  //  Porto             ->  Vila Real
    	 grafo5.adicionarAresta(14, 13, 120);  //  Vila Real         ->  Porto
    	 grafo5.adicionarAresta(13, 16, 80);   //  Porto             ->  Viana do Castelo
    	 grafo5.adicionarAresta(16, 13, 80);   //  Viana do Castelo  ->  Porto
    	 grafo5.adicionarAresta(13, 17, 50);   //  Porto             ->  Braga
    	 grafo5.adicionarAresta(17, 13, 50);   //  Braga             ->  Porto
    	 grafo5.adicionarAresta(16, 17, 50);   //  Viana do Castelo  ->  Braga
    	 grafo5.adicionarAresta(17, 16, 50);   //  Braga             ->  Viana do Castelo
    	 grafo5.adicionarAresta(17, 14, 100);  //  Braga             ->  Vila Real
    	 grafo5.adicionarAresta(14, 17, 100);  //  Vila Real         ->  Braga
    	 grafo5.adicionarAresta(14, 15, 140);  //  Vila Real         ->  Bragança
    	 grafo5.adicionarAresta(15, 14, 140);  //  Bragança          -> Vila Real
    	 
    // 2-c)
    	 grafo5.dijkstra(0);
     }

}
