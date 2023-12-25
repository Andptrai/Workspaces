public class ResidentialHouse extends RealEstate {
    private int numberOfFloors;

    public ResidentialHouse(String code, double length, double width, int numberOfFloors) {
        super(code, length, width);
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public double calculateValue() {
        return getLength() * getWidth() * 10000 + numberOfFloors * 100000;
    }
}
