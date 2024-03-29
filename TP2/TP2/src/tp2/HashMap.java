package tp2;

public class HashMap<KeyType, DataType> {

    private static final int DEFAULT_CAPACITY = 20;
    private static final float DEFAULT_LOAD_FACTOR = 0.5f;
    private static final int CAPACITY_INCREASE_FACTOR = 2;

    private Node<KeyType, DataType>[] map;
    private int size = 0;
    private int capacity;
    private final float loadFactor; // Compression factor

    /**
     * Constructeur par défaut
     */
    public HashMap() { this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR); }

    /**
     * Constructeur par parametre
     * @param initialCapacity
     */
    public HashMap(int initialCapacity) {
        this(initialCapacity > 0 ? initialCapacity : DEFAULT_CAPACITY,
                DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructeur par parametres
     * @param initialCapacity
     * @param loadFactor
     */
    public HashMap(int initialCapacity, float loadFactor) {
        capacity = initialCapacity;
        this.loadFactor = 1 / loadFactor;
        map = new Node[capacity];
    }

    /**
     * Finds the index attached to a particular key
     * This is the hashing function ("Fonction de dispersement")
     * @param key Value used to access to a particular instance of a DataType within map
     * @return Index value where this key should be placed in attribute map
     */
    private int hash(KeyType key){
        int keyHash = key.hashCode() % capacity;
        return Math.abs(keyHash);
    }

    /**
     * @return if map should be rehashed
     */
    private boolean needRehash() {
        return size * loadFactor > capacity;
    }

    /**
     * @return Number of elements currently in the map
     */
    public int size() {
        return size;
    }

    /**
     * @return Current reserved space for the map
     */
    public int capacity(){ return capacity; }

    /**
     * @return if map does not contain any element
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /** TODO
     * Increases capacity by CAPACITY_INCREASE_FACTOR (multiplication) and
     * reassigns all contained values within the new map
     */
    private void rehash() {
        HashMap<KeyType, DataType> newMap = new HashMap<>(capacity * CAPACITY_INCREASE_FACTOR);
        for (Node<KeyType, DataType> headNode : map) {
            Node<KeyType, DataType> currentNode = headNode;
            while (currentNode != null) {
                newMap.put(currentNode.key, currentNode.data);
                currentNode = currentNode.next;
            }
        }
        map = newMap.map;
        size = newMap.size;
        capacity = newMap.capacity;
    }

    /** TODO
     * Finds if map contains a key
     * @param key Key which we want to know if exists within map
     * @return if key is already used in map
     */
    public boolean containsKey(KeyType key) {
        int index = hash(key);
        Node<KeyType, DataType> currentNode = map[index];
        while(currentNode != null){
            if(currentNode.key.equals(key)){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /** TODO
     * Finds the value attached to a key
     * @param key Key which we want to have its value
     * @return DataType instance attached to key (null if not found)
     */
    public DataType get(KeyType key) {
        int index = hash(key);
        boolean contained = containsKey(key);
        if(contained){
            Node<KeyType, DataType> currentNode = map[index];
            while (currentNode != null){
                if(currentNode.key.equals(key)){
                    return currentNode.data;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    /**TODO
     * Assigns a value to a key
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value) {
        boolean containsKey = this.containsKey(key);
        int index = hash(key);
        DataType oldData = null;
        if(containsKey){
           Node<KeyType, DataType> currentNode = map[index];
           while (!currentNode.key.equals(key)){
               currentNode = currentNode.next;
           }
           oldData = currentNode.data;
           currentNode.data = value;
        }else {
            Node<KeyType, DataType> newNode = new Node<>(key, value);
            if(map[index] == null){
                map[index] = newNode;
            }else {
                //insert in the first position of the linked list, so we don't have to iterate in the list
                Node<KeyType, DataType> oldFirstNode = map[index];
                map[index] = newNode;
                newNode.next = oldFirstNode;
            }
            size++;
            if(needRehash()){
                rehash();
            }
        }
        return oldData;
    }

    /**TODO
     * Removes the node attached to a key
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key) {
        boolean contained = this.containsKey(key);
        if(contained){
            int index = hash(key);
            Node<KeyType, DataType> currentNode = map[index];
            Node<KeyType, DataType> previousNode = null;
            while (!currentNode.key.equals(key)){
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            if(previousNode == null){
                map[index] = currentNode.next;
            }else{
                previousNode.next = currentNode.next;
            }
            size--;
            return currentNode.data;
        }
        return null;
    }

    /**TODO
     * Removes all nodes contained within the map
     */
    public void clear() {
        for(int i = 0; i < map.length; i++){
            map[i] = null; //removing the first element is enough to clear the linked list, the garbage collector will do the rest;
        }
        size = 0;
    }

    /**
     * Definition et implementation de la classe Node
     */
    static class Node<KeyType, DataType> {
        final KeyType key;
        DataType data;
        Node<KeyType, DataType> next; // Pointer to the next node within a Linked List

        Node(KeyType key, DataType data)
        {
            this.key = key;
            this.data = data;
            next = null;
        }
    }
}