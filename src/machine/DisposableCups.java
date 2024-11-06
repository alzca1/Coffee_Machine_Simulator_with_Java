package machine;

public class DisposableCups {
    private static int availableCups = 9;

    public static void addCups(int amount){
        availableCups += amount;
    }

    public static void subtractCups(int amount){
        availableCups -= amount;
    }

    public static int getCups(){
        return availableCups;
    }

    public static void getCupsInfo(){
        System.out.println(availableCups + " disposable cups");
    }

}
