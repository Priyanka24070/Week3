import java.util.*;

public class SearchComparison2 {
    static final int N = 1_000_000; // Dataset size
    static final int SEARCH_COUNT = 1_000; // Number of searches

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Random rand = new Random();

        // Generate dataset
        for (int i = 0; i < N; i++) {
            int num = rand.nextInt();
            arrayList.add(num);
            hashSet.add(num);
            treeSet.add(num);
        }

        // Generate search queries
        List<Integer> queries = new ArrayList<>();
        for (int i = 0; i < SEARCH_COUNT; i++) {
            queries.add(arrayList.get(rand.nextInt(N)));
        }

        // Run tests
        testArrayList(arrayList, queries);
        testHashSet(hashSet, queries);
        testTreeSet(treeSet, queries);
    }

    static void testArrayList(List<Integer> arrayList, List<Integer> queries) {
        long start = System.nanoTime();

        for (int query : queries) {
            for (int num : arrayList) {
                if (num == query) break;
            }
        }

        long end = System.nanoTime();
        System.out.println("Array Search Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    static void testHashSet(Set<Integer> hashSet, List<Integer> queries) {
        long start = System.nanoTime();

        for (int query : queries) {
            hashSet.contains(query);
        }

        long end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    static void testTreeSet(Set<Integer> treeSet, List<Integer> queries) {
        long start = System.nanoTime();

        for (int query : queries) {
            treeSet.contains(query);
        }

        long end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
