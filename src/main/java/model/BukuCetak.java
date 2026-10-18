package model;

public class BukuCetak extends Koleksi implements Terarsip {
    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit, int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean isLayakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public int lokasiLantai() {
        return 1;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + String.format(" | Jenis: Buku Cetak | Halaman: %d | Status Diperbaiki: %s | %s",
                jumlahHalaman, sedangDiperbaiki ? "Ya" : "Tidak", ringkasanArsip());
    }
}