
import java.util.List;

class Pedido implements Runnable {
  private final String nomeDoPedido;
  private final List<Integer> valoresTotais;

  public Pedido(String nomeDoPedido, List<Integer> valoresTotais) {
    this.nomeDoPedido = nomeDoPedido;
    this.valoresTotais = valoresTotais;
  }

  public void run() {
    int total = 0;
    for (int i = 1; i <= 5; i++) {
      int valorItem = (int) (Math.random() * 100);
      total += valorItem;
      System.out.println(nomeDoPedido + " processando item de valor: " + valorItem);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        System.out.println(nomeDoPedido + " foi interrompido.");
      }
    }

    synchronized (valoresTotais) {
      valoresTotais.add(total);
    }
    System.out.println(nomeDoPedido + " finalizado. Total do pedido: " + total);
  }
}
