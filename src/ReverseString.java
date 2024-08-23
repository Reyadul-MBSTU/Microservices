import java.io.IOException;
import java.util.*;

public class ReverseString {
    public void reverseString(char[] s) {
        int j = 0;
        for (int i = s.length - 1; i >= 0; i--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            ++j;
            // System.out.println(s[i]);
        }
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int distributeCandies(int n, int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int it : arr) {
            m.put(it, m.getOrDefault(it, 0) + 1);
        }

        int ans = Integer.MAX_VALUE;
        int temp;

        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                temp = 0;
                for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
                    temp += ((i - entry.getKey() % i) % i) * entry.getValue();
                }
                ans = Math.min(ans, temp);
            }
        }

        return ans;
    }


    /*
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public List<Integer> absolutePermutation(int n, int k) {
        // Write your code here
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            if (i - k > 0 && !map.containsKey(i - k)) {
                map.put(i - k, i);
            } else if (i + k <= n) {
                map.put(i + k, i);
            } else {
                map = new TreeMap<>();
                map.put(1, -1);
                break;
            }
        }
        return new ArrayList<>(map.values());

    }

    public static int minimumRecolors(String blocks, int k) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        while (j < blocks.length()) {
            if (blocks.charAt(j) == 'W')
                ans++;
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                min = Math.min(ans, min);
                if (blocks.charAt(i) == 'W')
                    ans--;
                j++;
                i++;
            }
        }
        return min;
    }


    public static void main(String[] args) throws IOException {
          /*  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                    int n = Integer.parseInt(firstMultipleInput[0]);

                    int k = Integer.parseInt(firstMultipleInput[1]);

                    List<Integer> result = absolutePermutation(n, k);

                    bufferedWriter.write(
                            result.stream()
                                    .map(Object::toString)
                                    .collect(joining(" "))
                                    + "\n"
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();*/
        Scanner sc = new Scanner(System.in);
        int input = 1;//sc.nextInt();
        ReverseString reverseString = new ReverseString();
        List<List<Integer>> absolutePermutation = new ArrayList<>();
        while (input-- > 0) {
            int n = 2;//sc.nextInt();
            int k = 1;//sc.nextInt();
            absolutePermutation.add(reverseString.absolutePermutation(n, k));
        }
        System.out.println(absolutePermutation);
    }
}

