class Solution {
    static boolean isPrime(long n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public long sumOfLargestPrimes(String s) {
        ArrayList<Long> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            long num = 0;
            for (int j = i; j < s.length(); j++) {
                num *= 10;
                num += (s.charAt(j) - '0');
                boolean check = isPrime(num);
                if (check == false)
                    continue;
                // System.out.println(num);
                arr.add(num);
            }
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        // System.out.print(arr);
        if (arr.size() == 0)
            return 0;
        long sum = arr.get(0);
        int count = 1;
        for (int i = 1; i < arr.size() && count < 3; i++) {
            // System.out.println(i + " " + (arr.get(i) == arr.get(i - 1)));
            if (arr.get(i).equals(arr.get(i - 1))==false) {
                // System.out.println(i + " " + sum + " " + arr.get(i) + " " + arr.get(i - 1));
                // System.out.println("jj");
                sum += arr.get(i);
                count++;
            }
        }
        return sum;
    }
}