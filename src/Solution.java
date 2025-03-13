import java.util.LinkedList;

public class Solution {
    int[][] directions = {
            {0, 1},
            {1, 1},
            {1, 0},
            {1, -1}
    };

    public Graph graph;

    public Solution() {
        this.graph = new Graph(0);
    }

    public int[][] solution(int[][] board, int row, int col, int num){
        this.matrizToGraph(board);

        Cel orig = new Cel(row, col);
        int origColor = board[row][col];

        LinkedList<String> fila = new LinkedList<>();
        fila.add(orig.iden);

        while (!fila.isEmpty()){

            Cel current = new Cel(fila.poll());
            board[current.row][current.col] = num;
            LinkedList<String> cels = graph.adj.get(current.iden);

            for (String cel : cels){

                Cel prox = new Cel(cel);
                if (board[prox.row][prox.col] == origColor && !fila.contains(prox.iden)){
                    fila.add(prox.iden);
                }

            }
        }
        return board;
    }

    public void matrizToGraph(int[][] board){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                Cel current = new Cel(row, col);
                int currentColor = board[row][col];

                if (!graph.adj.containsKey(current.iden)){
                    graph.addVertice(current.iden);
                }

                for (int[] dir : directions){

                    int newRow = current.row + dir[0];
                    int newCol = current.col + dir[1];

                    if (newRow >= 0 &&
                            newRow < board.length &&
                            newCol >= 0 &&
                            newCol < board[0].length &&
                            board[newRow][newCol] == currentColor){

                        Cel prox = new Cel(newRow, newCol);
                        if (!graph.adj.containsKey(prox.iden)){
                            graph.addVertice(prox.iden);
                        }
                        graph.addAresta(current.iden, prox.iden);
                    }
                }
            }
        }
    }
}
