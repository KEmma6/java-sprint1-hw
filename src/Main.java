import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    printMenu();

    int userInput = scanner.nextInt();

        while(userInput !=0) {
        // обработка разных случаев
            if (userInput == 1){

            } else if (userInput == 2){

            } else if (userInput == 3){

            }

        printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
        userInput = scanner.nextInt(); // повторное считывание данных от пользователя
    }
        System.out.println("Программа завершена");
}


    private static void printMenu() {
        System.out.println("Добро пожаловать в приложение Счётчик калорий");
        System.out.println("Для ввода количества шагов нажмите - 1");
        System.out.println("Чтобы напечатать статистику за месяц нажмите - 2");
        System.out.println("Хотите изменить цель по количеству шагов в день? Нажмите - 3");
        System.out.println("Для выхода из приложения нажмите - 0");
    }
}
