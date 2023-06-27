package collection;

import Database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;


/**
 * The type Human being collection.
 */
public class HumanBeingCollection {

    private static final Map<Long, HumanBeing> humanBeingCollection;
    private static final Date dateOfInitialization;
    private static Date dateOfLastChange;

    static {
        dateOfInitialization = new Date();
        dateOfLastChange = new Date();
        humanBeingCollection = new HashMap<>();
    }

    /**
     * Read from database.
     */
    public static void readFromDatabase(){
        Database db = Database.getInstance();
        ResultSet humanBeingObject = db.getHumanBeings();
        try {
            while(humanBeingObject.next()){
                Long id = humanBeingObject.getLong(1);
                String name = humanBeingObject.getString(2);
                float x = humanBeingObject.getFloat(3);
                Integer y = humanBeingObject.getInt(4);
                LocalDate creationDate = humanBeingObject.getDate(5).toLocalDate();
                boolean realhero = humanBeingObject.getBoolean(6);
                boolean hastoothpick = humanBeingObject.getBoolean(7);
                Integer impactSpeed = humanBeingObject.getInt(8);
                WeaponType weaponType = WeaponType.getWeaponType(humanBeingObject.getString(9));
                Mood mood = Mood.getMood(humanBeingObject.getString(10));
                Car car = new Car(humanBeingObject.getBoolean(11));
                String userLogin = humanBeingObject.getString(12);
                add(new HumanBeing(id, name, new Coordinates(x, y), creationDate, realhero, hastoothpick, impactSpeed,
                        weaponType, mood, car, userLogin));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Add.
     *
     * @param human the human
     */
    public static void add(HumanBeing human){
        dateOfLastChange = new Date();
        humanBeingCollection.put(human.getId(), human);
    }

    /**
     * Clear.
     */
    public static void clear(){
        dateOfLastChange = new Date();
        humanBeingCollection.clear();
    }

    /**
     * Remove.
     *
     * @param id the id
     */
    public static void remove(Long id){
        dateOfLastChange = new Date();
        humanBeingCollection.remove(id);
    }

    /**
     * Get human human being.
     *
     * @param id the id
     * @return the human being
     */
    public static HumanBeing getHuman(Long id){
        return humanBeingCollection.get(id);
    }

    /**
     * Has element boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean hasElement(Long id) {return humanBeingCollection.get(id) != null;}

    /**
     * Get count human being collection long.
     *
     * @return the long
     */
    public static long getCountHumanBeingCollection(){ return humanBeingCollection.size(); }

    /**
     * Get entry set set.
     *
     * @return the set
     */
    public static Set<Map.Entry<Long, HumanBeing>> getEntrySet(){
        return humanBeingCollection.entrySet();
    }

    /**
     * Get human beings collection.
     *
     * @return the collection
     */
    public static Collection<HumanBeing> getHumanBeings(){
        return humanBeingCollection.values();
    }

    /**
     * Gets date of last change.
     *
     * @return the date of last change
     */
    public static Date getDateOfLastChange() {
        return dateOfLastChange;
    }

    /**
     * Gets human being collection.
     *
     * @return the human being collection
     */
    public static Map<Long, HumanBeing> getHumanBeingCollection() {
        return humanBeingCollection;
    }

    /**
     * Gets date of initialization.
     *
     * @return the date of initialization
     */
    public static Date getDateOfInitialization() {
        return dateOfInitialization;
    }
}
