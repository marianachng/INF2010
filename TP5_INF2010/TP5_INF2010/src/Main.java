import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        UndirectedGraph graph = new UndirectedGraph(3);
        graph.connect(0,1);
        graph.connect(1,2);

        System.out.println(graph.toString());

        DirectedGraphWeighted graph2 = new DirectedGraphWeighted(7);
        Vertex v = new Vertex(10,0);
        graph2.connect(1, new Vertex(3,2));
        graph2.connect(2, new Vertex(4,1));
        graph2.connect(0,new Vertex(1,1));
        graph2.connect(0,new Vertex(1,2));
        graph2.connect(0,new Vertex(1,3));
        graph2.connect(0,new Vertex(1,4));
        graph2.connect(0,new Vertex(1,5));
        graph2.connect(0,new Vertex(1,6));

        System.out.println(graph2.toString());

        Tests test = new Tests(graph, graph2, v, new Interview());
    }
}

