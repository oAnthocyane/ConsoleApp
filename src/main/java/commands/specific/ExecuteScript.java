package commands.specific;

import commands.Command;
import commands.CommandController;
import utils.readers.NameReader;
import utils.readers.Reader;
import utils.readers.ReaderFromFile;
import utils.readers.ReaderManager;
import validators.commands.ArgumentValidator;
import validators.commands.RecursionValidator;
import validators.file.FileValidatorToRead;

import java.util.ArrayList;
import java.util.List;

import static colors.Colors.*;

/**
 * The type Execute script.
 */
public class ExecuteScript implements Command {


    @Override
    public void execute(String FILE_PATH){
        ArgumentValidator argumentValidator = new ArgumentValidator(FILE_PATH);
        if(argumentValidator.isValid()){
            FileValidatorToRead fileValidatorToRead = new FileValidatorToRead(FILE_PATH);
            if(fileValidatorToRead.isValid()) {
                RecursionValidator recursionValidator = new RecursionValidator(FILE_PATH);
                if(recursionValidator.isValid()) {
                    ReaderManager reader = new ReaderManager(new ReaderFromFile(FILE_PATH), NameReader.READERFILE);
                    CommandController commandController = new CommandController(reader);
                    ExecuteScriptLogger.addFile(FILE_PATH);
                    while (reader.getNameReader() != NameReader.READERCONSOLE) {
                        String request = reader.getNewLine();
                        commandController.executeCommand(request);
                    }
                    ExecuteScriptLogger.delete(FILE_PATH);
                }

            }

        }
    }

    @Override
    public String description(){
        return BLUE + "execute_script " + PURPLE + "file_name" + RESET + " : считать и исполнить скрипт из указанного файла. В скрипте содержатся" +
                " команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
