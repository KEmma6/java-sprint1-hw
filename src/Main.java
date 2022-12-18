import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        System.out.println("Добро пожаловать в приложение Счётчик калорий!");
        printMenu();

        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                stepTracker.saveSteps();
            } else if (userInput == 2) {
                System.out.println("Укажите номер месяца");
                int monthNumber = scanner.nextInt();
                stepTracker.countingStatistic(monthNumber);
            } else if (userInput == 3) {
                stepTracker.changeGoal();
            } else  {
                System.out.println("Вы ввели неверное значение! Попробуйте еще раз.");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }


    private static void printMenu() {
        System.out.println("Для ввода количества шагов нажмите - 1");
        System.out.println("Чтобы напечатать статистику за месяц нажмите - 2");
        System.out.println("Хотите изменить цель по количеству шагов в день? Нажмите - 3");
        System.out.println("Для выхода из приложения нажмите - 0");
    }
}
