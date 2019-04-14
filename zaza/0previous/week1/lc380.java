import java.util.*;

public class lc380 {
    class RandomizedSet {
        List<Integer> L;
        Map<Integer, Integer> M;
        int num;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            num = 0;
            L = new ArrayList<>();
            M = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(M.get(val)!=null)
                return false;
            M.put(val, num++);
            L.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(M.get(val)==null)
                return false;
            int index = M.get(val);
            M.remove(val);
            L.remove(index);
            num--;
            for(int i=index; i<L.size();i++){
                M.put(L.get(i), M.get(L.get(i))-1);
            }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random r = new Random();
            int min = 0;
            int max = L.size();
            int rand = r.nextInt(max-min) + min;
            return L.get(rand);
        }
    }
}
