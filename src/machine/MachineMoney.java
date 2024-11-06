package machine;

public class MachineMoney {
    private static int availableMoney = 550;

    public static void addMoney(int amount){
        availableMoney += amount;
    }

    public static void subtractMoney(int amount){
        availableMoney -= amount;
    }

    public static void collectMoney(){
        System.out.println("Collecting $" + availableMoney + " of money" );
        availableMoney = 0;
    }

    public static int getMoney(){
        return availableMoney;
    }

    public static void getMoneyInfo(){
        System.out.println("$" + availableMoney + " of money");
    }

}
