public abstract class RealEstate implements PropertyValue {
    private String code;
    private double length;
    private double width;

    public RealEstate(String code, double length, double width) {
        this.code = code;
        this.length = length;
        this.width = width;
    }

    public String getCode() {
        return code;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}
