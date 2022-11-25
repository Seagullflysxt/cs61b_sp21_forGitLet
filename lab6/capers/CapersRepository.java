package capers;

//import net.sf.saxon.trans.SymbolicName;

import java.io.File;
import java.io.IOException;

import static capers.Utils.*;

/** A repository for Capers
 * @sxt done
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * done: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = Utils.join(CWD, ".capers"); // TODO Hint: look at the `join`
                                            //      function in Utils
    static final File DOGS_FOLDER = Utils.join(CAPERS_FOLDER, "dogs");
    static final File STORY_FILE = Utils.join(CAPERS_FOLDER, "story.txt");
    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab6 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */

    public static void setupPersistence() throws IOException {
        // done
        if (!CAPERS_FOLDER.exists()) {
            CAPERS_FOLDER.mkdir();
        }
        if (!DOGS_FOLDER.exists()) {
            DOGS_FOLDER.mkdir();
        }
        if (!STORY_FILE.exists()) {
            STORY_FILE.createNewFile();
        }
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        // done
        String oldContents = Utils.readContentsAsString(STORY_FILE);
        if (STORY_FILE.length() == 0) {
            Utils.writeContents(STORY_FILE, text);
        } else {
            Utils.writeContents(STORY_FILE, oldContents + "\n", text);
        }
        String newContents = readContentsAsString(STORY_FILE);
        System.out.println(newContents);
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        // done
        Dog dog = new Dog(name, breed, age);
        dog.saveDog();
        System.out.println(dog.toString());
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        // done
        //File deserialized_dog = Utils.join(dogs_folder,name + ".txt");
        //Dog dog = Utils.readObject(deserialized_dog, Dog.class);
        Dog dog = Dog.fromFile(name);
        dog.haveBirthday();
        dog.saveDog();
    }
}
