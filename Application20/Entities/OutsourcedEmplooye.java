package Application20.Entities;

public class OutsourcedEmplooye extends Emplooye {

    private Double AdditionalCharge;

    public OutsourcedEmplooye(){
        super();

    }

    public OutsourcedEmplooye(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(name, hours, valuePerHour);
        AdditionalCharge = additionalCharge;
    }

    public Double getAdditionalCharge() {
        return AdditionalCharge;
    }

    public void setAdditionalCharge(Double additionalCharge) {
        AdditionalCharge = additionalCharge;
    }

    @Override
    public double payment(){
        return super.payment() + getAdditionalCharge() * 1.1;
    }
}
