import java.util.Comparator;
import java.util.PriorityQueue;

public class Interview {

        // O(nlog(n)), car on a 2 fois des operations O(nlog(n))
        public int lastBox(int[] boxes){
            // Ne pas modifier la ligne suivante
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

            for(int box : boxes) heap.add(box);// O(nlog(n))

            while (heap.size() > 1) { //O(nlog(n))
                int boite1 = heap.poll();
                int boite2 = heap.poll();
                if (boite1 != boite2) {
                    heap.add(boite1 - boite2);
                }
            }
            return (heap.size() == 0) ? 0 : heap.poll();
        }
}


