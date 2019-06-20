package lesson5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] original = new float[SIZE];

    {
        for (int i = 0; i < original.length; i++) {
            original[i] = 1;
        }
    }

    public static void main(String[] args) throws Exception {
        float[] copyForSinglethreaded = new float[SIZE];
        System.arraycopy(original,0, copyForSinglethreaded,0,SIZE);

        float[] copyForMultiThreaded = new float[SIZE];
        System.arraycopy(original,0, copyForMultiThreaded,0,SIZE);

        long a = System.currentTimeMillis();
        computerMultiThreaded(copyForMultiThreaded);
        System.out.println("MULTI: "+(System.currentTimeMillis() - a));

        a = System.currentTimeMillis();
        computeSingleThread(copyForSinglethreaded);
        System.out.println("SINGLE: "+(System.currentTimeMillis() - a));



        if(copyForMultiThreaded.length != copyForSinglethreaded.length) {
            throw new IllegalStateException("DIFFERENT LENGTH");
        }

        for(int i = 0; i < copyForSinglethreaded.length; i++) {
            if(copyForSinglethreaded[i] != copyForMultiThreaded[i]) {
                throw new IllegalStateException("DIFFERENT ELEMENT i =" + i);
            }
        }
    }

    public static float[] computeSingleThread(float[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    public static void computerMultiThreaded(float[] arr) throws Exception {

        float [] a1 = new float[HALF/2];
        float [] a2 = new float[HALF/2];
        float [] a3 = new float[HALF/2];
        float [] a4 = new float[HALF/2];

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF/2);
        System.arraycopy(arr, HALF/2, a2, 0, HALF/2);
        System.arraycopy(arr, HALF, a3, 0, HALF/2);
        System.arraycopy(arr, HALF+HALF/2, a4, 0, HALF/2);
        //System.arraycopy(arr, 0, a1, 0, h);
        //System.arraycopy(arr, h, a2, 0, h);

        final ExecutorService pool =  Executors.newFixedThreadPool(2);

        ComputerForArrayCallable callable1 = new ComputerForArrayCallable(a1);
        ComputerForArrayCallable callable2 = new ComputerForArrayCallable(a2);
        ComputerForArrayCallable callable3 = new ComputerForArrayCallable(a3);
        ComputerForArrayCallable callable4 = new ComputerForArrayCallable(a4);

        Future<float[]> future1 = pool.submit(callable1);
        Future<float[]> future2 = pool.submit(callable2);
        Future<float[]> future3 = pool.submit(callable3);
        Future<float[]> future4 = pool.submit(callable4);

        while (!future1.isDone() && !future2.isDone() ) {
            Thread.sleep(100);
        }
        pool.shutdown();

        System.arraycopy(a1, 0, arr, 0, HALF/2);
        System.arraycopy(a2, 0, arr, HALF/2, HALF/2);
        System.arraycopy(a3, 0, arr, HALF, HALF/2);
        System.arraycopy(a4, 0, arr, HALF+HALF/2, HALF/2);
//        System.arraycopy(a1, 0, arr, 0, h);
//        System.arraycopy(a2, 0, arr, h, h);
    }

    static class ComputerForArrayCallable implements Callable<float[]> {

        public ComputerForArrayCallable(float[] a) {
            this.a = a;
        }

        float [] a;


        @Override
        public float[] call() throws Exception {
            for (int i = 0; i < a.length; i++) {
                a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            return a;
        }
    }

    static class ComputeForArray implements Runnable {

        public ComputeForArray(float[] a) {
            this.a = a;
        }

        float [] a = new float[HALF];

        @Override
        public void run() {
            for (int i = 0; i < a.length; i++) {
                a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                try {
                    Thread.sleep(100);
                    System.out.println("new thread: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

