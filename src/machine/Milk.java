package machine;

public class Milk implements Ingredient{
    private int amount;
    private InputHelper inputHelper;
    public Milk (int amount){
        this.amount = amount;
        inputHelper = new InputHelper();
    }

    @Override
    public int showAmount(){
        return amount;
    }

    @Override
    public void addAmount(){
        int amountToAdd = inputHelper.getInt("Write how many ml of milk you want to add:");
        this.amount += amountToAdd;
    }

    @Override
    public void printStatus(){
        System.out.println(amount + " ml of milk");
    }

    @Override
    public void subtractAmount(int amountToSubtract){

        if (this.amount > amountToSubtract) {
            this.amount -= amountToSubtract;
            return;
        }
    }
}