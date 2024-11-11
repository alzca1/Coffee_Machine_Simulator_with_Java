package machine;

public enum CoffeeRecipe {

    ESPRESSO(250, 0, 16, 4),
    LATTE(350,75, 20, 7 ),
    CAPUCCINO(200, 100, 12, 6);


    private final int waterAmount;
    private final int milkAmount;
    private final int coffeeBeansAmount;
    private final int price;

    CoffeeRecipe(int waterAmount, int milkAmount, int coffeeBeansAmount, int price){
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
        this.coffeeBeansAmount = coffeeBeansAmount;
        this.price = price;
    }

    public int showWater(){
        return waterAmount;
    }
    public int showMilk(){
        return milkAmount;
    }

    public int showCoffeeBeans(){
        return coffeeBeansAmount;
    }

    public int showPrice(){
        return price;
    }
}