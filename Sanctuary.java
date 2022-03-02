/**
 * Name: Jialin Chen
 * Email: jic053@ucsd.edu
 * Sources used: None
 * 
 * The sanctuary wants to keep track of how many of
 *  each species are currently located on its grounds 
 *  using hashmap.
 */
import java.util.HashMap;
import java.util.Set;

/**
 * Container to store all the animal species in the sanctuary.
 */
public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;
    Integer totalAnimals = 0;

    /**
     * Initialize the HashMap with no elements.
     * Initialize the other instance variables accordingly.
     * @param maxAnimals The maximum number of animals that 
     * the sanctuary can support.
     * @param maxSpecies The maximum number of species that 
     * the sanctuary can support.
     */
    public Sanctuary(int maxAnimals, int maxSpecies) {
        if(maxAnimals < 0 || maxSpecies < 0)
            throw new IllegalArgumentException();

        sanctuary = new HashMap<String, Integer>();
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
    }

    /**
     * Return the number of animals at the 
     * sanctuary that are of the given species.
     * @param species the given species
     * @return the number of animals at the sanctuary.
     */
    public int getNum(String species) {
        if(species == null)
            throw new IllegalArgumentException();

        if(!sanctuary.containsKey(species))
            return 0;
            
        return sanctuary.get(species);
    }
    
    /**
     * Return the total number of animals at the sanctuary.
     * @return the total number of animals at the sanctuary.
     */
    public int getTotalAnimals() {
        totalAnimals = 0;
        // add the value of each specie together
        sanctuary.forEach((key, value) -> {
            totalAnimals += value;  
          });
        return totalAnimals;
    }
    
    /**
     * Return the total number of species at the sanctuary.
     * @return the total number of species at the sanctuary.
     */
    public int getTotalSpecies() {
        return sanctuary.size();
    }

    /**
     * rescure a species to the sanctuary
     * @param species add num animals of species to the sanctuary
     * @param num add num animals of species to the sanctuary
     * @return the number of animals that could not be rescued.
     */
    public int rescue(String species, int num) {
        if(species == null)
            throw new IllegalArgumentException();
        if(num <= 0)
            throw new IllegalArgumentException();

        if(sanctuary.size() < maxSpecies && !(sanctuary.containsKey(species))) {
            // if the sanctuary is full, add nothing
            if(getTotalAnimals() >= maxAnimals)
                return num;

            // if the sanctuary can add all the animal
            if(getTotalAnimals() + num <= maxAnimals) {
                sanctuary.put(species, num);  
                return 0;
            }
            
            // otherwise fill the sanctuary
            int rescued = maxAnimals - getTotalAnimals();
            sanctuary.put(species, rescued);
            return num - rescued;
        }
        else if(sanctuary.size() <= maxSpecies && sanctuary.containsKey(species)) {
            if(getTotalAnimals() + num <= maxAnimals) {
                sanctuary.put(species, sanctuary.get(species) + num);
                //System.out.println(sanctuary.get(species));
                return 0;
            }

            int rescued = maxAnimals - getTotalAnimals();
            sanctuary.put(species, sanctuary.get(species) + rescued);
            return num - rescued;
        }
        return num;
    }

    /**
     * Remove num animals of species from the sanctuary.
     * @param species the species to be removed
     * @param num number of species to be removed
     */
    public void release(String species, int num) {
        if(species == null || !sanctuary.containsKey(species))
            throw new IllegalArgumentException();
        if(num <= 0 || num > sanctuary.get(species))
            throw new IllegalArgumentException();

        sanctuary.replace(species, sanctuary.get(species) - num);

        // Remove the species from the sanctuary if 
        // its remaining count reaches 0.
        if(sanctuary.get(species) == 0)
            sanctuary.remove(species);
    }

 ///** 
    public static void main(String[] args) {
        Sanctuary sanct = new Sanctuary(10, 2);
        System.out.println(sanct.rescue("species", 2));
        System.out.println(sanct.getTotalAnimals());

        System.out.println(sanct.rescue("species", 3));
        System.out.println(sanct.getTotalAnimals());

        System.out.println(sanct.rescue("species", 7));
        System.out.println(sanct.getTotalAnimals());

        System.out.println(sanct.rescue("species2", 3));
        System.out.println(sanct.rescue("species", 7));
    }
  //  */
}
