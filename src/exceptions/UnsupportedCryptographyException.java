package exceptions;

public class UnsupportedCryptographyException extends UnsupportedOperationException{
    public UnsupportedCryptographyException () {

    }

    public UnsupportedCryptographyException (String message) {
        super (message);
    }

    public UnsupportedCryptographyException (Throwable cause) {
        super (cause);
    }

    public UnsupportedCryptographyException (String message, Throwable cause) {
        super (message, cause);
    }
}
