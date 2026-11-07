public abstract class MesinSPBU {
    public static final double PAJAK = 0.11;
    private final String kodeMesin;
    private String namaBbm;
    private int harga;

    public MesinSPBU(String kodeMesin, String namaBbm) {
        this.kodeMesin = kodeMesin;
        this.namaBbm = namaBbm;
        this.harga = 10000;
    }

    public MesinSPBU(String kodeMesin, String namaBbm, int harga) {
        this.kodeMesin = kodeMesin;
        this.namaBbm = namaBbm;
        this.harga = harga;
    }

    public abstract void isiEnergi(int jumlah);

    public double hitungBayar(int jumlah) {
        double total;
        total = (jumlah * this.harga) + (jumlah * this.harga * PAJAK);
        return total;
    }

    public void tampilkanInformasi() {
        System.out.println("Kode Unit  : " + this.kodeMesin);
        System.out.println("Layanan    : " + this.namaBbm);
        System.out.println("Harga/Unit : Rp" + this.harga);
    }

    public String getKodeMesin() {
        return this.kodeMesin;
    }

    public String getNamaBbm() {
        return this.namaBbm;
    }

    public void setNamaBbm(String namaBbm) {
        this.namaBbm = namaBbm;
    }

    public int getHarga() {
        return this.harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}