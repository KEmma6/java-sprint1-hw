public class Converter {

    public void distanceCalculation(int steps){
        int distance = steps * 75;
        System.out.println("Пройденная дистанция составляет " + distance/1000 + " км");
    }

    public void caloriesCalculation(int steps){
        int calories = steps * 50;
        System.out.println("Вы сожгли " + calories/1000 + " килокалорий");
    }
}
