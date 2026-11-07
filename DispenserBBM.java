public class DispenserBBM extends MesinSPBU {
    private int stokLiter;

    public DispenserBBM(String kodeMesin, String namaBbm, int stokLiter) {
        super(kodeMesin, namaBbm);
        this.stokLiter = stokLiter;
    }

    public DispenserBBM(String kodeMesin, String namaBbm, int harga, int stokLiter) {
        super(kodeMesin, namaBbm, harga);
        this.stokLiter = stokLiter;
    }

    @Override
    public void isiEnergi(int liter) {
        if (this.stokLiter >= liter) {
            this.stokLiter = this.stokLiter - liter;
            System.out.println("Pengisian " + getNamaBbm() + " " + liter + " Liter berhasil. Sisa tangki: " + this.stokLiter + " Liter");
        } else {
            System.out.println("Transaksi " + getNamaBbm() + " " + liter + " Liter dibatalkan, stok tangki tidak mencukupi");
        }
    }

    @Override
    public void tampilkanInformasi() {
        super.tampilkanInformasi();
        System.out.println("Stok BBM   : " + this.stokLiter + " Liter");
    }

    public int getStokLiter() {
        return this.stokLiter;
    }

    public void setStokLiter(int stokLiter) {
        this.stokLiter = stokLiter;
    }
}