package machine;

public class DisposableCups {
    private int cupsAmount;

    public DisposableCups(int cupsAmount){
        this.cupsAmount = cupsAmount;
    }

    public int showCups(){
        return this.cupsAmount;
    }

    public void addCups(int amountToAdd){
        cupsAmount += amountToAdd;
    }

    public void subtractCups(int amountToSubtract){
        cupsAmount -= amountToSubtract;
    }

    public void printStatus(){
        System.out.println(cupsAmount + " disposable cups");
    }
}