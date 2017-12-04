package retrofit.bean;

import java.util.List;

/**
 * Created by vtg on 2017/5/15.
 */
public class Goods {
    public List<Category> CategoryNo1;
    public List<CategoryOhter>CategoryNo2;

    public List<Category> getCategoryNo1() {
        return CategoryNo1;
    }

    public void setCategoryNo1(List<Category> categoryNo1) {
        CategoryNo1 = categoryNo1;
    }

    public List<CategoryOhter> getCategoryNo2() {
        return CategoryNo2;
    }

    public void setCategoryNo2(List<CategoryOhter> categoryNo2) {
        CategoryNo2 = categoryNo2;
    }
}
