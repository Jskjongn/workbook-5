package com.pluralsight;

import java.util.ArrayList;
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
    // allows superhero to fight an opponent
    public void fight(SuperPerson opponent) {

        // base damage is 10 plus number of experience points
        int damageAmount = new Random().nextInt(11);

        // calls random item method to get bonus damage
        int bonus = getRandomPowerUp();

        // adds the random damage amount plus the experience points set when creating a hero plus the bonus from a random item
        int totalDamage = damageAmount + experiencePoints + bonus;

        // if damage done is 0 then doesn't do damage
        if (damageAmount == 0) {
            System.out.println(this.name + " needs more hero practice... :(");
        } else {
            System.out.println("Do you feel that, " + opponent.name + "? It's JUSTICE! " +
                    opponent.name + " was hit for " + totalDamage);
            // if damage is greater than 0 then does damage plus the xp
            opponent.takeDamage(totalDamage);

            // adds each hit to the log
            logHit(opponent);
        }
    }
}
