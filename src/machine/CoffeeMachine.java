package machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeMachine {

    private List<String> instructionsList;
    private Ingredients ingredients;
    private InputHelper inputHelper;

    public CoffeeMachine() {
        instructionsList = new ArrayList<>();
        ingredients = new Ingredients();
        inputHelper = new InputHelper();
    }

    public void takeOrder(){
        int waterToAdd = inputHelper.getInt("Write how many ml of water the coffee machine has:");
        int milkToAdd = inputHelper.getInt("Write how many ml of milk the coffee machine has:");
        int coffeeBeansToAdd = inputHelper.getInt("Write how many grams of coffee beans the coffee machine has:");
        int cupsRequested = inputHelper.getInt("Write how many cups of coffee you will need:");

        calculateMaxCupsPossible(waterToAdd, milkToAdd, coffeeBeansToAdd, cupsRequested);
    }

    public void calculateMaxCupsPossible(int water, int milk, int coffeeBeans, int cups){
        ArrayList<Integer> ingredients = new ArrayList<Integer>();
        CoffeeRecipe coffee = new CoffeeRecipe();

        ingredients.add(water / coffee.water());
        ingredients.add(milk / coffee.milk());
        ingredients.add(coffeeBeans / coffee.coffeeBeans());

        int maxCups = Collections.min(ingredients);

        if(cups > maxCups){
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
            return;
        }
        if(cups == maxCups){
            System.out.println("Yes, I can make that amount of coffee");
            return;
        }

        if(cups < maxCups){
            System.out.println("Yes, I can make that amount of coffee");
            System.out.println("(and even " + (maxCups - cups) + " more than that");
            return;
        }

    }



    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.takeOrder();
    }
}