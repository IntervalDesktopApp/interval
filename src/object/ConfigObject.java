package object;

/**
 * Created by Eike on 04.07.2017.
 */
public class ConfigObject {

    private boolean doUpdate = true;
    private boolean multiClock = false;

    public boolean isDoUpdate() {
        return doUpdate;
    }

    public void setDoUpdate(boolean doUpdate) {
        this.doUpdate = doUpdate;
    }

    public boolean isMultiClock() {
        return multiClock;
    }

    public void setMultiClock(boolean multiClock) {
        this.multiClock = multiClock;
    }
}
