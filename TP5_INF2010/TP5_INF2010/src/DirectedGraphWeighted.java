import java.util.HashSet;

public class DirectedGraphWeighted {
    public HashSet<Vertex>[] neighbours;
    public int vertexCapacity;
    public int edgeQuantity;

    /* TODO Initialize de DirectedGraph */
    public void initialize(int numNodes) {
        this.vertexCapacity = numNodes;
        neighbours = new HashSet[numNodes];
        for(int i = 0; i < numNodes; i++) neighbours[i] = new HashSet<>();
        edgeQuantity = 0;
    }

    /*TODO Create an edge between the vertices - Veuillez vous referez aux notes de cours */
    public void connect(int v1, Vertex vertex){
        if (v1 < 0 || v1 >= vertexCapacity) return; // les sommet n'ont pas d'index negatif et l'index est inferieur au nombre de sommets
        if (neighbours[v1].contains(vertex)) return; // si le voisin existe deja, on ne veut l'ajouter une seconde fois
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

    //Les reponses pour la partie 3 se retrouvent en bas de ce fichier.
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
                if(!w.known) vertices.decreaseKey(w, w.cost + v.cost); // la verification de si la valeur du parametre est inferieur au cout actuel se fait a l'interieur de la fonction decreaseKey
            }
        }

        /*TODO Add up the total cost of the elements in the Heap */
        while(!vertices.isEmpty){
            Vertex v = vertices.poll();
            if(v.cost != Integer.MAX_VALUE) totalCost += v.cost;
        }

        /*
        //une autre maniere plus rapide (pas utilisé, car on assume qu'on n'a pas acces a la liste interne du Heap)
        for(int i = 1; i < vertices.Heap.length; i++){
            if(vertices.Heap[i] != null && vertices.Heap[i].cost != Integer.MAX_VALUE) totalCost += vertices.Heap[i].cost;
        }*/

        return totalCost;
    }

    /*
    PARTIE 3:
    1. Le nombre d'iteration minimal est de 0, dans le cas ou un sommet n'a aucun voisin.
    Le nombre d'iteration maximal serait le nombre de noeud - 1, dans le cas d'un noeud est connecte a tous les autres noeuds (fortement connexe)

    2. Le pire cas serait celui ou un sommet est connecte a tous les autres sommets du graphe et
    que celui-ci est le premier que l'on visite. Ainsi, comme aucun noeud n'a ete visite, la valeur pour le poids sera
    toujours de Interger.MAX_VALUE, et comme celle-ci est plus grande que le cout du noeud actuel (0) + poids de l'arc entre
    les deux, il va avoir la modification du cout associé à l'index du voisin. On aura donc au final N - 1 modifications,
    ou N correspond au nombre de sommet du graphe.

    3. La complexite de cette boucle est de nLog(n), comme on itere n fois pour le nombre de sommet et le retrait du sommet
    du Heap se fait en log(n), si l'on demande juste le nombre d'iteration pour la boucle externe, se sera toujour N iterations,
    tandis que si l'on demande le nombre d'itérations en relation avec la complexité (ce que l'on a assumé), on aura plus tot
    ces valeurs:
    3a. 10 * log2(10), donc dans l'ordre de 33 iterations
    3b. 100 * log2(100), donc dans l'ordre de 664 iterations
    3c. 1000 * log2(1000), donc dans l'ordre de 9966 iterations
    */
}
