package machine;


import java.util.Arrays;

public class CoffeeMachine {

    public static void getMachineStatus(){
        System.out.println("The coffee machine has:");
        Water.getWaterInfo();
        Milk.getMilkInfo();
        CoffeeBeans.getCoffeeBeansInfo();
        DisposableCups.getCupsInfo();
        MachineMoney.getMoneyInfo();

        chooseOption();
    }

    public static void exitProgram(){
        System.out.println("Exiting...");
        System.exit(0);
    }

    public static String chooseOption(){
        System.out.println();
        return InputHelper.getString("Write action (buy, fill, take, remaining, exit): ");
    }

    public static int displayCoffeeTypeMenu(){
       return InputHelper.getInt("What do you want to buy? 1 – espresso, 2 – latte, 3 – cappuccino:");
    }

    public static void serviceCoffee(){
        int coffeeOption = displayCoffeeTypeMenu();

        while(coffeeOption < 0 || coffeeOption > 3){
            System.out.println("Wrong coffee option!");
            coffeeOption = displayCoffeeTypeMenu();
        }

        if(coffeeOption == 1){
            DisposableCups.subtractCups(1);
            Water.subtractWater(250);
            CoffeeBeans.subtractCoffeeBeans(16);
            MachineMoney.addMoney(4);
        }

        if(coffeeOption == 2){
            DisposableCups.subtractCups(1);
            Water.subtractWater(350);
            Milk.subtractMilk(75);
            CoffeeBeans.subtractCoffeeBeans(20);
            MachineMoney.addMoney(7);
        }

        if(coffeeOption == 3){
            DisposableCups.subtractCups(1);
            Water.subtractWater(200);
            Milk.subtractMilk(100);
            CoffeeBeans.subtractCoffeeBeans(12);
            MachineMoney.addMoney(6);
        }
        chooseOption();
    }

    public static void serviceMachine(){
        String[] inventoryItems = new String[]{"water", "milk", "coffee beans", "disposable cups"};

        for(String option : inventoryItems){
            int amount = InputHelper.getInt("How much " + option + " do you want to add?");
            while(amount < 0){
                amount = InputHelper.getInt("How much " + option + " do you want to add?");
            }
            switch(option){
                case "water":
                    Water.addWater(amount);
                    break;
                case "milk":
                    Milk.addMilk(amount);
                    break;
                case "coffee beans":
                    CoffeeBeans.addCoffeeBeans(amount);
                    break;
                case "disposable cups":
                    DisposableCups.addCups(amount);
                    break;
            }
        }
        chooseOption();
    }

    public static void collectCash(){
        MachineMoney.collectMoney();
        chooseOption();
    }

    public static void displayMachineMenu(){
        String action = chooseOption();

        while(!action.equals("buy")  && !action.equals("fill") &&  !action.equals("take") && !action.equals("remaining") && !action.equals("exit")){
            System.out.println("Wrong action!");
           action = chooseOption();
        }

        switch(action){
            case "buy":
                serviceCoffee();
                break;
            case "fill":
                serviceMachine();
                break;
            case "take":
                collectCash();
                break;
            case "remaining":
                getMachineStatus();
                break;
            case "exit":
                exitProgram();
                break;
            default:
                System.out.println("Choose one of the available options!");
        }
    }

    public static void main(String[] args) {
        displayMachineMenu();
        InputHelper.closeScanner();

    }
}