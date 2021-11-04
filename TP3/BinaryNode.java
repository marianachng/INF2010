import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data)
    {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData()
    {
        return data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item)
    {
        if(item.compareTo(this.data) <= 0){
            if (this.left == null) {
                this.left = new BinaryNode<T>(item);
            }else {
                this.left.insert(item);
            }
        }else{
            if(this.right == null){
                this.right = new BinaryNode<T>(item);
            }else{
                this.right.insert(item);
            }
        }
    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
        if(this.data.equals(item))return true;
        else if(item.compareTo(this.data) <= 0){
            if(this.left == null){
                return false;
            }else{
                return this.left.contains(item);
            }
        }else{
            if(this.right == null){
                return false;
            }else {
                return this.right.contains(item);
            }
        }
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
        int leftBranch, rightBranch;
        if(this.left != null){
            leftBranch = this.left.getHeight() + 1;
        }else {
            leftBranch = 0;
        }
        if(this.right != null){
            rightBranch = this.right.getHeight() + 1;
        }else {
            rightBranch = 0;
        }
        return leftBranch > rightBranch ? leftBranch : rightBranch;
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
        if(this.left != null){
            this.left.fillListInOrder(result);
        }
        result.add(this);
        if(this.right != null){
            this.right.fillListInOrder(result);
        }
    }
}