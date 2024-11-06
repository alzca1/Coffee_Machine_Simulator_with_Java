package machine;

public class CoffeeBeans {
    private static int availableCoffeeBeans = 120;

    public static void addCoffeeBeans(int amount){
        availableCoffeeBeans += amount;
    }

    public static void subtractCoffeeBeans(int amount){
        availableCoffeeBeans -= amount;
    }

    public static int getCoffeeBeans(){
        return availableCoffeeBeans;
    }

    public static void getCoffeeBeansInfo(){
        System.out.println(availableCoffeeBeans + " ml of coffee beans");
    }
}
