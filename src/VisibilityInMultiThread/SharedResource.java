package VisibilityInMultiThread;

public class SharedResource {
//    private boolean flag = false; // visibility problem
    private volatile boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }
}
