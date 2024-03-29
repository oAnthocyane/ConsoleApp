package commands.specific;

import java.util.List;

/**
 * The type Execute script logger.
 */
public class ExecuteScriptLogger {

    private static List<String> historyFiles;

    /**
     * Add file.
     *
     * @param file the file
     */
    public static void addFile(String file){
        historyFiles.add(file);
    }

    /**
     * Delete.
     *
     * @param file the file
     */
    public static void delete(String file){
        historyFiles.remove(file);
    }

    /**
     * Contains boolean.
     *
     * @param file the file
     * @return the boolean
     */
    public static boolean contains(String file){
        return historyFiles.contains(file);
    }
}
