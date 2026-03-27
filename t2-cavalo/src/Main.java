public class Main {
    public static void main(String[] args) {
        // Caminho do arquivo de entrada
        String path = "dados/entrada.txt";
        In in = new In(path);


        Graph G = new Graph(in);

        System.out.println("=== Resolução de Problemas com Grafos - Cavalo 3x3 ===");
        System.out.println();


        System.out.println("1. Lista de adjacência:");
        System.out.println(G);


        CC cc = new CC(G);
        int m = cc.count();
        System.out.println("2. Componentes conexas: " + m);
        for (int i = 0; i < m; i++) {
            System.out.print("Vértices da componente " + i + ": ");
            for (int v = 0; v < G.V(); v++) {
                if (cc.id(v) == i) System.out.print(v + " ");
            }
            System.out.println();
        }
        System.out.println();

        BreadthFirstPaths bfs = new BreadthFirstPaths(G, 0);
        System.out.print("3. Distância mínima entre (0,0) e (2,2): ");
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
            for (int v : cycleFinder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("Não");
        }


        System.out.println("\n--- Análise de Complexidade (Algoritmo de Ciclo/DFS) ---");
        System.out.println("Tempo: O(V + E), pois o DFS visita cada vértice e aresta no máximo uma vez.");
        System.out.println("Espaço: O(V), para armazenar os arrays de marcação (visited) e a pilha de recursão.");
    }
}