/*
 * class MyThread implements Runnable {
 * private String nome;
 * private Integer sleepSeconds = 1;
 * 
 * public MyThread(String nome, Integer sleepSeconds) {
 * this.nome = nome;
 * this.sleepSeconds = sleepSeconds;
 * }
 * 
 * public void run() {
 * while (true) {
 * System.out.println("Thread " + nome + " está rodando");
 * this.sleep();
 * }
 * }
 * 
 * private void sleep() {
 * try {
 * Thread.sleep(this.sleepSeconds * 1000);
 * } catch (InterruptedException e) {
 * System.out.println(nome + " foi interrompida.");
 * }
 * }
 * 
 * }
 */
