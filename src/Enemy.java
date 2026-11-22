import java.util.Random;
public class Enemy {
    private int hp;
    private int maxHP;
    private int attack;
    private int block = 0;
    private String name;
    private int heat;
    private int turnCounter;
    private Intent[] options;
    private Intent currentIntent;
    private Random rand = new Random();
    private int markBonus;
    private boolean usesCycle;
    private int cycleIndex = 0;

    public Enemy(String name, int maxHP, Intent[] options, boolean usesCycle) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.options = options;
        this.usesCycle = usesCycle;
    }
    public void describe() {
        System.out.println(name);
        System.out.println("HP: " + hp + "/" + maxHP);
    }
    public void takeDamage(int amount) {
        int absorbed = Math.min(block, amount);
        block -= absorbed;
        amount -= absorbed;
        hp = Math.max(0, hp - amount);
        System.out.println(name + " takes " + amount + " damage!");
}
    public int getBlock() {
        return block;
    }
    public void gainBlock(int amount) {
        block += amount;
    }

    public void resetBlock() {
        block = 0;
    }
    
    public void heal(int healAmount) {
            hp += healAmount;
            if (hp > maxHP) {
                hp = maxHP;
            }
            
    }
    public boolean isKnockedOut() {
            if (hp == 0) {
                return true;
            }
            else {
                return false;
            }
        
    }
    
    public void chooseIntent() { //this assigns value to Enemy's currentIntent field
        if (usesCycle) {
            if (cycleIndex > 2) {
                cycleIndex = 0;
            }
            currentIntent = options[cycleIndex];
            cycleIndex++;
            return;
        }
        int totalWeights = 0;
        for (Intent option : options) {
            totalWeights += option.weight;
        }
        int roll = rand.nextInt(totalWeights); 
        int runningWeight = 0;
        for (Intent option : options) {
            runningWeight += option.weight; 
            if (roll < runningWeight) {
                currentIntent = option;
                return;
            }
        }
    }
    public Intent getCurrentIntent() {
        return currentIntent;
    }
    public String getName() {
        return name;
    }
    public int getMaxHp() {
        return maxHP;
    }
    public int getHP() {
        return hp;
    }
    

}
