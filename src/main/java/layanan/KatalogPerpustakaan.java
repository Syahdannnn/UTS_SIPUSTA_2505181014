package layanan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;

public class KatalogPerpustakaan {
    private List<Koleksi> daftarKoleksi;

    public KatalogPerpustakaan() {
        this.daftarKoleksi = new ArrayList<>();
    }

    public void tambahKoleksi(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }

    public void cetakStatus() {
        System.out.println("====== DAFTAR KATALOG PERPUSTAKAAN ======");
        for (Koleksi k : daftarKoleksi) {
            System.out.println(k.deskripsi());
        }
        System.out.println("=========================================\n");
    }

    public void urut(Comparator<Koleksi> comparator) {
        daftarKoleksi.sort(comparator);
    }

    public void pinjam(String kodeKoleksi) throws PustakaException {
        Koleksi target = null;
        for (Koleksi k : daftarKoleksi) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {
                target = k;
                break;
            }
        }

        if (target == null) {
            throw new PustakaException("Koleksi dengan kode '" + kodeKoleksi + "' tidak ditemukan dalam katalog.");
        }

        if (!target.isLayakDipinjam()) {
            throw new KoleksiTidakLayakException(target.getJudul());
        }

        if (target.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(target.getJudul());
        }

        target.setSedangDipinjam(true);
        System.out.println("Berhasil meminjam: " + target.getJudul());
    }
}