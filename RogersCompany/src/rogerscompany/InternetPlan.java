package rogerscompany;

public class InternetPlan {

    @Override
    public String toString() {
        if (download == 0) {
            return "NO PLAN";
        }
        return name + " Plan" + " | " + " Number of Downloads (Gbps): " + download + " | " + " Number of Uploads (Gbps): " + upload + " | " + " Price per Month: $" + price;
    }

    private String name;
    private int download, upload, price;

    public InternetPlan(String name, int download, int upload, int price) {
        this.name = name;
        this.download = download;
        this.upload = upload;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public int getDownload() {
        return download;
    }

    public int getUpload() {
        return upload;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public void setUpload(int upload) {
        this.upload = upload;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
