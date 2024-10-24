package commands;

import main.Main;
import railway.Train;

public class Commands {

    // Створюєм інтерфейс Command
    public interface Command {
        void execute();
    }

    // 1
    public static class CreateTrain implements Command {
        public CreateTrain(Train train) {
        }

        public void execute() {
            Main.createTrain();
        }
    }

    // 2
    public static class ShowTrain implements Command {
        private final Train train;

        public ShowTrain(Train train) {
            this.train = train;
        }

        public void execute() {
            System.out.println("Потяги: " + "\n" + train.toString());
        }
    }

    // 3
    public static class CountPassengers implements Command {
        private final Train train;

        public CountPassengers(Train train) {
            this.train = train;
        }

        public void execute() {
            System.out.println("Загальна кількість пасажирів: " + train.getTotalPassengers());
        }
    }

    // 4
    public static class CountBaggage implements Command {
        private final Train train;

        public CountBaggage(Train train) {
            this.train = train;
        }

        public void execute() {
            System.out.println("Загальна кількість багажу: " + train.getTotalBaggage());
        }
    }

    // 5
    public static class SortRailcarsByComfortLevel implements Command {
        private final Train train;

        public SortRailcarsByComfortLevel(Train train) {
            this.train = train;
        }

        public void execute() {
            train.sortRailcarsByComfortLevel();
            System.out.println("Вагони відсортовані за комфортністю.");
        }
    }

    // 6
    public static class SearchRailcarsByPassengers implements Command {
        public SearchRailcarsByPassengers(Train train) {
        }

        public void execute() {
            Main.searchRailcarsByPassengers();
        }
    }

    // 7
    public static class DownloadFromFile implements Command {
        public DownloadFromFile(Train train) {
        }

        public void execute() {
            // Main.downloadFromFile();
            System.out.println("Завантаження з файлу (поки що не реалізовано).");
        }
    }

    // Створити клас Invoker
    public static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }
}
