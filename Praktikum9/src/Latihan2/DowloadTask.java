package Latihan2;
class DownloadTask extends Thread {
    private String filename;

    public DownloadTask(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        for (int i = 10; i <= 100; i += 10) {
            System.out.println(filename + " progress: " + i + "%");
            try {
                Thread.sleep(500); // simulasi waktu download
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(filename + " selesai diunduh!");
    }
}
