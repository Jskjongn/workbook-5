package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SuperPerson {

    // protected properties so they can be accessed by children, stays in the family
    protected String name;
    protected int health;
    protected int experiencePoints;

    // hashmaps for battle log and power up inventory
    protected HashMap<String, Integer> battleLog = new HashMap<>();
    protected HashMap<String, Integer> inventory = new HashMap<>();

    public SuperPerson(String name, int health) {
        this.name = name;
        this.health = health;
        // default xp value, when creating a new super person shouldn't start with any xp
        this.experiencePoints = 0;
    }

    //---------------------------------------------------------------------------------------------------

    // method to return if a SuperPerson is alive
    public boolean isAlive() {

        // if health is above 0 then they are alive and returns true, if not alive returns false
        return this.health > 0;
    }

    // method that allows us to fight another SuperPerson
    public void fight(SuperPerson opponent) {

        // generate random amount of damage
        // returns a number between 0 and 20
        int damageAmount = new Random().nextInt(21);

        // displays the opponent we are fighting against
        System.out.println(this.name + " is fighting " + opponent.name + "!");
        opponent.takeDamage(damageAmount + this.experiencePoints);
    }

    public void takeDamage(int damageAmount) {

        // subtract damage amount from health but don't want to set health below 0
        this.health -= damageAmount;

        // if damage done makes health go below zero, it's just set to zero
        if (this.health < 0) {
            this.health = 0;
        }
    }

    // method for displaying health
    public String getStatus() {

        // returns how much health a SuperPerson has left
        return this.name + " has " + this.health + " health left!";
    }

    //---------------------------------------------------------------------------------------------------

    // update the log entry for our SuperPerson
    public void logHit(SuperPerson opponent) {
        String name = opponent.name;
        int count = battleLog.getOrDefault(name, 0);
        battleLog.put(name, count + 1);
    }

    // print the battle log for a SuperPerson
    public void printBattleLog() {
        System.out.println("Battle log for " + this.name + ":");
        for (HashMap.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    // method to add a power up and its damage to inventory
    public void addPowerUp(String powerUp, int damage) {

        // adds a power up (key value) and its damage (
        inventory.put(powerUp, damage);
    }

    // method to get any power up that's already inside the inventory
    public int getPowerUp(String powerUp) {

        // defaults damage to zero
        int bonusDamage = 0;

        // if there's no power up passed then 0 damage is added
        if(!inventory.containsKey(powerUp)) {
            System.out.println(powerUp + " does not exist, 0 bonus damage dealt!");
            return bonusDamage;
        }

        // gets the damage from power up
        bonusDamage = inventory.get(powerUp);

        // displays what power up was used and how much damage was done
        System.out.println(powerUp + "has been used, " + bonusDamage + " bonus damage dealt!");

        return bonusDamage;
    }

    // method to get any random power up from inventory
    public int getRandomPowerUp() {

        int bonus = 0;
        if (!inventory.isEmpty()) {
            // creates a new array list of items from the keys of the power up inventory
            ArrayList<String> items = new ArrayList<String>(inventory.keySet());

            // gets a random item from new list and assigns it to a new variable
            String randomItem = items.get(new Random().nextInt(items.size()));

            //get the point value for that item from the inventory HashMap
            //bonus would be the int that represents the damage the item will do.
            bonus = inventory.get(randomItem);

            // displays what random power up was used and its damage
            System.out.println(randomItem + " was used dealing " + bonus + " bonus damage!");
        }
        return bonus;
    }
}
