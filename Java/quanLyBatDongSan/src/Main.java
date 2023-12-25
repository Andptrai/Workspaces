public class Main {
    public static void main(String[] args) {
        
        RealEstate estate1 = new EmptyLand("E01", 20, 30);
        RealEstate estate2 = new ResidentialHouse("H01", 30, 20, 5);
        RealEstate estate3 = new Hotel("S01", 30, 50, 5);
        RealEstate estate4 = new Villa("V01", 30, 50);
        RealEstate estate5 = new VillaWithBusinessFee("V02", 20, 30);
        RealEstate estate6 = new HotelWithBusinessFee("S02", 25, 40, 3);

        
        System.out.println("Value of estate1: " + estate1.calculateValue());
        System.out.println("Value of estate2: " + estate2.calculateValue());
        System.out.println("Value of estate3: " + estate3.calculateValue());
        System.out.println("Value of estate4: " + estate4.calculateValue());
        System.out.println("Value of estate5: " + estate5.calculateValue() + ", Business fee: " + ((BusinessFee) estate5).calculateBusinessFee());
        System.out.println("Value of estate6: " + estate6.calculateValue() + ", Business fee: " + ((BusinessFee) estate6).calculateBusinessFee());
    }
}
