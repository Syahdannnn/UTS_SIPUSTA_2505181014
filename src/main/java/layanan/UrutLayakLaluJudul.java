package layanan;

import java.util.Comparator;
import model.Koleksi;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    @Override
    public int compare(Koleksi k1, Koleksi k2) {
        int perbandinganLayak = Boolean.compare(k2.isLayakDipinjam(), k1.isLayakDipinjam());
        if (perbandinganLayak != 0) {
            return perbandinganLayak;
        }
        return k1.getJudul().compareToIgnoreCase(k2.getJudul());
    }
}