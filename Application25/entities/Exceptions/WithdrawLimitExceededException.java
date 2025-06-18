package Application25.entities.Exceptions;

public class WithdrawLimitExceededException extends RuntimeException {

  public WithdrawLimitExceededException(String message) {
    super(message);
  }

}
