class Solution {
    public int[] nextGreaterElements(int[] arr) {

        int n = arr.length;

        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> v = new ArrayList<>();

        for (int p = 2 * n - 1; p >= 0; p--) {

            int i = p % n;

            if (s.size() == 0) {
                if (p < n) {
                    v.add(-1);
                }
            }

            else if (s.peek() > arr[i]) {
                if (p < n) {
                    v.add(s.peek());
                }
            }

            else {
                while (s.size() > 0 && s.peek() <= arr[i]) {
                    s.pop();
                }

                if (p < n) {
                    if (s.size() == 0) {
                        v.add(-1);
                    } else {
                        v.add(s.peek());
                    }
                }
            }

            s.push(arr[i]);
        }

        Collections.reverse(v);

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = v.get(i);
        }

        return ans;
    }
}