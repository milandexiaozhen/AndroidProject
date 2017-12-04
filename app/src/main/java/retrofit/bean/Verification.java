package retrofit.bean;


import java.util.List;

public class Verification {
    Result result;
    List<GoodList> data;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<GoodList> getData() {
        return data;
    }

    public void setData(List<GoodList> data) {
        this.data = data;
    }
}
