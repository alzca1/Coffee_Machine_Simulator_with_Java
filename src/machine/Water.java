package machine;

public class Water {
    private static int availableWater = 400;

    public static void addWater(int amount){
        availableWater += amount;
    }

    public static void subtractWater(int amount){
        availableWater -= amount;
    }

    public static void getWaterInfo(){
        System.out.println(availableWater + " ml of water");
    }

    public static int getWater(){
        return availableWater;
    }
}
