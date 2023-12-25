public class VillaWithBusinessFee extends Villa implements BusinessFee {
    public VillaWithBusinessFee(String code, double length, double width) {
        super(code, length, width);
    }

    @Override
    public double calculateBusinessFee() {
        return getWidth()*getLength() * 1000;
    }
}
