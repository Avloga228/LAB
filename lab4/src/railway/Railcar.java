package railway;

public abstract class Railcar {
    private int passengerCount;
    private int baggageWeight;
    public int comfortLevel;

    public Railcar(int passengerCount, int baggageWeight) {
        this.passengerCount = passengerCount;
        this.baggageWeight = baggageWeight;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(int baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(int comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    @Override
    public String toString() {
        return "Railcar{" +
                "passengerCount=" + passengerCount +
                ", baggageWeight=" + baggageWeight +
                ", comfortLevel=" + comfortLevel +
                '}';
    }
}
