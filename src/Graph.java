import java.util.*;

public class Graph {
    public int vertices;
    public int arestas;
    public HashMap<String, LinkedList<String>> adj;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.arestas = 0;
        this.adj = new HashMap<>();
        for (int i = 0; i<vertices; i++){
            this.adj.put(String.valueOf(i), new LinkedList<>());
        }
    }

    public void addVertice(String iden){
        this.vertices++;
        adj.put(iden, new LinkedList<>());
    }

    public void addAresta(String orig, String dest){
        LinkedList<String> fila = adj.get(orig);
        fila.add(dest);

        fila = adj.get(dest);
        fila.add(orig);

        this.arestas++;
    }

}
