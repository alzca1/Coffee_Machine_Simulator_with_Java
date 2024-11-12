package machine;

public class Water implements Ingredient {
    private int amount;
    private InputHelper inputHelper;

    public Water(int amount) {
        this.amount = amount;
        inputHelper = new InputHelper();
    }

    @Override
    public int showAmount() {
        return amount;
    }

    @Override
    public void addAmount() {
        int amountToAdd = inputHelper.getInt("Write how many ml of water you want to add:");
        this.amount += amountToAdd;
    }

    @Override
    public void printStatus() {
        System.out.println(amount + " ml of water");
    }

    @Override
    public void subtractAmount(int amountToSubtract) {
        if (this.amount > amountToSubtract) {
            this.amount -= amountToSubtract;
            return;
        }
        System.out.println("Not enough water!");
    }
}