package model;

public interface Terarsip {
    String nomorRak();
    int lokasiLantai();

    default String ringkasanArsip() {
        return "Lokasi Fisik: Rak " + nomorRak() + " (Lantai " + lokasiLantai() + ")";
    }
}