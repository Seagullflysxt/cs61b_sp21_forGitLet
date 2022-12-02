package gitlet;

// TODO: any imports you need here
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date; // TODO: You'll likely use this in this class
import java.util.Map;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TODO
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String message;
    /**The timestamp of this commit*/
    private Date date;
    /*当前commit的parent*/
    private String parent;
    /**用一个set存储当前commit track的file和它的contents*/
    private Map<String, Blob> trackingFilesAndContents;
    /* TODO: fill in the rest of this class. */

    public Commit(String message, String parent) {
        this.message = message;
        this.parent = parent;
        //设置initial commit的timestamp
        if (this.parent == null) {
            String initialTime = "00:00:00 UTC, Thursday, 1 January 1970";
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss 'UTC,' E ',' dd-MM-yyyy");
            try {
                this.date = sdf.parse(initialTime);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            this.date = new Date();
        }
    }

    public String getMessage() {
        return this.message;
    }

    public Date getDate() {
        return this.date;
    }
    public String getParent() {
        return this.parent;
    }

    public void saveCommit() {

    }
}
