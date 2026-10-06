class Pair {
    int index;
    int soldiers;

    Pair(int index, int soldiers) {
        this.index = index;
        this.soldiers = soldiers;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> b.soldiers != a.soldiers
                ? Integer.compare(b.soldiers,a.soldiers)
                : Integer.compare(b.index,a.index)
        );

        for(int i = 0; i < mat.length; i++) {
            pq.add(new Pair(i, sum(mat[i])));

            if(pq.size() > k)
                pq.poll();
        }

        Pair[] arr = new Pair[k];

        // First take the k selected rows
        for(int i = 0; i < k; i++)
            arr[i] = pq.poll();

        // Now sort them by weakest → strongest
        Arrays.sort(arr,
            (a,b) -> a.soldiers != b.soldiers
                ? Integer.compare(a.soldiers,b.soldiers)
                : Integer.compare(a.index,b.index)
        );

        int[] res = new int[k];

        for(int i = 0; i < k; i++)
            res[i] = arr[i].index;

        return res;
    }

    public int sum(int[] row) {
        int add = 0;

        for(int i : row)
            add += i;

        return add;
    }
}
