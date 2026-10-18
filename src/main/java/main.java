import model.*;
import layanan.*;
import eksepsi.*;
import utilitas.*;

public class main {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // 1. Mengisi Data Uji Wajib (6 Koleksi)
        katalog.tambahKoleksi(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", false));
        katalog.tambahKoleksi(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", true));
        katalog.tambahKoleksi(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "B-04", true));
        katalog.tambahKoleksi(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "B-04", false));
        katalog.tambahKoleksi(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15.0, "unduh.polmed.ac.id/bd001"));
        katalog.tambahKoleksi(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8.0, "unduh.polmed.ac.id/bd002"));

        // 2. Menampilkan Status Awal Katalog (Polimorfisme)
        System.out.println("--- STATUS KATALOG AWAL ---");
        katalog.cetakStatus();

        // 3. Mengurutkan Koleksi (Layak Pinjam Dahulu -> Judul)
        System.out.println("--- PENGURUTAN KATALOG (LAYAK DIPINJAM -> JUDUL) ---");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        // 4. Pengujian Eksepsi Peminjaman
        System.out.println("--- UJI COBA PEMINJAMAN ---");
        
        // Uji Bikin Sukses
        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.err.println(e.getMessage());
        }

        // Uji Koleksi Sedang Dipinjam
        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.out.println("Penanganan Eksepsi: " + e.getMessage());
        }

        // Uji Koleksi Tidak Layak Dipinjam (Sedang Diperbaiki)
        try {
            katalog.pinjam("BK-002");
        } catch (PustakaException e) {
            System.out.println("Penanganan Eksepsi: " + e.getMessage());
        }

        // Uji Koleksi Tidak Layak Dipinjam (Edisi Terbaru)
        try {
            katalog.pinjam("MJ-001");
        } catch (PustakaException e) {
            System.out.println("Penanganan Eksepsi: " + e.getMessage());
        }
        
        System.out.println();

        // 5. Ekspor Katalog ke berkas katalog.txt
        EksporKatalog.eksporKeTeks(katalog.getDaftarKoleksi(), "katalog.txt");
    }
}