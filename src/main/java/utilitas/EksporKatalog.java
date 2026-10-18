package utilitas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Koleksi;

public class EksporKatalog {
    public static void eksporKeTeks(List<Koleksi> daftarKoleksi, String namaBerkas) {
        String garisGaris = "+------------+----------------------------------+--------+--------------+-----------------+";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaBerkas))) {
            writer.write(garisGaris);
            writer.newLine();

            writer.write(String.format("| %-10s | %-32s | %-6s | %-12s | %-15s |",
                    "KODE", "JUDUL", "TAHUN", "STATUS LAYAK", "SEDANG DIPINJAM"));
            writer.newLine();

            writer.write(garisGaris);
            writer.newLine();

            for (Koleksi k : daftarKoleksi) {
                writer.write(String.format("| %-10s | %-32s | %-6d | %-12s | %-15s |",
                        k.getKodeKoleksi(),
                        k.getJudul(),
                        k.getTahunTerbit(),
                        k.isLayakDipinjam() ? "Ya" : "Tidak",
                        k.isSedangDipinjam() ? "Ya" : "Tidak"));
                writer.newLine();
            }

            writer.write(garisGaris);
            writer.newLine();

            System.out.println("Katalog berhasil diekspor ke berkas: " + namaBerkas);
        } catch (IOException e) {
            System.err.println("Gagal mengekspor katalog: " + e.getMessage());
        }
    }
}