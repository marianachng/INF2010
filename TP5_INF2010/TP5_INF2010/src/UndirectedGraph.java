import java.util.HashSet;

public class UndirectedGraph implements Graph {
    public HashSet<Integer>[] neighbours;
    public int nodeQuantity;
    public int graphEdges;

    @Override
    public void initialize(int numNodes) {
        this.nodeQuantity = numNodes;
        graphEdges = 0;
        neighbours = new HashSet[numNodes];
        for(int i = 0; i < numNodes; i++) neighbours[i] = new HashSet();
    }

    @Override
    public void connect(int v1, int v2){
        /*TODO Implement necessary conditions for connect and justify each condition */

        // verification des parametres
        if (v1<0 || v1>= this.nodeQuantity) return; // les sommet n'ont pas d'index negatif et l'index est inferieur au nombre de sommets
        if (v2<0 || v2>= this.nodeQuantity) return; // les sommet n'ont pas d'index negatif et l'index est inferieur au nombre de sommets
        if (neighbours[v1].contains(v2) ) return; // si le voisin existe deja, on ne veut l'ajouter une seconde fois
        neighbours[v1].add(v2);
        neighbours[v2].add(v1);
        graphEdges++;
    }

    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(nodeQuantity).append(ln).append(graphEdges).append(ln);
        for(int v = 0; v< nodeQuantity; v++)
            for(Object w : neighbours[v])
                o.append(v).append("-").append(w).append(ln);
        return o.toString();
    }

    @Override
    public HashSet<Integer> adj(int v) {
        return v < 0 || v >= nodeQuantity ? null : neighbours[v];
    }

    public UndirectedGraph(int numNodes){
        initialize(numNodes);
    }
}