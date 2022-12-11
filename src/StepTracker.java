import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {

   // int days = 30;
    //int months = 12;
    int goalsOfSteps = 10000;
    int [][] monthsAndDay = new int[12][30];
   // int [] steps = new int[30];
    Scanner scanner = new Scanner(System.in);
    //HashMap<int[][],Integer> test = new HashMap();

    public void saveSteps(){
        System.out.println("Укажите номер месяца");
        int monthNumber = scanner.nextInt();
        System.out.println("Укажите номер дня");
        int dayNumber = scanner.nextInt();
        System.out.println("Укажите количество шагов за день");
        int stepsOnDay = scanner.nextInt();
        if(dayNumber>=0 && dayNumber<30){
            if(stepsOnDay>0){
                monthsAndDay[monthNumber][dayNumber] = stepsOnDay;
            } else{
                System.out.println("Количество шагов не может быть отрицательным значением");
            }
        } else{
            System.out.println("Номер дня не может быть меньше 0 или больше 30");
        }
    }

    public void sumStepsOnMonth(){
        System.out.println("Укажите номер месяца");
        int monthNumber = scanner.nextInt();
        System.out.println("Сумма шагов за месяц составила " + Arrays.stream(monthsAndDay[monthNumber]).sum());
    }

    public void maxStepsOnMonth(){
        System.out.println("Укажите номер месяца");
        int monthNumber = scanner.nextInt();
        System.out.println("Максимальное количество шагов за месяц " + Arrays.stream(monthsAndDay[monthNumber]).max());
    }

    public void averageStepsOnMonth(){
        System.out.println("Укажите номер месяца");
        int monthNumber = scanner.nextInt();
        System.out.println("Сумма шагов за месяц составила " + Arrays.stream(monthsAndDay[monthNumber]).average());
    }

    public void changeGoal(){
        System.out.println("Укажите желаемую цель");
        int goal = scanner.nextInt();
        if(goal>0){
            goalsOfSteps = goal;
            System.out.println("Теперь цель за день " + goalsOfSteps + " шагов");
        } else {
            System.out.println("Цель не может быть меньше 0");
        }
    }

//    for(int i = 0; i < steps.length; i++){
//
//    }
}
