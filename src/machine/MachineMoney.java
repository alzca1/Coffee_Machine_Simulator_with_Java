package machine;

public class MachineMoney {
    private int amount;

    public MachineMoney(){
        amount = 0;
    }

    public int showMoney(){
        return amount;
    }

    public void addMoney(int amountToAdd){
        amount += amountToAdd;
    }

    public void subtractMoney(int amountToSubtract){
        if(amount > amountToSubtract){
            amount -= amountToSubtract;
            return;
        }

        System.out.println("You cannot subtract the specified amount");
    }

}