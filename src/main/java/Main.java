import Database.Database;
import authentication.Authentication;
import collection.HumanBeingCollection;
import collection.ReaderFromDB;
import commands.CommandController;
import utils.readers.ReaderFromConsole;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Database db = Database.getInstance();
        try{
            Thread readerDB = new Thread(new ReaderFromDB());
            readerDB.start();
            Authentication.setReader(new ReaderFromConsole());
            Authentication.auth();
            ReaderFromConsole reader = new ReaderFromConsole();
            CommandController commandController = new CommandController(reader);
            String request;
            while(!((request = reader.getNewLine()).equals("exit"))){
                commandController.executeCommand(request);
            }
        }
        finally {
            db.closeConnection();
        }

    }
}
