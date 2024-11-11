package machine;

public class Milk implements Ingredient{
    private int amount;
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

    @Override
    public void printStatus(){
        System.out.println(amount + " ml of milk");
    }

    @Override
    public void subtractAmount(int amountToSubtract){
        this.amount -= amountToSubtract;
    }
}