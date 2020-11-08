package LeetCode;

import java.util.concurrent.Semaphore;

/**
 * @description: 交替打印
 * @author: wang hao
 * @create: 2020-10-23 09:40
 */
public class _1115 {
    class FooBar {
        private int n;
        private volatile boolean flag = false;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // 自旋
                while (flag) {
                    // 让步
                    Thread.yield();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = true;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // 自旋
                while (!flag) {
                    // 让步
                    Thread.yield();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = false;
            }
        }
    }

    class FooBar2 {
        private int n;
        private Semaphore foo = new Semaphore(1);
        private Semaphore bar = new Semaphore(0);

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                foo.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                foo.release();
            }
        }
    }
}
