import java.util.LinkedList;

public class Solution {
    // Direçoes para navegar nos vizinhos do no ([linha], [coluna])
    int[][] directions = {
            {0, 1},
            {1, 1},
            {1, 0},
            {1, -1},
            {0, -1},
            {-1, -1},
            {-1, 0},
            {-1, 1}
    };

    public Graph graph;

    public Solution() {
        this.graph = new Graph(0);
    }

    public int[][] solution(int[][] board, int row, int col, int num){
        if (board[row][col] == num){
            // Se a celula de origem tem a cor igual a cor escolhida: retorna a propria matriz
            return board;
        }

        // Inicializa a Fila com o no de origem e armazenando a cor original para comparaóes futuras
        int colorOrig = board[row][col];
        Cel orig = new Cel(row, col);
        graph.addVertice(orig.iden);
        LinkedList<Cel> queue = new LinkedList<>();
        queue.offer(orig);

        while (!queue.isEmpty()){

            //Pega o no que estava na fila para ser conferido e troca a cor original pela escolhida
            Cel no = queue.poll();
            board[no.row][no.col] = num;

            // Itera o nosso array de directions para visitar os vizinhos do no escolhido anteriormente
            for (int[] dir : directions){

                // Conforme Iteramos somamos a as coordenadas do no escolhido para vizitarmos os vizinho
                int newRow = no.row + dir[0]; // Eixo da linha
                int newCol = no.col + dir[1]; // Eixo da coluna

                /*
                Verificamos se a no vizinho nao eh "morto",
                linha e coluna menor que 0,
                linha e coluna maior do oq permitido e
                com o no original armazenado verificamos se
                o no que estamos vizitamos agora tem essa cor se sim
                coloca na fila para ser visitado posteriormente
                * */
                if (newRow >= 0 &&
                        newRow < board.length &&
                        newCol >= 0 &&
                        newCol < board[0].length &&
                        board[newRow][newCol] == colorOrig){

                    // Armazena a coordenada do no que deve ser modificado e coloca na fila
                    Cel prox = new Cel(newRow, newCol);
                    if (!graph.adj.containsKey(prox.iden)){
                        graph.addVertice(prox.iden);
                        queue.offer(prox);
                    }
                    graph.addAresta(no.iden, prox.iden);
                }
            }
        }
        System.out.println(graph.adj + " " + graph.vertices + " " + graph.arestas);
        return board;
    }
}
