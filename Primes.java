import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Filip on 2016-12-29.
 */
public class Primes extends Thread {

    static List<Long> Primes = new ArrayList<>();

    static float milliseconds = 0;

    public void run() {
        while(running) {
            try {
                milliseconds += 0.01;
                Thread.sleep(10);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }

    static long Nbr = 82746382;

    public static void main(String[] args) throws InterruptedException {

        (new main()).start();

        List<Long> Primes = primeFact(Nbr);
        if(Primes.size() == 1) {
            System.out.print(Nbr + " is prime.");
        } else {
            System.out.println("These are the prime factors of "+Nbr);
            Long[] factors = Primes.stream().toArray(Long[]::new);
            for(int i = 0; i < Primes.size(); i++) {
                if(i == Primes.size()-1) {
                    System.out.print(factors[i] + " = " + Nbr);
                } else {
                    System.out.print(factors[i] + " * ");
                }
            }
        }
        System.out.println("\nTime: " + milliseconds+"s");
    }
    static boolean isPrime(long n) {
        if(n == 1) {
            return true;
        }
        if(n == 2) {
            return true;
        }
        if(n % 2 == 0) {
            return false;
        }
        for(long i = 3; i < n/2; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    static List<Long> primeFact(long n) {
        List<Long> Factors = new ArrayList<>();
        List<Long> subFactors = new ArrayList<>();
        for(long i = 2; i < n; i++) {
            if(n % i == 0) {
                if(isPrime(i)) {
                    n = n/i;
                    Factors.add(i);
                } else {
                    while(!isPrime(n)) {
                        for(long q = 2; q < n/2; q++) {
                            if(n % q == 0) {
                                n = n/q;
                                Factors.add(q);
                            }
                        }
                    }
                }
            }
        }
        Factors.add(n);
        return Factors;
    }
}
