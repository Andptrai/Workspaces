public class Villa extends RealEstate {
    public Villa(String code, double length, double width) {
        super(code, length, width);
    }

    @Override
    public double calculateValue() {
        return getLength() * getWidth() * 400000;
    }
}
