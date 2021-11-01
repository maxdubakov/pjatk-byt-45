package implementation2;

import java.text.DecimalFormat;

public class OSStats {

    private final double CPUUsage;
    private final double GPUUsage;
    private final double memoryUsage;
    private final double networkDownloadSpeed;
    private final double networkUploadSpeed;

    public OSStats(double CPUUsage, double GPUUsage, double memoryUsage, double networkDownloadSpeed, double networkUploadSpeed) {
        this.CPUUsage = CPUUsage;
        this.GPUUsage = GPUUsage;
        this.memoryUsage = memoryUsage;
        this.networkDownloadSpeed = networkDownloadSpeed;
        this.networkUploadSpeed = networkUploadSpeed;
    }

    public void show() {
        DecimalFormat f = new DecimalFormat("##.00");

        System.out.println("\nCurrent State of the Operating System: ");
        System.out.println("CPU Usage: " + f.format(CPUUsage) + "%");
        System.out.println("GPU Usage: " + f.format(GPUUsage) + "%");
        System.out.println("Memory Usage: " + f.format(memoryUsage) + "%");
        System.out.println("Network Download Speed: " + f.format(networkDownloadSpeed) + " Mbps");
        System.out.println("Network Upload Speed: " + f.format(networkUploadSpeed) + " Mbps");
        System.out.println("\n\n");
    }
}
