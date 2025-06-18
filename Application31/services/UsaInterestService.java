package Application31.services;

public class UsaInterestService implements InterestService {

    private double interestRate;

    public UsaInterestService(double interestRate){
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

}
