package Application23.entities;

public class Company extends TaxPayer{

    private Integer numberOfEmplooyes;

    public Company(){
        super();

    }

    public Company(String name, Double anualIncome, Integer numberOfEmplooyes) {
        super(name, anualIncome);
        this.numberOfEmplooyes = numberOfEmplooyes;
    }

    public Integer getNumberOfEmplooyes() {
        return numberOfEmplooyes;
    }

    public void setNumberOfEmplooyes(Integer numberOfEmplooyes) {
        this.numberOfEmplooyes = numberOfEmplooyes;
    }

    @Override
    public double tax(){
        if(numberOfEmplooyes > 10){
          return getAnualIncome() * 0.14;
        }
        else{
          return getAnualIncome() * 0.16;
        }

    }
}
