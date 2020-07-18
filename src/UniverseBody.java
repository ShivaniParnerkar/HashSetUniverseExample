import java.util.HashSet;
import java.util.Set;

public abstract class UniverseBody {

    private final double distance;
    private final Set<UniverseBody> satellites;
    private Key key;

    public enum BODYTYPE {
        STAR, PLANET, MOON
    }

    public UniverseBody(String bodyName, double distance, BODYTYPE bodytype) {
        key = new Key(bodyName, bodytype);
        this.distance = distance;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getDistance() {
        return distance;
    }

    public Set<UniverseBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public boolean addBody(UniverseBody body) {
        return this.satellites.add(body);
    }

    public static Key makeKey(String name, BODYTYPE bodytype) {
        return new Key(name, bodytype);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof UniverseBody) {
            UniverseBody theObject = (UniverseBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public int hashCode() {

        return this.key.hashCode() + 8;
    }

    @Override
    public String toString() {
        return this.key.bodyName + ": " + this.key.bodyType + ", " + this.distance;
    }

    public static class Key {
        private final String bodyName;
        private final BODYTYPE bodyType;

        private Key(String bodyName, BODYTYPE bodyType) {
            this.bodyName = bodyName;
            this.bodyType = bodyType;
        }

        public String getBodyName() {
            return bodyName;
        }

        public BODYTYPE getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.bodyName.hashCode() + this.bodyType.hashCode() + 8;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            Key key = (Key) obj;
            if (this.bodyName == key.getBodyName()) {
                return (this.bodyType == key.getBodyType());
            }
            return false;

        }

        @Override
        public String toString() {
            return this.bodyName + ": " + this.bodyType;
        }

    }

}