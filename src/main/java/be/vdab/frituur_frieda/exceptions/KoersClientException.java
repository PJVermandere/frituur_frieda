package be.vdab.frituur_frieda.exceptions;

public class KoersClientException extends RuntimeException {
    public KoersClientException(String msg) {
        super(msg);
    }
    public KoersClientException(String msg, Exception ex) {
        super(msg, ex);
    }
}
