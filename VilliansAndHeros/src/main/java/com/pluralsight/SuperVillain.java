package com.pluralsight;

import java.util.Random;

public class SuperVillain extends SuperPerson{

    public SuperVillain(String name, int health, int villainLevel) {
        super(name, health);

        this.experiencePoints = villainLevel;

        System.out.println(this.name + " has arrived with the villain level of " + this.experiencePoints);
    }

    @Override
    public void fight(SuperPerson opponent) {

        logHit(opponent);

        int damageAmount = new Random().nextInt(16);

        int totalDamage = damageAmount + experiencePoints;

        if (damageAmount == 0) {
            System.out.println("You won't be so lucky next time, " + opponent.name + "!");
        } else {
            System.out.println("You are no match for my evil! " +
                    opponent.name + " was hit for " + totalDamage);
            opponent.takeDamage(totalDamage);
        }
    }
}
