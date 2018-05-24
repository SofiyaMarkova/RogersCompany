package rogerscompany;

public class CellPhonePlan {

    @Override
    public String toString() {
        if (calls == 0) {
            return "NO PLAN";
        }

        return name + " Plan" + " | " + " Number of Calls: " + calls + " | " + " Number of Texts: " + texts + " | " + " GB of Data: " + data + " | " + " Price per Month: $" + price;
    }

    private String name;
    private int calls, texts, data, price;

    public CellPhonePlan(String name, int calls, int texts, int data, int price) {
        this.name = name;
        this.calls = calls;
        this.texts = texts;
        this.data = data;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public int getCalls() {
        return calls;
    }

    public int getTexts() {
        return texts;
    }

    public int getData() {
        return data;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalls(int calls) {
        this.calls = calls;
    }

    public void setTexts(int texts) {
        this.texts = texts;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
