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

    public void showWrongAction(){
        System.out.println("Wrong action!");
    }

    public void coffeeMenu() {
        int action = inputHelper.getInt("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");

        while(action != 1 && action != 2 && action != 3){
           showWrongAction();
            action = inputHelper.getInt("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
        }

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
                showWrongAction();
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

    public void fillMenu(){
        water.addAmount();
        milk.addAmount();
        coffeebeans.addAmount();
        disposableCups.addCups();
        System.out.println();
        printMachineStatus();
    }

    public void takeMoney(){
        int moneyToTake = machineMoney.showMoney();
        System.out.println("I gave you $" + machineMoney.showMoney());
        machineMoney.subtractMoney(moneyToTake);
        printMachineStatus();
    }


    public void showMainMenu() {
        printMachineStatus();
        String[] actions = {"buy", "fill", "take"};
        String action = inputHelper.getString("Write action (buy, fill, take)");

        while (!action.equals("buy") && !action.equals("fill") && !action.equals("take")) {
            showWrongAction();
            action = inputHelper.getString("Write action (buy, fill, take)");
        }

        switch(action){
            case "buy":
                coffeeMenu();
                break;
            case "fill":
                fillMenu();
                break;
            case "take":
                takeMoney();
                break;
            default:
                showWrongAction();
        }


    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 550, 9);
        machine.showMainMenu();
    }
}


