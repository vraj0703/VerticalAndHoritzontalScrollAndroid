package raj.io.verticalandhoritzontalscrollandroid.model;

import java.util.List;

/**
 * Created by vraj0 on 18-May-17.
 */

public class VerticalScrollItemModel {
    String title;
    List<HorizontalScrollItemModel> list;

    public VerticalScrollItemModel(String title, List<HorizontalScrollItemModel> list) {
        this.title = title;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HorizontalScrollItemModel> getList() {
        return list;
    }

    public void setList(List<HorizontalScrollItemModel> list) {
        this.list = list;
    }
}
