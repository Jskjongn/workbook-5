package com.pluralsight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SuperPerson {

    // protected properties so they can be accessed by children, stays in the family
    protected String name;
    protected int health;
    protected int experiencePoints;
    private Map<String, Integer> battleLog = new HashMap<>();

    public SuperPerson(String name, int health) {
        this.name = name;
        this.health = health;
        // default xp value, when creating a new super person shouldn't start with any xp
        this.experiencePoints = 0;
    }

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

    // update the log entry for our SuperPerson
    public void logHit(SuperPerson opponent) {
        String name = opponent.name;
        int count = battleLog.getOrDefault(name, 0);
        battleLog.put(name, count + 1);
    }

    // print the battle log for a SuperPerson
    public void printBattleLog() {
        System.out.println("Battle log for " + name + ":");
        for (Map.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }
}
