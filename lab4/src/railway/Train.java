package railway;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Train {
    private List<Railcar> railcars;

    public Train() {
        this.railcars = new ArrayList<>();
    }

    public void addRailcar(Railcar railcar) {
        railcars.add(railcar);
    }

    public int getTotalPassengers() {
        return railcars.stream().mapToInt(Railcar::getPassengerCount).sum();
    }

    public int getTotalBaggage() {
        return railcars.stream().mapToInt(Railcar::getBaggageWeight).sum();
    }

    public void sortRailcarsByComfortLevel() {
        railcars.sort(Comparator.comparingInt(Railcar::getComfortLevel));
    }

    public List<Railcar> findRailcarsByPassengerRange(int minPassengers, int maxPassengers) {
        List<Railcar> result = new ArrayList<>();
        for (Railcar railcar : railcars) {
            if (railcar.getPassengerCount() >= minPassengers && railcar.getPassengerCount() <= maxPassengers) {
                result.add(railcar);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Railcar railcar : railcars) {
            builder.append(railcar.toString()).append("\n");
        }
        return builder.toString();
    }
}
