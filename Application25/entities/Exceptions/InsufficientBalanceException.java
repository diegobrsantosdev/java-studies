package Application25.entities.Exceptions;

public class InsufficientBalanceException extends RuntimeException {

  public InsufficientBalanceException(String message) {
    super(message);
  }

}
