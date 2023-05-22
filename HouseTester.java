public class HouseTester {
    public static void main(String[] args) {
        // creates two House objects using the constructors
        House house1 = new House(null, 0, 0, 0, 0);
        House house2 = new House("Colonial", 800.0, 600.0, 4, 1.2);

        // sets values for the instance variables using setters
        house1.setBedrooms(3);
        house1.setFamilyRoomArea(700.0);
        house1.setLivingRoomArea(500.0);
        house1.setPlot(0.7);
        house1.setStyle("Ranch");

        // prints out the values of the instance variables using getters
        System.out.println("House 1 style: " + house1.getStyle());
        System.out.println("House 1 bedrooms: " + house1.getBedrooms());
        System.out.println("House 1 family room area: " + house1.getFamilyRoomArea());
        System.out.println("House 1 living room area: " + house1.getLivingRoomArea());
        System.out.println("House 1 plot: " + house1.getPlot());
        System.out.println("House 1 total area: " + house1.getTotalArea());

        // prints out house 1 and house 2 using toString method
        System.out.println(house1.toString());
        System.out.println(house2.toString());

        // test compareArea method
        if (house1.compareArea(house2) < 0) {
            System.out.println("House 1 is smaller than House 2");
        } else if (house1.compareArea(house2) > 0) {
            System.out.println("House 1 is larger than House 2");
        } else {
            System.out.println("House 1 is the same size as House 2");
        }
    }
}