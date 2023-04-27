package practice.MultiThreading;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {

		Runnable run1 = () -> {
			System.out.println("thread 1");
			getting("thread 1");

		};

		Runnable run2 = () -> {
			System.out.println("thread 2");
			getting("thread 2");
		};

		Runnable run3 = () -> {
			System.out.println("thread 3");
			getting("thread 3");
		};

		Thread thread1 = new Thread(run1);
		Thread thread3 = new Thread(run3);
		Thread thread2 = new Thread(run2);

		thread1.start();
		// thread1.join();

		thread3.start();
		// thread1.wait();
		thread2.start();
	}

	public static synchronized void getting(String thread) {
		System.out.println("one thread at a time "+ thread);
		while(true) {
			
		}
	}

}
