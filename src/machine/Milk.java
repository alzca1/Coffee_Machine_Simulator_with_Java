package machine;

public class Milk {
    private static int availableMilk = 540;

    public static void addMilk (int amount){
        availableMilk += amount;
    }

    public static void subtractMilk (int amount){
        availableMilk -= amount;
    }

    public static int getMilk(){
        return availableMilk;
    }

    public static void getMilkInfo(){
        System.out.println(availableMilk + " ml of milk");
    }

}
