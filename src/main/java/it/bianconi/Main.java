package it.bianconi;

public class Main {

    public static void main(String[] args){

        // Creo un unico contatore condiviso
        Contatore contatore = new Contatore(10);

        // Creo i due lavoratori
        Lavoratore lavoratore1 = new Lavoratore(contatore, "Thread-1");
        Lavoratore lavoratore2 = new Lavoratore(contatore, "Thread-2");

        // Creo i due thread
        Thread thread1 = new Thread(lavoratore1);
        Thread thread2 = new Thread(lavoratore2);

        // Avvio i thread
        thread1.start();
        thread2.start();

        try{
            // Aspetto che entrambi i thread terminino
            thread1.join();
            thread2.join();

        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Raggiunto il valore massimo del contatore!");
    }
}