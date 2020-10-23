package LeetCode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @description: 打印零与奇偶数
 * @author: wang hao
 * @create: 2020-10-23 10:34
 */
public class _1116 {
    class ZeroEvenOdd {
        private int n;
        private volatile boolean printBorC = true;
        private volatile int state;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (state != 0) {
                    Thread.yield();
                }
                printNumber.accept(0);
                if (printBorC) {
                    state = 1;
                } else {
                    state = 2;
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                while (state != 2) {
                    Thread.yield();
                }
                printNumber.accept(i);
                state = 0;
                printBorC = true;
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                while (state != 1) {
                    Thread.yield();
                }
                printNumber.accept(i);
                state = 0;
                printBorC = false;
            }
        }
    }

    class ZeroEvenOdd2 {
        private int n;
        private Semaphore printA = new Semaphore(1);
        private Semaphore printB = new Semaphore(0);
        private Semaphore printC = new Semaphore(0);
        private volatile int state;

        public ZeroEvenOdd2(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                printA.acquire();
                printNumber.accept(0);
                if (i % 2 != 0) {
                    printB.release();
                } else {
                    printC.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                printB.acquire();
                printNumber.accept(i);
                printA.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                printC.acquire();
                printNumber.accept(i);
                printA.release();
            }
        }
    }
}
