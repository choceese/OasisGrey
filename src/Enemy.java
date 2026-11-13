import java.util.Random;
public class Enemy {
    private int hp;
    private int maxHP;
    private int attack;
    private int block;
    private String name;
    private int heat;
    private int turnCounter;
    Intent[] options;
    Intent currentIntent;
    private Random rand = new Random();

    public Enemy(String name, int maxHP, Intent[] options) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.options = options;
    }
    public void describe() {
        System.out.println(name);
        System.out.println("HP: " + hp + "/" + maxHP);
    }
    public void takeDamage(int damage) {
            hp -= damage;
            if (hp < 0) {
                hp = 0;
            }
        }
    public void gainBlock(int damage) {
        damage -= block;
        if (damage < 0) {
            damage = 0;
        }
        hp -= damage;
    }
    public void heal(int healAmount) {
            hp += healAmount;
            if (hp > maxHP) {
                hp = maxHP;
            }
            
        }
    public boolean isKnockedOut() {
            if (hp == 0) {
                System.out.println(name + "= dead");
                return true;
            }
            else {
                System.out.println(name + "= alive");
                return false;
            }
        
        }
    public void chooseIntent() {
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
    

}
