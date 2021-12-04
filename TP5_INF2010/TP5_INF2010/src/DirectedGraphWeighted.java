import java.util.HashSet;

public class DirectedGraphWeighted {
    public HashSet<Vertex>[] neighbours;
    public int vertexCapacity;
    public int edgeQuantity;

    /* TODO Initialize de DirectedGraph */
    public void initialize(int numNodes) {
        //
        this.vertexCapacity = numNodes;
        neighbours = new HashSet[numNodes];
        for(int i = 0; i < numNodes; i++) neighbours[i] = new HashSet<>();
        edgeQuantity = 0;
    }

    /*TODO Create an edge between the vertices - Veuillez vous referez aux notes de cours */
    public void connect(int v1, Vertex vertex){

        if (v1 < 0 || v1 >= vertexCapacity) return; // les sommet n'ont pas d'index negatif et l'index est inferieur au nombre de sommets
        if (neighbours[v1].contains(vertex)) return; // // si le voisin existe deja, on ne veut l'ajouter une seconde fois
        neighbours[v1].add(vertex);
        edgeQuantity++;
    }

    /* TODO Print all the edges connecting vertices*/
    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(vertexCapacity).append(ln).append(edgeQuantity).append(ln);
        for(int i = 0; i < vertexCapacity; i++){
            for(Vertex vertex : neighbours[i]) o.append(i).append("-").append(vertex.index).append(ln);
        }
        return o.toString();
    }

    /* TODO Return a HashMap of adjacent edges / vertices */
    public HashSet<Vertex> adj(int v) {
        return neighbours[v];
    }

    public DirectedGraphWeighted(int numNodes){
        initialize(numNodes);
    }

    public int findLowestCost() {
        /* NE PAS MODIFIER CE CODE */
        int totalCost = 0;

        Heap vertices = new Heap(vertexCapacity + 1);
        /* NE PAS MODIFIER CE CODE */

        /* TODO Add all of the vertices to the Heap start at Index 1. The default cost should be the largest possible value for an integer */

        for(int i = 1; i < vertexCapacity; i++) vertices.add(new Vertex(Integer.MAX_VALUE, i));

        while(true){
            Vertex v = vertices.findSmallestUnknown();
            if(v == null) break;
            v.known = true;
            for(Vertex w: adj(v.index)){
                /* TODO Decrease the cost of the vertex in the Heap using decreaseKey if conditions are met */
                if(!w.known) vertices.decreaseKey(w, w.cost + v.cost);
            }
        }

        /*TODO Add up the total cost of the elements in the Heap */
        while(!vertices.isEmpty){
            Vertex v = vertices.poll();
            if(v.cost != Integer.MAX_VALUE) totalCost += v.cost;
        }

        /*
        //une autre maniere plus rapide
        for(int i = 1; i < vertices.Heap.length; i++){
            if(vertices.Heap[i] != null) totalCost += vertices.Heap[i].cost;
        }*/

        return totalCost;
    }

    /*
    PARTIE 3:
    1. Le nombre d'iteration minimal est de 0, dans le cas ou un sommet n'a aucun voisin.
    Le nombre d'iteration maximal serait le nombre de noeud - 1, dans le cas d'un noeud est connecte a tous les autres noeuds (fortement connexe)

    2. Le pire cas serait celui ou un sommet est connecte a tous les autres noeuds du graphe et
    que celui-ci est le premier noeud que l'on visite. Ainsi, si l'acces aux voisins se fait en ordre decroissant par rapport au cout,
    on aura donc une modification a chaque iteration du loop, donc n = noeud - 1 modifications.

    3a. 10 * log2(10)
    3b. 100 * log2(100)
    3c. 1000 * log2(1000)
    */
}
