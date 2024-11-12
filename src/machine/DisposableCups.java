package machine;

public class DisposableCups {
    private int cupsAmount;
    private InputHelper inputHelper;

    public DisposableCups(int cupsAmount){
        this.cupsAmount = cupsAmount;
        inputHelper = new InputHelper();
    }

    public int showCups(){
        return this.cupsAmount;
    }

    public void addCups(){
        int amountToAdd = inputHelper.getInt("Write how many disposable cups you want to add:");
        this.cupsAmount += amountToAdd;
    }

    public void subtractCups(int amountToSubtract){
        if (this.cupsAmount > amountToSubtract) {
            this.cupsAmount -= amountToSubtract;
            return;
        }
        System.out.println("Not enough water!");
    }

    public void printStatus(){
        System.out.println(cupsAmount + " disposable cups");
    }
}