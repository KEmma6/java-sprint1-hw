import java.util.Arrays;
import java.util.Scanner;

public class StepTracker {

    int goalsOfSteps = 10000;
    int[][] monthsAndDay = new int[12][30];
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();

    public void saveSteps() {
        /*я бы не хотела выносить работу с scanner конкретно из этого метода, чтобы не ломать логику с проверкой
        ввода месяца, дня и количества шагов*/
        while (true) {
            System.out.println("Укажите номер месяца. Номера месяцев начинаются с 0");
            int monthNumber = scanner.nextInt();
            if (monthNumber < 12 && monthNumber > 0) {
                while (true) {
                    System.out.println("Укажите номер дня. Первый день начинается с 0");
                    int dayNumber = scanner.nextInt();
                    if (dayNumber >= 0 && dayNumber < 30) {
                        while (true) {
                            System.out.println("Укажите количество шагов за день");
                            int stepsOnDay = scanner.nextInt();
                            if (stepsOnDay > 0) {
                                monthsAndDay[monthNumber][dayNumber] = stepsOnDay;
                                System.out.println("Количество шагов сохранено. " +
                                                           "Месяц: " + monthNumber + ", день: "
                                                           + dayNumber + ", шагов: " + stepsOnDay);
                                return;
                            } else {
                                System.out.println("Количество шагов не может быть отрицательным значением");
                            }
                        }
                    } else {
                        System.out.println("Номер дня не может быть меньше 0 или больше 30");
                    }
                }
            } else {
                System.out.println("Неверный номер месяца");
            }
        }
    }

    public void countingStatistic(int month) {
        printAllSteps(month);
        System.out.println("Сумма шагов за месяц составила " + sumStepsOnMonth(month));
        maxStepsOnMonth(month);
        averageStepsOnMonth(month);
        System.out.println("Пройденная дистанция составляет " + converter
                .distanceCalculation(sumStepsOnMonth(month)) + " км");
        System.out.println("Вы сожгли " + converter
                .caloriesCalculation(sumStepsOnMonth(month)) + " килокалорий");
        printMaxDaysSeries(month);
    }

    public int sumStepsOnMonth(int month) {
        return Arrays.stream(monthsAndDay[month]).sum();
    }

    public void maxStepsOnMonth(int month) {
        System.out.println("Максимальное количество шагов за месяц " + Arrays.stream(monthsAndDay[month]).max().getAsInt());
    }

    public void averageStepsOnMonth(int month) {
        double averageSteps = Arrays.stream(monthsAndDay[month]).average().getAsDouble();
        System.out.println("Среднее количество шагов за месяц составило " + Math.round(averageSteps));
    }

    public void changeGoal(int goal) {
        if (goal > 0) {
            goalsOfSteps = goal;
            System.out.println("Теперь цель за день " + goalsOfSteps + " шагов");
        } else {
            System.out.println("Цель не может быть меньше 0");
        }
    }

    public void printAllSteps(int month) {
        for (int i = 0; i < monthsAndDay[month].length - 1; i++) {
            System.out.print((i + 1) + " день: " + monthsAndDay[month][i] + ", ");
        }
        System.out.println("30 день: " + monthsAndDay[month][monthsAndDay[0].length - 1]);
    }

    public void printMaxDaysSeries(int month) {
        int indexStartBest = -1;
        int lengthBest = 0;
        int indexStartCurrent = -1;
        int lengthCurrent = 0;
        for (int i = 0; i < monthsAndDay[month].length; i++) {
            if (monthsAndDay[month][i] >= goalsOfSteps) {
                if (lengthCurrent == 0) {
                    indexStartCurrent = i;
                }
                lengthCurrent++;
            }
            if (monthsAndDay[month][i] < goalsOfSteps || i == monthsAndDay[month].length - 1) {
                if (lengthCurrent > lengthBest) {
                    indexStartBest = indexStartCurrent;
                    lengthBest = lengthCurrent;
                }
                lengthCurrent = 0;
            }
        }
        System.out.println("Лучшая серия " + lengthBest +
                                   " дней, количество шагов в которой, больше или равно " + goalsOfSteps);
    }
}

