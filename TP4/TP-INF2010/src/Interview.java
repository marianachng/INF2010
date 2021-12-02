import java.util.Comparator;
import java.util.PriorityQueue;

public class Interview {

        public int lastBox(int[] boxes){

            // Ne pas modifier la ligne suivante
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
            // O(nlog(n))
            for(int box : boxes) heap.add(box);
            while (heap.size() > 1) {
                int boite1 = heap.poll();
                int boite2 = heap.poll();
                if (boite1 != boite2) {
                    heap.add(boite1 - boite2);
                }
            }
            return (heap.size() == 0) ? 0 : heap.poll();
        }
}


