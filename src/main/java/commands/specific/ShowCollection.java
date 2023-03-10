package commands.specific;

import collection.HumanBeing;
import collection.HumanBeingCollection;
import commands.Command;

import java.util.Map;
import java.util.UUID;
import static colors.Colors.*;

public class ShowCollection implements Command {

    @Override
    public void execute(String ignore){
        Map<UUID, HumanBeing> humanBeingCollection = HumanBeingCollection.getHumanBeingCollection();
        for(HumanBeing human : humanBeingCollection.values()){
            System.out.println(human);
        }
    }

    @Override
    public String description(){
        return BLUE + "show" + RESET + " : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
