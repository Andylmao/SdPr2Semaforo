package SdPr2Semaforo;

import java.util.concurrent.Semaphore;

public class TrafficSignal implements Runnable {

    public enum Signal {
        VERDE, AMARILLO, ROJO;
    }

    private static volatile Signal current = Signal.ROJO;  // Estado actual del semáforo
    private Signal signal;
    private Semaphore semaphore = new Semaphore(1);  // Semáforo binario con una sola permisión

    public TrafficSignal(Signal signal) {
        this.signal = signal;
    }

    public void display() throws InterruptedException {
        semaphore.acquire();  // Espera para adquirir el semáforo

        while (current != this.signal) {
            semaphore.release();  // Libera el semáforo antes de esperar
            Thread.sleep(100);   // Pequeña pausa antes de volver a intentar
            semaphore.acquire();  // Intenta adquirir el semáforo nuevamente
        }

        switch (this.signal) {
            case VERDE:
                System.out.println("VERDE ");
                Thread.sleep(8000); // 8 segundos para VERDE
                break;
            case AMARILLO:
                System.out.println("AMARILLO ");
                Thread.sleep(2000); // 2 segundos para NARANJA
                break;
            case ROJO:
                System.out.println("ROJO ");
                Thread.sleep(10000); // 10 segundos para ROJO
                break;
        }

        current = (current == Signal.ROJO) ? Signal.VERDE : (current == Signal.VERDE) ? Signal.AMARILLO : Signal.ROJO;
        semaphore.release();  // Libera el semáforo después de cambiar el estado
    }

    public void run() {
        try {
            while (true)
                display();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new TrafficSignal(Signal.VERDE)).start();
        new Thread(new TrafficSignal(Signal.ROJO)).start();
        new Thread(new TrafficSignal(Signal.AMARILLO)).start();
    }
}
