package machine;

public class Milk implements Ingredient{
    private int amount;
    private final Type type = Type.MILK;

    public Milk (int amount){
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