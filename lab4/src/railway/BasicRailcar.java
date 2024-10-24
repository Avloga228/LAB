package railway;

public class BasicRailcar extends Railcar {
    public BasicRailcar(int passengerCount, int baggageWeight) {
        super(passengerCount, baggageWeight);
        setComfortLevel(1);
    }

    @Override
    public String toString() {
        return "PassengerRailcar   " + super.toString();
    }
}
