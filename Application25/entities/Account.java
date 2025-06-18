package Application25.entities;
import Application25.entities.Exceptions.WithdrawLimitExceededException;
import Application25.entities.Exceptions.InsufficientBalanceException;
import Application25.entities.Exceptions.InvalidValueException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){

    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        if (balance < 0) throw new InvalidValueException("Initial amount must be positive.");
        if (withdrawLimit == null || withdrawLimit <= 0) throw new InvalidValueException("Withdraw limit must be positive");
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        if (amount == null || amount <= 0) {
            throw new InvalidValueException("Deposit amount must be greater than zero.");
        }
        this.balance += amount;

    }

    public void withdraw(Double amount){
        if( amount == null || amount <= 0){
           throw new InvalidValueException("Amount must be greater than zero.");
        }
        if(amount > getWithdrawLimit()){
            throw new WithdrawLimitExceededException("Withdraw limit exceeded.");
        }
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient balance.");
        }

        this.balance -= amount;
    }
}
