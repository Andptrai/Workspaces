public class HotelWithBusinessFee extends Hotel implements BusinessFee {
    public HotelWithBusinessFee(String code, double length, double width, int starRating) {
        super(code, length, width, starRating);
    }

    @Override
    public double calculateBusinessFee() {
        return getWidth() * 5000;
    }
}
