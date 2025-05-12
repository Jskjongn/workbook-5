package com.pluralsight;

import java.util.Random;

// children class extends the SuperPerson class which copies all functionality from parent class
public class SuperHero extends SuperPerson {

    // constructor that calls parent class constructor
    public SuperHero(String name, int health, int heroLevel) {
        super(name, health);

        // sets power level to experience points
        this.experiencePoints = heroLevel;

        System.out.println(this.name + " has arrived with a hero level of " + heroLevel);
    }

    @Override
    public void fight(SuperPerson opponent) {

        logHit(opponent);

        // make hero do random amount of damage to the opponent
        // the damage should be a random number plus the experiencePoints
        // if the base damage (without xp) was 0, don't do any damage and say you missed
        // otherwise deal the damage and say something about you connecting a hit

        // base damage is 10 plus number of experience points
        int damageAmount = new Random().nextInt(11);

        int totalDamage = damageAmount + experiencePoints;

        // if damage done is 0 then doesn't do damage
        if (damageAmount == 0) {
            System.out.println(this.name + " needs more hero practice... :(");
        } else {
            System.out.println("Do you feel that, " + opponent.name + "? It's JUSTICE! " +
                    opponent.name + " was hit for " + totalDamage);
            // if damage is greater than 0 then does damage plus the xp
            opponent.takeDamage(totalDamage);
        }
    }
}
