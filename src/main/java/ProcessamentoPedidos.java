import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Classe Pedido que implementa Runnable
class Pedido implements Runnable {
    private final String nomeDoPedido;
    private final List<Integer> valoresTotais;

    public Pedido(String nomeDoPedido, List<Integer> valoresTotais) {
        this.nomeDoPedido = nomeDoPedido;
        this.valoresTotais = valoresTotais;
    }

    @Override
    public void run() {
        int total = 0;
        for (int i = 1; i <= 5; i++) {
            int valorItem = (int) (Math.random() * 100); // Simula valor aleatório de itens
            total += valorItem;
            System.out.println(nomeDoPedido + " processando item de valor: " + valorItem);
            try {
                // Simulando tempo de processamento
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(nomeDoPedido + " foi interrompido.");
            }
        }
        // Adiciona o valor total do pedido à lista compartilhada
        synchronized (valoresTotais) {
            valoresTotais.add(total);
        }
        System.out.println(nomeDoPedido + " finalizado. Total do pedido: " + total);
    }
}

public class ProcessamentoPedidos {
    public static void main(String[] args) {
        // Lista para armazenar os valores totais de cada pedido
        List<Integer> valoresTotais = new ArrayList<>();

        // ExecutorService com um pool de 3 threads (Paralelismo)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Criando e submetendo pedidos concorrentes ao executor
        executor.submit(new Pedido("Pedido 1", valoresTotais));
        executor.submit(new Pedido("Pedido 2", valoresTotais));
        executor.submit(new Pedido("Pedido 3", valoresTotais));

        // Aguardando a finalização de todos os pedidos
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Aguardar até que todas as threads terminem
        }

        // Agregação dos resultados
        int receitaTotal = valoresTotais.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Receita total do dia: " + receitaTotal);
    }
}
