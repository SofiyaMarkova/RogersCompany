package rogerscompany;

public class TVPlan {

    @Override
    public String toString() {
        if (channels == 0) {
            return "NO PLAN";
        }
        return name + " Plan" + " | " + " Number of Channels: " + channels + " | " + " Price per Month: $" + price;
    }

    private String name;
    private int channels, price;

    public TVPlan(String name, int channels, int price) {
        this.name = name;
        this.channels = channels;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public int getChannels() {
        return channels;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
