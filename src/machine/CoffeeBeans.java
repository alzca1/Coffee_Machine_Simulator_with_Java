package machine;

public class CoffeeBeans implements Ingredient{
    private int amount;
    private InputHelper inputHelper;

    public CoffeeBeans(int amount){
        this.amount = amount;
        inputHelper = new InputHelper();
    }

    @Override
    public int showAmount(){
        return amount;
    }

    @Override
    public void addAmount(){
        int amountToAdd = inputHelper.getInt("Write how many grams of coffee beans you want to add:");
        this.amount += amountToAdd;
    }

    @Override
    public void printStatus(){
        System.out.println(amount + " g of coffee beans");
    }

    @Override
    public void subtractAmount(int amountToSubtract){
        if (this.amount > amountToSubtract) {
            this.amount -= amountToSubtract;
            return;
        }
        System.out.println("Not enough water!");
    }
}