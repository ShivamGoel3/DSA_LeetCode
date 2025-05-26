class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            m.put(hand[i], m.getOrDefault(hand[i], 0) + 1);
        }
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if (m.containsKey(hand[i]) == false)
                continue;
            int k = 0;
            while (k < groupSize) {
                if (m.containsKey(hand[i] + k)) {
                    m.put(hand[i] + k, m.get(hand[i] + k) - 1);
                    if (m.get(hand[i] + k) == 0)
                        m.remove(hand[i] + k);
                } else
                    return false;
                k++;
            }
        }
        return true;
    }
}