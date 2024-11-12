package machine;

public class MachineMoney {
    private int amount;

    public MachineMoney(int amount){
        this.amount = amount;
    }

    public int showMoney(){
        return amount;
    }

    public void addMoney(int amountToAdd){
        amount += amountToAdd;
    }

    public void subtractMoney(int amountToSubtract){
        if(amount >= amountToSubtract){
            amount -= amountToSubtract;
            return;
        }

        System.out.println("You cannot subtract the specified amount");
    }

    public void printStatus(){
        System.out.println("$" + amount + " of money");
    }

}