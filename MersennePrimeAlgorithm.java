import java.math.BigDecimal;
import java.util.Scanner;

class MersennePrimeAlgorithm {

    // Determine if 2^r - 1 is a prime number, where r is an integer taken as input.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("The program checks if 2^r - 1 is a Mersenne Prime. Enter value of r");
        int r = sc.nextInt();

        long startTime = System.currentTimeMillis(); // Start time

        // Declare some variables we will be using
        int j;
        BigDecimal series[] = new BigDecimal[r]; // Lucas–Lehmer series
        BigDecimal bigDecimalTwo = new BigDecimal("2"); // BigDecimal object for integer 2
        BigDecimal check = bigDecimalTwo.pow(r).subtract(new BigDecimal("1")); 

        // All of the following logic is based on the Lucas–Lehmer test
        for (j = 0, series[0] = new BigDecimal("4"); j < r - 1; j++) {
            if (j + 1 == r - 1) {
                if ((series[j].remainder(check)).compareTo(new BigDecimal("0")) == 0)
                    System.out.println("2^" + r + "-1 is prime");
                else
                    System.out.println("2^" + r + "-1 is not prime");
                break;
            } else { 
                BigDecimal res = (series[j].remainder(check));
                series[j+1] = (res.multiply(res)).subtract(bigDecimalTwo);
            }
        }
        long endTime   = System.currentTimeMillis(); // End time
        double totalTime = (endTime - startTime)/1000;

        System.out.println("Approximate runtime for this query in seconds: " + totalTime);
    }
}
