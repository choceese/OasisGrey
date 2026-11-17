import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Animal[] party;
    private Enemy[] enemies;
    private int water;
    private int turnCounter = 1;
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    public Battle(Animal[] party, Enemy[] enemies, int water, Scanner scan) {
        this.party = party;
        this.enemies = enemies;
        this.water = water;
        this.scan = scan;

    }
    public boolean isPartyDefeated() {
        for (Animal a : party) {
            if (a != null) {
                if (!a.isKnockedOut()) {
                return false;
                }
            }
        }
        return true;
            
    } 
    public boolean areEnemiesDefeated() {
        for (Enemy e : enemies) {
            if (e != null) {
                if (!e.isKnockedOut()) {
                return false;
                }
            }
        }
        return true;
            
    } 
    public Animal pickTargetAnimal() {
        int livingCount = 0;
        for (Animal a : party) {
            if (a != null && !a.isKnockedOut()) {
                livingCount++;
            }
        }

        // Nobody left to attack
        if (livingCount == 0) {
            return null;
        }

        // Roll which living animal to hit: 0 means the first living one, 1 the second, and so on
        int chosen = rand.nextInt(livingCount);

        // Pass 2: walk through the living animals until we reach the chosen one
        int seen = 0;
        for (Animal a : party) {
            if (a != null && !a.isKnockedOut()) {
                if (seen == chosen) {
                    return a;
                }
                seen++;
            }
        }
        return null; // never reached, but Java requires a return at the end
    }
    public void chooseAllIntents() {
        for (Enemy e : enemies) {
            if (e != null && !e.isKnockedOut()) {
                e.chooseIntent();
            }
        }
    }
    public int readNumber(int limit) {
        int choice = scan.nextInt();
        while (choice < 1 || choice > limit) {
            System.out.println("Pick an existing number from the options");
            choice = scan.nextInt();
        }
        return choice;
    }
    public Enemy chooseEnemyTarget() {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null && !enemies[i].isKnockedOut()) {
                System.out.println((i + 1) + ") " + enemies[i].getName() + "(" + enemies[i].getHP() + "/" + enemies[i].getMaxHp() + ")");
            }
        }
        while (true) {
            int choice = readNumber(enemies.length);
            
            if (enemies[choice - 1] != null && !enemies[choice - 1].isKnockedOut()) {
                clearScreen();
                return enemies[choice - 1];
            }
        }
        
    }
    public void useBasic(Animal a, Enemy e) { //incomplete. Only able to take damage.
        int damage = a.getBasic();
        e.takeDamage(damage);
    }
    public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    }

    public void showBattleState() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(">>>>>TURN " + turnCounter + " <<<<<");
        System.out.println(" ");
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null && enemies[i].isKnockedOut()) {
                String dead = "(dead)";
                System.out.printf("%-28s", dead);
            }
            if (enemies[i] != null && !enemies[i].isKnockedOut()) {
                String guy = enemies[i].getName() + "(" + enemies[i].getHP() + "/" + enemies[i].getMaxHp() + ")";
                System.out.printf("%-28s", guy);
            }
        }
        System.out.println(" ");
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null && enemies[i].isKnockedOut()) {
                System.out.printf("%-28s", " ");
            }
            if (enemies[i] != null && !enemies[i].isKnockedOut()) {
                Intent intent = enemies[i].getCurrentIntent();
                String declaration = "[Is planning to " + intent.type + "]";
                System.out.printf("%-28s", declaration);
            }
        }
        System.out.println(" ");
        System.out.println("   ");
        System.out.println("=======");
        System.out.println("   ");
        for (int i = 0; i < party.length; i++) {
            if (party[i] != null && !party[i].isKnockedOut()) {
                System.out.println(party[i].getName() + "(" + party[i].getHP() + "/" + party[i].getMaxHp() + ")");
            }
        }
    }
    public void animalTurn(Animal a) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("It's " + a.getName() + "'s turn");
        System.out.println(" ");
        System.out.println("(1)Head Ram: deal 7 damage to an enemy");
        System.out.println("(2)Cliff Charge: deal 21 damage to an enemy with full health");
        int choiceInput = readNumber(2);
        if (choiceInput == 1) {
            useBasic(a, chooseEnemyTarget());
        }
        else {
            System.out.println("Special not available yet.");
        }
    }
    public void playerPhase() {
        for (Animal a : party) {
            if (a != null && !a.isKnockedOut()) {
                animalTurn(a);    
            }
        }
    }
    public void endRound() {
        //reset all animals block/status to 0
        //reset all enemies block/status to 0
        turnCounter++;
    }
        
    
    public void executeIntent(Enemy e) {
        Intent intent = e.getCurrentIntent();

        if (intent.type.equals("ATTACK")) {
            Animal target = pickTargetAnimal();
            if (target != null) {
                target.takeDamage(intent.value);
                System.out.println(e.getName() + " uses " + intent.label
                    + " on " + target.getName() + " for " + intent.value);
            }
        } 
        else if (intent.type.equals("STEAL_WATER")) {
            water = Math.max(0, water - intent.value);
            System.out.println(e.getName() + " uses " + intent.label
                + " and steals " + intent.value + " Water");
        } 
        else if (intent.type.equals("HEAL")) {
            e.heal(intent.value);   // heals itself for now
            System.out.println(e.getName() + " uses " + intent.label);
        } 
        else if (intent.type.equals("CHARGE")) {
            System.out.println(e.getName() + " uses " + intent.label);
        }
        else if (intent.type.equals("BLOCK")) {
            e.gainBlock(intent.value);
            System.out.println(e.getName() + " uses " + intent.label
                + " and gains " + intent.value + " Block");

        } 
        else if (intent.type.equals("MARK")) {
            Animal target = pickTargetAnimal();
            if (target != null) {
                target.mark(intent.value);
                System.out.println(e.getName() + " uses " + intent.label
                    + " on " + target.getName());
            }
        }
    }
    public void enemyPhase() {
        for (Enemy e : enemies) {
            e.resetBlock();
        }
        for (Enemy e : enemies) {
            if (e != null && !e.isKnockedOut()) {
                executeIntent(e);
            }
        }
    }
    public void run() {
        while (!areEnemiesDefeated() && !isPartyDefeated()) { //both either returns true or false
            chooseAllIntents();
            showBattleState();
            playerPhase();
            if (areEnemiesDefeated()) {
                break;
            }
            enemyPhase();
            endRound();
            
        }
        if (isPartyDefeated()) {
            System.out.println(" ");
            System.out.println("Tragic death. Better luck next time.");
            System.out.println("Wanna hear a joke?");
            System.out.println("Home.");
            System.out.println("......");
            System.out.println("You don't get it? Exactly.");
        }
        else {
            System.out.println(" ");
            System.out.println("You win??? YOU WIN!!!!! :) ");
        }
    }
    public Animal[] getParty() {
        return party;
    }
    public Enemy[] getGang() {
        return enemies;
    }
}
