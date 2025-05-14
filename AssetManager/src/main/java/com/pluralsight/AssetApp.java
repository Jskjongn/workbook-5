package com.pluralsight;

import java.util.ArrayList;

public class AssetApp {

    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        // adds two new houses to the assets list
        assets.add(new House("My Home", "2016", 375000, "123 Plae Grownd Stret, Burleson, TX", 2, 2500, 100000));
        assets.add(new House("My Away Home", "2010", 155000, "321 Hilmands Gate, Stavanger, Norway", 3, 1300, 3000));

        // adds two new vehicles to the assets list
        assets.add(new Vehicle("Daily driver", "2023", 27000, "Toyota Tacoma", 2016, 68800));
        assets.add(new Vehicle("Weekend driver", "2025", 845000, "Porsche 918 Spyder", 2015, 2850));

        for (Asset asset : assets) {
            if (asset instanceof House) {
                House house = (House) asset;
                System.out.printf("""
                        ------------------------------------------
                        Description: %s
                        Date Acquired: %s
                        Value: $%.2f
                        Address: %s
                        ------------------------------------------\n
                        """, house.getDescription(), house.getDateAcquired(), house.getValue(), house.getAddress());
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.printf("""
                        ------------------------------------------
                        Description: %s
                        Date Acquired: %s
                        Value: $%.2f
                        Make and Model: %s
                        ------------------------------------------\n
                        """, vehicle.getDescription(), vehicle.getDateAcquired(), vehicle.getValue(), vehicle.getMakeModel());
            }
        }
    }
}
