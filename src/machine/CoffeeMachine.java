package machine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private List<String> instructionsList;
    private Ingredients ingredients;
    private InputHelper inputHelper;

    public CoffeeMachine() {
        instructionsList = new ArrayList<>();
        ingredients = new Ingredients();
        inputHelper = new InputHelper();
        
        instructionsList.add("Starting to make a coffee");
        instructionsList.add("Grinding coffee beans");
        instructionsList.add("Boiling water");
        instructionsList.add("mixing boiled water with crushed coffee beans");
        instructionsList.add("Pouring coffee into the cup");
        instructionsList.add("Pouring some milk into the cup");
        instructionsList.add("Coffee is ready!");
    }

    public void readInstructions(){
        for(String instruction: instructionsList){
            System.out.println(instruction);
        }
    }

    public void getCupIngredients(){
        int cups = inputHelper.getInt("Write how many cups of coffee you will need:");

        ingredients.calculateIngredients(cups);
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.getCupIngredients();
    }
}