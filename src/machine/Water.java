package machine;

public class Water implements Ingredient{
    private int amount;
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

    @Override
    public void printStatus(){
        System.out.println(amount + " ml of water");
    }

    @Override
    public void subtractAmount(int amountToSubtract){
        this.amount -= amountToSubtract; 
    }
}