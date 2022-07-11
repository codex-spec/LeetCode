class Solution {
    /*
    public List<List<Integer>> fourSum(int[] A, int t) {
        return kSum(A, t, 4);
    }

    private List<List<Integer>> kSum(int[] A, int t, int k) {
        Arrays.sort(A);
        List<List<Integer>> sol = new ArrayList<>();
        bt(A, t, k, new ArrayList<>(), sol, 0);
        return sol;
    }

    private void bt(int[] A, int t, int k, List<Integer> state, List<List<Integer>> sol, int si) {
        int avg = t/k;
        if (avg < A[si] || avg > A[A.length-1]) return;
        if (k == 2) {
            int i = si, j = A.length - 1;
            while (i < j) {
                int sum = A[i] + A[j];
                if (sum < t || i > si && A[i] == A[i-1]) i++;
                else if (sum > t || j < A.length - 1 && A[j] == A[j+1]) j--;
                else {
                    sol.add(new ArrayList<>(state));
                    sol.get(sol.size() - 1).add(A[i++]);
                    sol.get(sol.size() - 1).add(A[j--]);
                }
            }
            return;
        }

        for (int i = si; i < A.length - 2; i++) {
            if (i > si && A[i] == A[i-1]) continue;
            state.add(A[i]);
            bt(A, t-A[i], k-1, state, sol, i+1);
            state.remove(state.size() - 1);
        }
    }
    */
}