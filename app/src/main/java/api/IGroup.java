package api;

/**
 * Created by gaokun on 2017/11/23.
 */
public interface IGroup {
    public void quitGroup(String accout);
    public void setGroupListener(GroupListener listener);
}
