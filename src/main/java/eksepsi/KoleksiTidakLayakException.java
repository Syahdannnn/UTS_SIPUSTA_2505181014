package eksepsi;

public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String judul) {
        super("Maaf, koleksi '" + judul + "' tidak dapat dipinjam karena statusnya belum layak (sedang diperbaiki atau edisi terbaru).");
    }
}