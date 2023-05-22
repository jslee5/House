public class House {
    private int bedrooms;
    private double familyRoomArea;
    private double livingRoomArea;
    private String style;
    private double plotSize;

    // No-argument constructor
    public House(String style2, double totalArea, double plotSize2, int bedrooms2, double familyRoomArea2,
            double livingRoomArea2) {
        this.style = "";
        this.bedrooms = 0;
        this.familyRoomArea = 0.0;
        this.livingRoomArea = 0.0;
        this.plotSize = 0.0;
    }

    // Constructor with parameters
    public House(String style, double familyRoomArea, double livingRoomArea, int bedrooms, double plotSize) {
        this.style = style;
        this.bedrooms = bedrooms;
        this.familyRoomArea = familyRoomArea;
        this.livingRoomArea = livingRoomArea;
        this.plotSize = plotSize;
    }

    // Getters
    public int getBedrooms() {
        return this.bedrooms;
    }

    public double getFamilyRoomArea() {
        return this.familyRoomArea;
    }

    public double getLivingRoomArea() {
        return this.livingRoomArea;
    }

    public String getStyle() {
        return this.style;
    }

    public double getPlot() {
        return this.plotSize;
    }

    public double getTotalArea() {
        return this.livingRoomArea + this.familyRoomArea + (this.bedrooms * 300.0);
    }

    // Setters
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setFamilyRoomArea(double familyRoomArea) {
        this.familyRoomArea = familyRoomArea;
    }

    public void setLivingRoomArea(double livingRoomArea) {
        this.livingRoomArea = livingRoomArea;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setPlot(double plotSize) {
        this.plotSize = plotSize;
    }

    // Compare area with another house
    public int compareArea(House otherHouse) {
        double area1 = this.getTotalArea();
        double area2 = otherHouse.getTotalArea();

        if (area1 < area2) {
            return -1;
        } else if (area1 > area2) {
            return 1;
        } else {
            return 0;
        }
    }

    // toString method
    public String toString() {
        return "House style = " + this.style + ", bedrooms = " + this.bedrooms + ", family room area = " +
                this.familyRoomArea + ", living room area = " + this.livingRoomArea + ", plot = " +
                this.plotSize + ", square feet = " + this.getTotalArea();
    }
}