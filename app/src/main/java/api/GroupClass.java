package api;

/**
 * Created by gaokun on 2017/11/23.
 */

public class GroupClass implements IGroup {
    private GroupListener mListener;


    @Override
    public void quitGroup(String accout) {
        if(mListener!=null) {
            mListener.onQuitGrouped(accout, true);
        }
    }

    @Override
    public void setGroupListener(GroupListener listener) {
    this.mListener=listener;
    }
}
