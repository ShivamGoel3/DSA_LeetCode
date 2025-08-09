class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            m.put(hand[i], m.getOrDefault(hand[i], 0) + 1);
        }
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            int a = hand[i];
            int count = 0;
            while (m.getOrDefault(a, 0) > 0 && count < groupSize) {
                m.put(a, m.get(a) - 1);
                a++;
                count++;
            }
            // System.out.println(hand[i] + " " + a + " " + count);
            if (count != 0 && count < groupSize)
                return false;
        }
        return true;
    }
}