public class Main {
    public static void main(String[] args) {
        String caminhoEntrada = "dados/entrada.txt";
        In in = new In(caminhoEntrada);
        Graph G = new Graph(in);

        System.out.println("1- Lista de Adjacencias: \n");
        System.out.println(G);


        System.out.println("2 - Componentes Conexas: \n");
        CC cc = new CC(G);
        int m = cc.count();
        System.out.println("Número de componentes conexas: " + m);
        for (int i = 0; i < m; i++) {
            System.out.print("Vértices da componente " + i + ": ");
            for (int v = 0; v < G.V(); v++) {
                if (cc.id(v) == i) System.out.print(v + " ");
            }
            System.out.println();
        }
        System.out.println();


        System.out.println("3 - Distancia entre vértices: (0,0) e (2,2)\n");
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, 0);
        if (bfs.hasPathTo(8)) {
            System.out.println(bfs.distTo(8));
        } else {
            System.out.println("Inalcançável (Distância infinita)");
        }
        System.out.println();


        Cycle cycleFinder = new Cycle(G);
        System.out.print("4. O grafo possui ciclo? ");
        if (cycleFinder.hasCycle()) {
            System.out.println("Sim");
            System.out.print("5. Um ciclo encontrado: ");

            // 1. Criamos uma lista normal que aceita .size() e .get(i)
            java.util.ArrayList<Integer> listaDoCiclo = new java.util.ArrayList<>();

            // 2. Despejamos os dados do ciclo dentro da lista
            for (int v : cycleFinder.cycle()) {
                listaDoCiclo.add(v);
            }

            // 3. O ciclo original repete a ponta (ex: 7 0 5 ... 7).
            // Removemos o último para poder girar a lista sem duplicar números.
            listaDoCiclo.remove(listaDoCiclo.size() - 1);

            // 4. O giro: Enquanto o primeiro número não for 0,
            // tiramos da primeira posição (índice 0) e colocamos no final da fila.
            while (listaDoCiclo.get(0) != 0) {
                int primeiro = listaDoCiclo.remove(0);
                listaDoCiclo.add(primeiro);
            }

            // 5. Como é um ciclo fechado, precisamos adicionar o 0 no final de novo
            listaDoCiclo.add(0);

            // 6. AGORA SIM! O seu fori usando o .size() imprimindo a ordem perfeita
            for (int i = 0; i < listaDoCiclo.size(); i++) {
                int verticeAtual = listaDoCiclo.get(i);
                System.out.print(verticeAtual + " ");
            }
            System.out.println(); // Quebra de linha no final

        } else {
            System.out.println("Não");
        }

    }
}