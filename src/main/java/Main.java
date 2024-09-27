import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Integer> valoresTotais = new ArrayList<>();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            3, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()
        );

        executor.submit(new Pedido("Pedido 1", valoresTotais));
        executor.submit(new Pedido("Pedido 2", valoresTotais));
        executor.submit(new Pedido("Pedido 3", valoresTotais));

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        int receitaTotal = valoresTotais.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Receita total do dia: " + receitaTotal);
    }
}
