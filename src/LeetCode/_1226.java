package LeetCode;

import java.util.concurrent.Semaphore;

/**
 * @description: 哲学家进餐
 * @author: wang hao
 * @create: 2020-10-23 15:32
 */
public class _1226 {
    class DiningPhilosophers {

        private Semaphore[] semaphores = new Semaphore[5];

        public DiningPhilosophers() {
            for (int i = 0; i < 5; i++) {
                semaphores[i] = new Semaphore(1);
            }
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            // 左边的叉子
            int left = philosopher;
            // 右边的叉子
            int right = (philosopher + 1) % 5;
            while (true) {
                if (semaphores[left].tryAcquire()) {
                    if (semaphores[right].tryAcquire()) {
                        pickLeftFork.run();
                        pickRightFork.run();
                        eat.run();
                        putLeftFork.run();
                        semaphores[left].release();
                        putRightFork.run();
                        semaphores[right].release();
                        break;
                    } else {
                        semaphores[left].release();
                        Thread.yield();
                    }
                } else {
                    Thread.yield();
                }
            }
        }
    }
}
