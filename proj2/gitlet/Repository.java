package gitlet;

import java.io.File;
import static gitlet.Utils.*;

// TODO: any imports you need here

/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /* TODO: fill in the rest of this class. */

    public static String master;
    public static String HEAD;

    public static void init() {
        //1. make .gitlet  directory first
        if (!GITLET_DIR.exists()) {
            GITLET_DIR.mkdir();
        } else {
            System.out.println("A Gitlet version-control system already exists in the current directory.");
            System.exit(0);
        }
        Commit  c0 = new Commit("initial commit", null);




    }

    public static void commit() {

        //Read from my own computer to get head commit object and staging area

        //clone the HEAD commit
        //Modify its message and timestamp according to user input
        //Use the staging area in order to modify the files tracked by the new commit

        //Write back any new object made or modified objects read earlier
    }
}
