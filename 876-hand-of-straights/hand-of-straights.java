class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            m.put(hand[i], m.getOrDefault(hand[i], 0) + 1);
        }

        for (int i = 0; i < hand.length; i++) {
            int startcard = hand[i];
            while (m.getOrDefault(startcard, 0) > 0)
                startcard--;
            while (startcard <= hand[i]) {
                while (m.getOrDefault(startcard, 0) > 0) {
                    for (int j = startcard; j < startcard + groupSize; j++) {
                        if (m.getOrDefault(j, 0) == 0)
                            return false;
                        m.put(j, m.get(j) - 1);
                    }
                }
                startcard++;
            }
        }
        return true;
    }
}