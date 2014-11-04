package exceptions;

public class CryptographicOperationException extends Exception{
    public CryptographicOperationException () {

    }

    public CryptographicOperationException(String message) {
        super(message);
    }

    public CryptographicOperationException(Throwable cause) {
        super(cause);
    }

    public CryptographicOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
