public class EmptyLand extends RealEstate {
    public EmptyLand(String code, double length, double width) {
        super(code, length, width);
    }

    @Override
    public double calculateValue() {
        return getLength() * getWidth() * 10000;
    }
}
