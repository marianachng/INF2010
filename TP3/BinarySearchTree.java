import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<? super T> > {

    private BinaryNode<T> root;

    public BinarySearchTree() { }

    // TODO: initialisation
    public BinarySearchTree(T item) {
        root = new BinaryNode<>(item);
    }

    // TODO: on insere un nouvel item a partir de la racine
    // O(log(n))
    public void insert(T item) {
        root.insert(item);
    }

    // TODO: est-ce qu'un item fais partie de l'arbre
    // O(log(n))
    public boolean contains(T item) {
        return root.contains(item);
    }

    // TODO: trouver la hauteur de l'arbre
    // O(n)
    public int getHeight() {
        return root.getHeight();
    }

    // TODO: placer dans une liste les items de l'arbre en ordre
    // O(n)
    public List<BinaryNode<T>> getItemsInOrder() {
        List<BinaryNode<T>> nodeList = new ArrayList<>();
        root.fillListInOrder(nodeList);
        return nodeList;
    }

    // TODO: retourner la liste d'item en String selon le bon format
    // O(n)
    public String toStringInOrder() {
        List<BinaryNode<T>> nodeList = getItemsInOrder();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int index = 0;
        for(BinaryNode<T> element : nodeList){
            if(index != nodeList.size() - 1) {
                sb.append(element.getData() + ", ");
            }else{
                sb.append(element.getData() + "]");
            }
            index++;
        }
        return sb.toString();
    }
}