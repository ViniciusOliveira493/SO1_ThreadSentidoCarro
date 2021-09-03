package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	public static int sentido = 0;
	Semaphore semaforo;
	private String sentidos[] = {"Norte","Sul","Leste","Oeste"};
	private int id;
	
	public ThreadCarro(int id,Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		passar();
	}
	
	private void passar() {
		String inicio = "Carro #"+id+": ";
		try {
			semaforo.acquire();
			switch (id) {
			case 0:
				System.out.println(inicio+sentidos[id]+" -> "+sentidos[id+1]);
				break;
			case 1:
				System.out.println(inicio+sentidos[id]+" -> "+sentidos[id-1]);
				break;
			case 2:
				System.out.println(inicio+sentidos[id]+" -> "+sentidos[id+1]);
				break;
			case 3:
				System.out.println(inicio+sentidos[id]+" -> "+sentidos[id-1]);
				break;
			default:
				break;
			}
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
}
