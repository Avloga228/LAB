package railway;

public class LuxuryRailcar extends Railcar {
    public LuxuryRailcar(int passengerCount, int baggageWeight) {
        super(passengerCount, baggageWeight);
        setComfortLevel(2);
    }

    @Override
    public String toString() {
        return "LuxuryRailcar   " + super.toString();
    }
}
