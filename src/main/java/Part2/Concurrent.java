package Part2;

public class Concurrent {
    private boolean isWriter = false;
    private int numReaders = 0;

    public synchronized void enterReader() throws InterruptedException {
        while (isWriter) {
            wait();
        }
        numReaders++;
    }

    public synchronized void enterWriter() throws InterruptedException {
        while (isWriter || numReaders > 0) {
            wait();
        }
        isWriter = true;
    }

    public synchronized void exitReader() {
        numReaders--;
        notifyAll();
    }

    public synchronized void exitWriter() {
        isWriter = false;
        notifyAll();
    }
}
