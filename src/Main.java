import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private final static Map<UniverseBody.Key, UniverseBody> solarSystem = new HashMap<>();
    private final static Set<UniverseBody> planets = new HashSet<>();
    private final static Set<UniverseBody> creator = new HashSet<>();

    public static void main(String[] args) {

        // Added a Dummy Owner
        UniverseBody shivani = new CelestialBody("Shivani", 45);
        creator.add(shivani);

        // Adding Values : Usually stored in database
        UniverseBody temp = new CelestialBody("Earth", 30);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        UniverseBody tempMoon = new NaturalSatellite("Moon", 34);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addBody(tempMoon);

        temp = new CelestialBody("Mars", 46);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new NaturalSatellite("Phobos", 48);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addBody(tempMoon);

        tempMoon = new NaturalSatellite("Deimos", 49);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addBody(tempMoon);

        temp= new Star("alpha", 98);
        solarSystem.put(temp.getKey(), temp);

        // Print all Planets
        System.out.println("All Planets:");
        for (UniverseBody planet : planets) {
            System.out.println("\t" + planet);
            // System.out.println("\t" + planet.getKey());
        }

        // Print all Satellites : Way 1
        System.out.println("-------------------");
        System.out.println("All Satellites : Way 1");
        for (UniverseBody planet : planets) {
            Set<UniverseBody> satellites = planet.getSatellites();
            for (UniverseBody satellite : satellites) {
                System.out.println("\t" + satellite);
            }
        }

        // Print all Satellites : Way 2
        Set<UniverseBody> satellites = new HashSet<>();
        for (UniverseBody planet : planets) {
            satellites.addAll(planet.getSatellites());
        }

        System.out.println("-------------------");
        System.out.println("All Satellites : Way 2");
        for (UniverseBody satellite : satellites) {
            System.out.println("\t" + satellite);
        }

        // Print Satellites of Mars
        UniverseBody mars = solarSystem.get(UniverseBody.makeKey("Mars", UniverseBody.BODYTYPE.PLANET));
        System.out.println("-------------------");
        System.out.println("Satellites of " + mars.getKey().getBodyName() + ":");
        for (UniverseBody marsSatellite : mars.getSatellites()) {
            System.out.println("\t" + marsSatellite);
        }

        // Print Satellites of Earth
        UniverseBody earth = solarSystem.get(UniverseBody.makeKey("Earth", UniverseBody.BODYTYPE.PLANET));
        System.out.println("-------------------");
        System.out.println("Satellites of " + earth.getKey().getBodyName() + ":");
        for (UniverseBody earthSatellite : earth.getSatellites()) {
            System.out.println("\t" + earthSatellite);
        }

        // This Object is not added as .equals and hashcode are implemented
        temp = new CelestialBody("Mars", 46);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        Set<UniverseBody> satellitess = new HashSet<>();
        for (UniverseBody planet : planets) {
            satellitess.addAll(planet.getSatellites());
        }

        System.out.println();
        System.out.println("The solar system contains:");
        System.out.println("==========================");
        for (UniverseBody body : solarSystem.values()) {
            System.out.println("\t" + body);
        }

        // ME
        System.out.println("-------------------");
        UniverseBody myName = creator.stream().findFirst().get();
        System.out.println("Prepared by: " + myName.getKey().getBodyName());

    }

}
