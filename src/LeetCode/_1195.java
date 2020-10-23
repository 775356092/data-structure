package LeetCode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @description: 交替打印字符串
 * @author: wang hao
 * @create: 2020-10-23 13:17
 */
public class _1195 {
    class FizzBuzz {
        private Semaphore A = new Semaphore(1);
        private Semaphore B = new Semaphore(0);
        private Semaphore C = new Semaphore(0);
        private Semaphore D = new Semaphore(0);
        private int n;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                A.acquire();
                if (i % 15 == 0) {
                    B.release();
                } else if (i % 3 == 0) {
                    C.release();
                } else if (i % 5 == 0) {
                    D.release();
                } else {
                    printNumber.accept(i);
                    A.release();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i += 15) {
                B.acquire();
                printFizzBuzz.run();
                A.release();
            }
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i += 3) {
                if (i % 5 != 0) {
                    C.acquire();
                    printFizz.run();
                    A.release();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 5; i <= n; i += 5) {
                if (i % 3 != 0) {
                    D.acquire();
                    printBuzz.run();
                    A.release();
                }
            }
        }
    }
}
