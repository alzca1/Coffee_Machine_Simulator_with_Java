package machine;

public class Water implements Ingredient{
    private int amount;
    private final Type type = Type.WATER;

    public Water(int amount){
        this.amount = amount;
    }

    @Override
    public int showAmount(){
        return amount;
    }

    @Override
    public void addAmount(int amountToAdd){
        this.amount += amountToAdd;
    }
}