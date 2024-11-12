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
        showMainMenu();
    }

    public void showWrongAction() {
        System.out.println("Wrong action!");
    }

    public void coffeeMenu() {
        String action = inputHelper.getString("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

        while (!action.equals("1") && !action.equals("2") && !action.equals("3") && !action.equals("back")) {
            showWrongAction();
            action = inputHelper.getString("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        }

        switch (action) {
            case "1":
                prepareCoffee(CoffeeRecipe.ESPRESSO);
                break;
            case "2":
                prepareCoffee(CoffeeRecipe.LATTE);
                break;
            case "3":
                prepareCoffee(CoffeeRecipe.CAPUCCINO);
                break;
            case "back":
                showMainMenu();
            default:
                showWrongAction();
        }
    }

    private boolean canPrepareCoffee(CoffeeRecipe recipe) {
        if (water.showAmount() < recipe.showWater()) {
            System.out.println("Sorry, not enough water!");
            return false;
        }

        if (milk.showAmount() < recipe.showMilk()) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }

        if (coffeebeans.showAmount() < recipe.showCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }

        if (disposableCups.showCups() < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }

        return true;
    }


    public void prepareCoffee(CoffeeRecipe recipe) {
        boolean canBeMade = canPrepareCoffee(recipe);
        if (!canBeMade) {
            showMainMenu();
            return;
        }
        System.out.println("I have enough resources, making you a coffee!");
        water.subtractAmount(recipe.showWater());
        milk.subtractAmount(recipe.showMilk());
        coffeebeans.subtractAmount(recipe.showCoffeeBeans());
        disposableCups.subtractCups(1);
        machineMoney.addMoney(recipe.showPrice());
        showMainMenu();
    }

    public void fillMenu() {
        water.addAmount();
        milk.addAmount();
        coffeebeans.addAmount();
        disposableCups.addCups();
        System.out.println();
        showMainMenu();
    }

    public void takeMoney() {
        int moneyToTake = machineMoney.showMoney();
        System.out.println("I gave you $" + machineMoney.showMoney());
        machineMoney.subtractMoney(moneyToTake);
        showMainMenu();
    }

    public void exit() {
        return;
    }


    public void showMainMenu() {
        String[] actions = {"buy", "fill", "take", "remaining"};
        String action = inputHelper.getString("Write action (buy, fill, take, remaining, exit)");

        while (!action.equals("buy") && !action.equals("fill") && !action.equals("take") && !action.equals("remaining") && !action.equals("exit")) {
            showWrongAction();
            action = inputHelper.getString("Write action (buy, fill, take, remaining, exit)");
        }


        switch (action) {
            case "buy":
                coffeeMenu();
                break;
            case "fill":
                fillMenu();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printMachineStatus();
                break;
            case "exit":
                exit();
                break;
            default:
                showWrongAction();
                break;
        }


    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 550, 9);
        machine.showMainMenu();
    }
}


