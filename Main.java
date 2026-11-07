public class Main {
    public static void main(String[] args) {
        System.out.println("=== LOG OPERASIONAL SPBU HYBRID 44.531.01 ===");
        System.out.println("Tarif PPN Berlaku: " + (MesinSPBU.PAJAK * 100) + "%\n");

        DispenserBBM pompaPertalite = new DispenserBBM("BBM-01", "Pertalite", 100);
        DispenserBBM pompaPertamax = new DispenserBBM("BBM-02", "Pertamax", 12950, 50);

        pompaPertamax.setHarga(13000);
        System.out.println("[Update Tarif] " + pompaPertamax.getKodeMesin() + " disesuaikan menjadi Rp" + pompaPertamax.getHarga() + "/Liter\n");

        System.out.println("--- LAYANAN DISPENSER BBM ---");
        pompaPertalite.tampilkanInformasi();
        pompaPertalite.isiEnergi(30);
        System.out.println("Tagihan Pembayaran : Rp" + pompaPertalite.hitungBayar(30));
        System.out.println();

        pompaPertamax.tampilkanInformasi();
        pompaPertamax.isiEnergi(60);

        System.out.println("\n--- LAYANAN SPKLU FAST CHARGING ---");
        ChargerEV spkluUtama = new ChargerEV("EV-01", "SPKLU Fast Charging", 2500, 200);
        spkluUtama.hidupkan(true);
        spkluUtama.konekInternet(true);
        spkluUtama.isiEnergi(50);
        System.out.println("Tagihan Pembayaran : Rp" + spkluUtama.hitungBayar(50));
        System.out.println();
        spkluUtama.tampilkanInformasi();

        System.out.println("\n--- SINKRONISASI GARDU & JARINGAN SPKLU CADANGAN ---");
        KontrolPompa saklarGardu = new ChargerEV("EV-02", "SPKLU Reguler AC", 80);
        saklarGardu.hidupkan(true);

        SistemIoT modulTelemetri = new ChargerEV("EV-03", "SPKLU Ultra DC", 150);
        modulTelemetri.konekInternet(true);
    }
}