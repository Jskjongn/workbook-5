package com.pluralsight;

public class House extends Asset {

    // properties of a house
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    // constructor to create a new house
    public House(String description, String dateAcquired, double originalCost, String address,
                 int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    @Override
    // gets the value of the house depending on condition and square feet
    public double getValue() {

        double squareFootPrice = switch (condition) {
            case 1 ->
                // excellent
                    180.00;
            case 2 ->
                // good
                    130.00;
            case 3 ->
                // fair
                    90.00;
            case 4 ->
                // poor
                    80.00;
            default -> 0.0;

            // depending on what the condition is, cost of square foot changes
        };

        // multiples the cost of square foot times how many square feet
        // then adds 25 cents per square foot of lot size
        return (squareFoot * squareFootPrice) + (lotSize * 0.25);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
