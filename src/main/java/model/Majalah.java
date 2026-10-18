package model;

public class Majalah extends Koleksi implements Terarsip {
    private int edisi;
    private String bulanTerbit;
    private String nomorRak;
    private boolean edisiTerbaru;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit, int edisi, String bulanTerbit, String nomorRak, boolean edisiTerbaru) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRak = nomorRak;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean isLayakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public int lokasiLantai() {
        return 2;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + String.format(" | Jenis: Majalah | Edisi: %d (%s) | Edisi Terbaru: %s | %s",
                edisi, bulanTerbit, edisiTerbaru ? "Ya" : "Tidak", ringkasanArsip());
    }
}