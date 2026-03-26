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


        System.out.println("4 - O grafo possui ciclo? \n");
        Cycle cycleF = new Cycle(G);
        if (cycleF.hasCycle()){
            System.out.println("Sim, esse grafo possui ciclo");
            System.out.println("5 - Cliclo encortado: ");
            for (int v : cycleF.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("Não");
        }

    }
}