package capers;

import java.io.File;
import static capers.Utils.*;

/** A repository for Capers 
 * @author Shi Xiangting
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = Utils.join(CWD, ".capers"); // TODO Hint: look at the `join`
                                            //      function in Utils

    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab6 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        // TODO
        CAPERS_FOLDER.mkdir();
        Dog.DOG_FOLDER.mkdir();

       /* File f = new File(CAPERS_FOLDER, "story.txt");
        f.createNewFile();*/

    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        // TODO
        File f = new File(CAPERS_FOLDER, "story.txt");
        String newText;
        if (!f.exists()) {
            newText = text;
        } else {
            String oldText = Utils.readContentsAsString(f);
            newText = oldText + "\n" + text;
        }
        Utils.writeContents(f, newText);
        System.out.println(Utils.readContentsAsString(f));
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        // TODO
        File f = new File(Dog.DOG_FOLDER, name + ".txt");
        if (!f.exists()) {
            Dog newDog = new Dog(name, breed, age);
            newDog.saveDog();
            System.out.println(newDog.toString());
        }
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        // TODO
        File f = new File(Dog.DOG_FOLDER, name + ".txt");
        if(f.exists()) {
            Dog d = Dog.fromFile(name);
            d.haveBirthday();
            d.saveDog();
        }
    }
}
