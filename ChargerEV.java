public class ChargerEV extends MesinSPBU implements KontrolPompa, SistemIoT {
    private int dayaKwh;
    private boolean hidup;

    public ChargerEV(String kodeMesin, String namaBbm, int dayaKwh) {
        super(kodeMesin, namaBbm);
        this.dayaKwh = dayaKwh;
        this.hidup = false;
    }

    public ChargerEV(String kodeMesin, String namaBbm, int harga, int dayaKwh) {
        super(kodeMesin, namaBbm, harga);
        this.dayaKwh = dayaKwh;
        this.hidup = false;
    }

    @Override
    public void hidupkan(boolean status) {
        if (status) {
            this.hidup = true;
            System.out.println("Unit " + getKodeMesin() + " (" + getNamaBbm() + ") diaktifkan");
        } else {
            this.hidup = false;
            System.out.println("Unit " + getKodeMesin() + " (" + getNamaBbm() + ") dinonaktifkan");
        }
    }

    @Override
    public void konekInternet(boolean konek) {
        if (konek) {
            System.out.println("Unit " + getKodeMesin() + " terhubung ke server pusat SPBU");
        } else {
            System.out.println("Unit " + getKodeMesin() + " terputus dari jaringan");
        }
    }

    @Override
    public void isiEnergi(int kwh) {
        if (this.hidup) {
            if (this.dayaKwh >= kwh) {
                this.dayaKwh = this.dayaKwh - kwh;
                System.out.println("Pengisian daya " + kwh + " kWh selesai. Sisa kuota trafo: " + this.dayaKwh + " kWh");
            } else {
                System.out.println("Pengisian daya gagal, kuota trafo tidak mencukupi");
            }
        } else {
            System.out.println("Pengisian gagal, unit charger masih nonaktif");
        }
    }

    @Override
    public void tampilkanInformasi() {
        super.tampilkanInformasi();
        System.out.println("Kuota Daya : " + this.dayaKwh + " kWh");
        System.out.println("Status Unit: " + this.hidup);
    }

    public int getDayaKwh() {
        return this.dayaKwh;
    }

    public void setDayaKwh(int dayaKwh) {
        this.dayaKwh = dayaKwh;
    }

    public boolean isHidup() {
        return this.hidup;
    }

    public void setHidup(boolean hidup) {
        this.hidup = hidup;
    }
}