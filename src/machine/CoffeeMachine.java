package machine;

public class CoffeeMachine {

    private Water water;
    private Milk milk;
    private CoffeeBeans coffeebeans;
    private MachineMoney machineMoney;
    private DisposableCups disposableCups;
    private final InputHelper inputHelper;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int machineMoney, int disposableCups) {
        this.water = new Water(water);
        this.milk = new Milk(milk);
        this.coffeebeans = new CoffeeBeans(coffeeBeans);
        this.machineMoney = new MachineMoney(machineMoney);
        this.disposableCups = new DisposableCups(disposableCups);
        this.inputHelper = new InputHelper();
    }

    public void printMachineStatus(){
        System.out.println("The coffee machine has:");
        water.printStatus();
        milk.printStatus();
        coffeebeans.printStatus();
        disposableCups.printStatus();
        machineMoney.printStatus();

        System.out.println();
    }

    public void showMenu(){
        printMachineStatus();
        int action = inputHelper.getInt("Write action (buy, fill, take)");
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 500, 120, 550, 9);
        machine.showMenu();
    }
}


// creamos una clase que sea MachineMenu
// en esta clase se instancian los ingredientes, las copas y el dinero
