package main;

import commandWithDescription.CommandWithDescription;
import commands.*;
import railway.*;

import java.util.List;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Train train = new Train();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Створюєм команди
        Commands.CreateTrain createTrain = new Commands.CreateTrain(train);
        Commands.ShowTrain showTrain = new Commands.ShowTrain(train);
        Commands.CountPassengers countPassengers = new Commands.CountPassengers(train);
        Commands.CountBaggage countBaggage = new Commands.CountBaggage(train);
        Commands.SortRailcarsByComfortLevel sortRailcarsByComfortLevel = new Commands.SortRailcarsByComfortLevel(train);
        Commands.SearchRailcarsByPassengers searchRailcarsByPassengers = new Commands.SearchRailcarsByPassengers(train);
        Commands.DownloadFromFile downloadFromFile = new Commands.DownloadFromFile(train);

        // Створюєм invoker
        Commands.RemoteControl event = new Commands.RemoteControl();

        // Створюємо асоціацію команд з їх номерами
        Map<Integer, CommandWithDescription> menuCommands = new HashMap<>();
        menuCommands.put(1, new CommandWithDescription("Створити потяг", createTrain));
        menuCommands.put(2, new CommandWithDescription("Показати потяг", showTrain));
        menuCommands.put(3, new CommandWithDescription("Підрахувати загальну кількість пасажирів", countPassengers));
        menuCommands.put(4, new CommandWithDescription("Підрахувати загальну кількість багажу", countBaggage));
        menuCommands.put(5, new CommandWithDescription("Сортувати вагони за рівнем комфортності", sortRailcarsByComfortLevel));
        menuCommands.put(6, new CommandWithDescription("Пошук вагонів за кількістю пасажирів", searchRailcarsByPassengers));
        menuCommands.put(7, new CommandWithDescription("Завантажити з файлу", downloadFromFile));
        menuCommands.put(0, new CommandWithDescription("Вихід", null));

        // Створюємо Scanner для читання вводу користувача
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Меню для вибору команд
        while (choice != 0) {
            System.out.println("Меню:");

            // Цикл виведення меню через Map
            for (Map.Entry<Integer, CommandWithDescription> entry : menuCommands.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue().getDescription());

            }

            System.out.print("Виберіть опцію: ");
            choice = scanner.nextInt();  // Зчитуєм вибір користувача

            // Перевіряємо чи існує команда для даного вибору
            if (menuCommands.containsKey(choice)) {
                if(choice != 0) {
                    CommandWithDescription selectedCommand = menuCommands.get(choice);
                    System.out.println("Ви обрали: " + selectedCommand.getDescription());

                    // Завантажуємо команду в пульт і виконуємо її
                    event.setCommand(selectedCommand.getCommand());
                    event.pressButton();
                }
            } else {
                System.out.println("Неправильний вибір");
            }
        }
        System.out.println("Вихід...");
    }

    public static void createTrain() {
        System.out.println("Створюємо потяг...");
        train.addRailcar(new BasicRailcar(100, 500));
        train.addRailcar(new LuxuryRailcar(50, 300));
        train.addRailcar(new BasicRailcar(80, 400));
        System.out.println("Потяг створено.");
    }

    public static void searchRailcarsByPassengers() {
        System.out.print("Введіть мінімальну кількість пасажирів: ");
        int min = scanner.nextInt();
        System.out.print("Введіть максимальну кількість пасажирів: ");
        int max = scanner.nextInt();
        List<Railcar> railcars = train.findRailcarsByPassengerRange(min, max);
        if (railcars.isEmpty()) {
            System.out.println("Вагонів з такою кількістю пасажирів не знайдено.");
        } else {
            System.out.println("Знайдені вагони:");
            railcars.forEach(System.out::println);
        }
    }
}
