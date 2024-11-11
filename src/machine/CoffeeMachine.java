package machine;

import java.sql.Array;
import java.util.Objects;

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

    public void printMachineStatus() {
        System.out.println("The coffee machine has:");
        water.printStatus();
        milk.printStatus();
        coffeebeans.printStatus();
        disposableCups.printStatus();
        machineMoney.printStatus();

        System.out.println();
    }

    public void coffeeMenu() {
        int action = inputHelper.getInt("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");

        switch(action){
            case 1:
                prepareCoffee(CoffeeRecipe.ESPRESSO);
                break;
            case 2:
                prepareCoffee(CoffeeRecipe.LATTE);
                break;
            case 3:
                prepareCoffee(CoffeeRecipe.CAPUCCINO);
                break;
            default:
                System.out.println("Wrong action!");
        }
    }

    public void prepareCoffee(CoffeeRecipe recipe){
        water.subtractAmount(recipe.showWater());
        milk.subtractAmount(recipe.showMilk());
        coffeebeans.subtractAmount(recipe.showCoffeeBeans());
        disposableCups.subtractCups(1);
        machineMoney.addMoney(recipe.showPrice());
        printMachineStatus();
    }


    public void showMainMenu() {
        printMachineStatus();
        String[] actions = {"buy", "fill", "take"};
        String action = inputHelper.getString("Write action (buy, fill, take)");

        while (!action.equals("buy") && !action.equals("fill") && !action.equals("take")) {
            action = inputHelper.getString("Write action (buy, fill, take)");
        }


    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 500, 120, 550, 9);
        machine.showMainMenu();
    }
}


// creamos una clase que sea MachineMenu
// en esta clase se instancian los ingredientes, las copas y el dinero
