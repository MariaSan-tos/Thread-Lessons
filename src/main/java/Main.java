/*
 * 
 * import java.util.concurrent.LinkedBlockingQueue;
 * import java.util.concurrent.ThreadPoolExecutor;
 * import java.util.concurrent.TimeUnit;
 * 
 * public class Main {
 * public static void main(String... args) {
 * 
 * Runnable t1 = new MyThread("Linha 1", 1);
 * Runnable t2 = new MyThread("Linha 2", 5);
 * 
 * ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 0,
 * TimeUnit.MILLISECONDS,
 * new LinkedBlockingQueue<Runnable>());
 * pool.execute(t1);
 * pool.execute(t2);
 * 
 * }
 * }
 */