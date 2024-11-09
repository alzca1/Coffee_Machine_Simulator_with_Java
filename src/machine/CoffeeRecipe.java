package machine;

public class CoffeeRecipe {
    private int necessaryWater;
    private int necessaryMilk;
    private int necessaryCoffeeBeans;

    public CoffeeRecipe(){
        this.necessaryWater = 200;
        this.necessaryMilk = 50;
        this.necessaryCoffeeBeans = 15;
    }


    public int water(){
        return necessaryWater;
    }

    public int milk() {
        return necessaryMilk;
    }

    public int coffeeBeans(){
        return necessaryCoffeeBeans;
    }

}
