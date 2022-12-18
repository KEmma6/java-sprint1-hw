import static java.lang.StrictMath.round;

public class Converter {

    public void distanceCalculation(int steps){
        double distance = steps * 75;
        System.out.println("Пройденная дистанция составляет " + Math.round(distance/100000) + " км");
    }

    public void caloriesCalculation(int steps){
        double calories = steps * 50;
        System.out.println("Вы сожгли " + Math.round(calories/1000) + " килокалорий");
    }
}
