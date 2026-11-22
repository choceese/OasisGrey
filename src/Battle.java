import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Animal[] party;
    private Enemy[] enemies;
    private Water mizu;
    private int water;
    private int turnCounter = 1;
    public static final String CYAN= "\u001B[38;5;117m";
    public static final String RESET = "\u001B[0m";
    public static final String GOLD = "\u001B[38;5;222m";
    public static final String CORAL = "\u001B[38;5;210m";
    public static final String GREY = "\u001B[38;5;103m";
    public static final String LIGHTGREY = "\u001B[38;5;37m";
    public static final String ORANGE= "\u001B[38;5;223m";
    public static final String PURPLE = "\u001B[38;5;177m";
    public static final String PINK = "\u001B[38;5;218m";

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
     //for a While loop to keep looping until one of the IF conditions inside is "handled"

    public Battle(Animal[] party, Enemy[] enemies, Water mizu, Scanner scan) {
        this.party = party;
        this.enemies = enemies;
        this.mizu = mizu;
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
        System.out.println(" ");
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null && !enemies[i].isKnockedOut()) {
                System.out.println((i + 1) + ") " + GREY+enemies[i].getName()+RESET + PURPLE+" (" + enemies[i].getHP() + "/" + enemies[i].getMaxHp() + ")"+RESET);
            }
        }
        System.out.println("Choose target (number).");
        while (true) {
            int choice = readNumber(enemies.length);
            
            if (enemies[choice - 1] != null && !enemies[choice - 1].isKnockedOut()) {
                clearScreen();
                return enemies[choice - 1];
            }
        }
        
    }
    public Animal chooseAllyTarget() {
        System.out.println(" ");
        for (int i = 0; i < party.length; i++) {
            if (party[i] != null && !party[i].isKnockedOut()) {
                System.out.println((i + 1) + ") " + ORANGE+party[i].getLabel()+RESET + CORAL+" (" + party[i].getHP() + "/" + party[i].getMaxHp() + ")"+RESET);
            }
        }
        while (true) {
        System.out.println("Choose target (number).");
        
            int choice = readNumber(party.length);
            
            if (party[choice - 1] != null && !party[choice - 1].isKnockedOut()) {
                clearScreen();
                return party[choice - 1];
            }
        }
        
    }
    public record animalAndEnemy(Animal a, Enemy e) {}
    public animalAndEnemy chooseEitherTarget() {
        System.out.println(" ");
        int i = 0;
        int j = 0;
        for (Animal a : party) {
            if (a != null && !a.isKnockedOut()) {
                System.out.println((i + 1) + ") " + ORANGE+a.getName()+RESET + CORAL+" (" + a.getHP() + "/" + a.getMaxHp() + ")"+RESET);
                i++;
            }
        }
        int animalNumbers = i;
        for (Enemy e : enemies) {
            if (e != null && !e.isKnockedOut()) {
                System.out.println((i + 1) + ") " + GREY+e.getName()+RESET + PURPLE+" (" + e.getHP() + "/" + e.getMaxHp() + ")"+RESET);
                i++;
                j++;
            }
        }
        int enemyNumbers = j;
        while (true) {
            System.out.println("Choose target (number).");
            int choice = readNumber(animalNumbers + enemyNumbers);
            if (choice > 0 && choice <= animalNumbers) {
                return new animalAndEnemy(party[choice - 1], null);
            }
            else if (choice <= (animalNumbers + enemyNumbers)) {
                return new animalAndEnemy(null, enemies[choice - (animalNumbers) - 1]);
            }
        }
    }
    public void ourChoicesPrint(Animal a) {
        if (a.getLabel().equals("sheep")) {
            System.out.println(" ");
            System.out.println("(1) Head Ram: deal 7 damage to an enemy.");
            System.out.println("(2) Cliff Charge: deal 21 damage to an enemy with full health");
        }
        else if (a.getLabel().equals("owl")) {
            System.out.println(" ");
            System.out.println("(1) Warning Hoot: heal 4 health OR do 4 damage.");
            System.out.println("(2) Burrow Shelter: heal 20 HP to an ally with less than half HP");
        }
        else if (a.getLabel().equals("lizard")) {
            System.out.println(" ");
            System.out.println("(1) Sand Spray: deal 3 damage to ALL enemies.");
            System.out.println("(2) Ambush: do 15 damage to an enemy who is NOT attacking.");
        }
    }
    public boolean everythingAboutBasic(Animal a) { //incomplete. Only able to take damage.
        int value = a.getBasic();
        if (a.getLabel().equals("sheep")) {
            Enemy e = chooseEnemyTarget();
            e.takeDamage(value);
        }
        else if (a.getLabel().equals("owl")) {
            animalAndEnemy target = chooseEitherTarget();
            if (target.a == null) {
                target.e.takeDamage(value);
            }
            else {
                target.a.heal(value);
            }
        }
        else if (a.getLabel().equals("lizard")) {
            for (Enemy e : enemies) {
                e.takeDamage(value);
            }
        }
        else if (a.getLabel().equals("tortoise")) {
            animalAndEnemy target = chooseEitherTarget();
            if (target.a == null) {
                target.e.takeDamage(value);
            }
            else {
                target.a.gainBlock(value);
            }
        }
        return true;
    }
    public boolean everythingAboutSpecial(Animal a) {
        int value = a.getSpecial();
        
            if (a.getLabel().equals("sheep")) {
                Enemy e = chooseEnemyTarget();
                if (e.getHP() == e.getMaxHp() && (mizu.getWater() >= 3)) {
                    e.takeDamage(value);
                    mizu.takeEvaporate(3);
                    return true;
                }
            }
            else if (a.getLabel().equals("owl")) {
                Animal healTarget = chooseAllyTarget();
                if (healTarget.getHP() <= healTarget.getMaxHp() / 2 && (mizu.getWater() >= 3)) {
                    healTarget.heal(value);
                    mizu.takeEvaporate(3);
                    return true;
                }
            }
            else if (a.getLabel().equals("pupfish")) {
                int emyCounter = 0;
                for (Enemy emy : enemies) {
                    if (emy != null && !emy.isKnockedOut()) {
                        emyCounter++;
                    }
                }
                if (emyCounter >= 3 && (mizu.getWater() >= 3)) {
                    for (Enemy emy : enemies) {
                        if (emy != null && !emy.isKnockedOut()) {
                            emy.takeDamage(value);
                            mizu.takeEvaporate(3);
                        }
                    }
                    return true;
                }
            }
            else if (a.getLabel().equals("lizard")) {
                Enemy e = chooseEnemyTarget();
                String actionLabel = e.getCurrentIntent().type;
                if (!actionLabel.equals("ATTACK") && ((mizu.getWater() >= 2))) {
                    e.takeDamage(value);
                    mizu.takeEvaporate(2);
                    return true;
                }
            }
            return false;
        }
        
    
    public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    }

    public void showBattleState() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(">>>>> TURN " + CYAN+ turnCounter +RESET + " <<<<<");
        System.out.println(" ");
        int barLength = 0;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null && enemies[i].isKnockedOut()) {
                String dead = "(dead)";
                System.out.printf("%-28s", dead);
                barLength += dead.length() + (28-dead.length());
            }
            if (enemies[i] != null && !enemies[i].isKnockedOut()) {
                String enemyName = enemies[i].getName();
                String enemyHP = " (" + enemies[i].getHP() + "/" + enemies[i].getMaxHp() + ")";
                int statsPad = 28 - (enemyName.length() + enemyHP.length());
                System.out.print(GREY + enemyName + RESET + PURPLE + enemyHP + RESET + " ".repeat(Math.max(0, statsPad)));
                barLength += enemyName.length() + enemyHP.length() + statsPad;
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
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null && !enemies[i].isKnockedOut()) {
                String enemyBlock = (enemies[i].getBlock() > 0) ? "[Block: " + enemies[i].getBlock() + "] " : "";
                int blockPad = 28 - (enemyBlock.length());
                System.out.print(PINK + enemyBlock + RESET + " ".repeat(Math.max(0, blockPad)));
            }
        }
        System.out.println("   ");
        System.out.println("=".repeat(Math.max(0, barLength)));
        System.out.println("   ");
        System.out.println(CYAN + "Water: " + mizu.getWater() + RESET);
        for (int i = 0; i < party.length; i++) {
            if (party[i] != null && !party[i].isKnockedOut()) {
                System.out.println(ORANGE+party[i].getName() +RESET+CORAL+" (" + party[i].getHP() + "/" + party[i].getMaxHp() + ")" + RESET);
            }
        }
    }
    public void individualAnimalTurn(Animal a) {
        boolean checkWhileExecuteBasic = false;
        boolean checkWhileExecuteSuper = false;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("It's " + ORANGE+a.getName()+RESET + "'s turn");
        do {
        ourChoicesPrint(a);
        System.out.println(" ");
        System.out.println("Pick an option (number).");
        int choiceInput = readNumber(2);
        
        
        if (choiceInput == 1) {
            checkWhileExecuteBasic = everythingAboutBasic(a);
        }
        else {
            checkWhileExecuteSuper = everythingAboutSpecial(a);
        }
        } while (checkWhileExecuteSuper == false && checkWhileExecuteBasic == false);
    }
    public void playerPhase() {
        System.out.println("Choose animal to act. (number).");
        int choice = 0;
        for (Animal animal : party) {
            do {
                choice = scan.nextInt();
                if (party[choice - 1] != null && !party[choice - 1].isKnockedOut()) {
                    individualAnimalTurn(party[choice - 1]);    
                }
            }
            while ((choice - 1) < 0 || (choice - 1) >= party.length);
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
                    + " on " + target.getLabel());
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
            System.out.println("Tragic death. Better luck in another timeline...");
            System.out.println(" ");
            Story.enterCont();
            Story.badending1();
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
