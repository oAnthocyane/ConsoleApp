package utils.readers;

import java.util.Scanner;

/**
 * The type Reader from console.
 */
public class ReaderFromConsole extends Reader {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getNewLine(){
        lastLine = scanner.nextLine();
        return lastLine;
    }

}
