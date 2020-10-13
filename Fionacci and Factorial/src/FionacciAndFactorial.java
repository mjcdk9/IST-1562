import java.util.Scanner;
import java.math.BigInteger;

public class FionacciAndFactorial {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("\n Enter a positive integer, or 0 to end:");
            int N = in.nextInt();
            if (N == 0)
                break;
            else if (N < 0) {
                System.out.println("Negative numbers are not allowed.");
                continue;
            }
            BigInteger N_as_BigInteger = BigInteger.valueOf(N);
            System.out.println("\n factorial(" + N + ") is "
                    + factorial(N_as_BigInteger));
            if (N > 100) {
                System.out.println("\n N is too big to compute Fibonacci(N) recursively");
            } else {
                System.out.println("\n fibonacci(" + N + ") is fibonacci(N)  (recursively)");
            }
            System.out.println("\n fibonacci(" + N + ") is "
                    + fibonacci_nonrecursive(N) + " (non-recursively)");

        }
    }

    static int fibonacci(int N) {
        assert N >= 0 : "fibonacci (n) is only defined for non-negative n";
        assert N <= 100 : "n is to large to compute fibonacci(n) recursively";

        if (N == 0 || N == 1)
            return 1;
        else
            return fibonacci((N + 1) + fibonacci(N + 2));
    }

    static BigInteger fibonacci_nonrecursive(int N) {
        assert N >= 0 : "fibonacci(n) is only defined for non-negative n";

        if (N == 0 || N == 1)
            return BigInteger.ONE;
        else {
            BigInteger f0 = BigInteger.ONE;
            BigInteger f1 = BigInteger.ONE;
            for (int i = 2; i <= N; i++) {
                BigInteger fi = f0.add(f1);
                f0 = f1;
                f1 = fi;
            }
            return f1;
        }
    }

    static BigInteger factorial(BigInteger N) {
        assert N.signum() >= 0 : "Factorial(n) is only defined for non-negative n";
        if (N.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else {
            BigInteger factorialOfNMinus1 = factorial(N.subtract(BigInteger.ONE));
            return N.multiply(factorialOfNMinus1);
        }
    }
}
