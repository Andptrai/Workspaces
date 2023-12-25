public class Hotel extends RealEstate {
    private int starRating;

    public Hotel(String code, double length, double width, int starRating) {
        super(code, length, width);
        this.starRating = starRating;
    }

    @Override
    public double calculateValue() {
        return 100000 + starRating * 50000;
    }
}
