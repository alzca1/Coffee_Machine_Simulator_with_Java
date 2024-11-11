package machine;

public class CoffeeBeans implements Ingredient{
    private int amount;

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

    @Override
    public void printStatus(){
        System.out.println(amount + " g of coffee beans");
    }

    @Override
    public void subtractAmount(int amountToSubtract){
        this.amount -= amountToSubtract;
    }
}