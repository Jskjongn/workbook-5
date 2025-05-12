package com.pluralsight;

public class SuperApp {

    public static void main(String[] args) throws InterruptedException {

        // creates superhero and super villain
        SuperHero superJack = new SuperHero("Jack", 100, 25);
        SuperVillain villainBob = new SuperVillain("Bob", 100, 20);
        Thread.sleep(2000);

        // displays start message with their starter status
        System.out.println("\nWelcome to the battle of good VS evil!\n");
        System.out.println(villainBob.getStatus());
        System.out.println(superJack.getStatus());
        Thread.sleep(3000);

        // loops while supers are alive
        while (superJack.isAlive() && villainBob.isAlive()) {

            // superhero attack message
            System.out.println("\nOur hero goes in for the attack!\n");
            Thread.sleep(1000);

            // superhero attacks super villain and shows damage dealt and villain health
            superJack.fight(villainBob);
            System.out.println(villainBob.getStatus());
            Thread.sleep(5000);

            // breaks out of loop if super villain is not alive
            if (!villainBob.isAlive()) {
                break;
            }

            // super villain attack message
            System.out.println("\nThe villain is now going for revenge!\n");
            Thread.sleep(1000);

            // super villain attacks superhero and shows damage dealt and superhero health
            villainBob.fight(superJack);
            System.out.println(superJack.getStatus());
            Thread.sleep(5000);
        }

        // displays end message
        System.out.println("\nThe ultimate battle of good VS evil has concluded!\n");
        Thread.sleep(2000);

        // displays on who is alive after fight and who the winner is along with battle log
        if (superJack.isAlive()) {
            System.out.println("Our righteous hero, " + superJack.name + ", is the winner!\n");
            superJack.printBattleLog();
        } else {
            System.out.println("The dastardly villain, " + villainBob.name + ", is the winner!\n");
            villainBob.printBattleLog();
        }
    }
}
