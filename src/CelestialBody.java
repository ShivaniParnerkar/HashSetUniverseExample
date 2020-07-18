public class CelestialBody extends UniverseBody {

    public CelestialBody(String bodyName, double distance)
    {
        super(bodyName, distance, BODYTYPE.PLANET);
    }

    @Override
    public boolean addBody(UniverseBody body) {
        if (body.getKey().getBodyType() == BODYTYPE.MOON) {
            return super.addBody(body);
        } else {
            return false;
        }
    }
}
