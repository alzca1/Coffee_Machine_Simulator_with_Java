package machine;

public class CoffeeBeans implements Ingredient{
    private int amount;
    private final Type type = Type.COFFEEBEANS;

    public CoffeeBeans(int amount){
        this.amount = amount;
    }

    @Override
    public int showAmount(){
        return amount;
    }

    @Override
    public void addAmount(int amountToAdd){
        amount += amountToAdd;
    }
}