import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Subdivision {
    private ArrayList<House> houses = new ArrayList<>();

    // Add a new House object to the subdivision
    public boolean add(House h) {
        return houses.add(h);
    }

    // Get the house object at the specified index
    public House get(int index) {
        return houses.get(index);
    }

    // Get the number of houses in the subdivision
    public int size() {
        return houses.size();
    }

    // Find the first house in the subdivision with the specified style
    public House find(String style) {
        for (House h : houses) {
            if (h.getStyle().equals(style)) {
                return h;
            }
        }
        return null;
    }

    // Get a list of all the houses in the subdivision
    public ArrayList<House> list() {
        return new ArrayList<>(houses);
    }

    // Sort the houses in the subdivision by style
    public void sortByStyle() {
        houses.sort((h1, h2) -> h1.getStyle().compareTo(h2.getStyle()));
    }

    // Sort the houses in the subdivision by number of bedrooms
    public void sortByBedrooms() {
        houses.sort((h1, h2) -> Integer.compare(h1.getBedrooms(), h2.getBedrooms()));
    }

    // Sort the houses in the subdivision by total area
    public void sortByArea() {
        ArrayList<House> sortedHouses = new ArrayList<>(houses);
        selectionSortByArea(sortedHouses);
    }

    // Sort the houses in the subdivision by plot size
    public void sortByPlot() {
        ArrayList<House> sortedHouses = new ArrayList<>(houses);
        selectionSortByArea(sortedHouses);
    }

    // Return a string representation of the subdivision
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subdivision:\n");
        for (House h : houses) {
            sb.append(h.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    // Get a list of houses whose total area is within the specified range
    public ArrayList<House> listByArea(double floor, double ceiling) {
        ArrayList<House> selectedHouses = new ArrayList<>();
        for (House h : houses) {
            if (h.getTotalArea() >= floor && h.getTotalArea() <= ceiling) {
                selectedHouses.add(h);
            }
        }
        return selectedHouses;
    }

    // Get a list of houses whose plot size is within the specified range
    public ArrayList<House> listByPlot(double floor, double ceiling) {
        ArrayList<House> selectedHouses = new ArrayList<>();
        for (House h : houses) {
            if (h.getPlot() >= floor && h.getPlot() <= ceiling) {
                selectedHouses.add(h);
            }
        }
        return selectedHouses;
    }

    // Selection sort the given list of houses by total area
    private void selectionSortByArea(ArrayList<House> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareArea(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                House temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    // Selection sort the given list of houses by plot size

    public boolean toDisk() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("subdivision.txt"));
            for (House h : houses) {
                writer.write(h.getStyle() + "," + h.getLivingRoomArea() + "," + h.getFamilyRoomArea() + ","
                        + h.getBedrooms() + "," + h.getPlot() + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    // write the current contents of the subdivision to a file called
    // subdivision.txt. The disk file will be comma delimated. Sample
    // subdivision.txt included.

    public boolean fromDisk() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("subdivision.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                House h = new House(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
                        Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4]));
                houses.add(h);
            }
            reader.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    // read the contents of the subdivision from a file called subdivision.txt. The
    // disk file will be comma delimated. Sample subdivision.txt included.

    public void remove(int position) {
        // one line - use the arrayList remove method
        try {
            houses.remove(position);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }

    }

    public void update(int position, House houseToUpdate) {

        // line 1 - remove the house at this position
        try {
            houses.remove(position);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }

        // line 2 - add the house at this position (use the arrayList add method (two
        // parameters.
        try {
            houses.add(position, houseToUpdate);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        }

    }

    public void addHouse(House houseToAdd) {
    }

}
