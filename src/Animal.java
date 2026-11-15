public class Animal {
        private String name;
        private int hp;
        private int maxHP;
        private int block = 0;
        private boolean retire;
        private int markBonus;
        private int basicDamage;

        Animal (String name, int hp, int maxHP, int basicDamage) { //retire is "is the animal dead or not?"
            this.name = name;
            this.hp = hp;
            this.maxHP = maxHP;
            this.basicDamage = basicDamage;
            block = 0;
            retire = false;
        }
        public void describe () {
            System.out.println(name);
            System.out.println("HP: " + hp + "/" + maxHP);
        }
        public void mark(int bonus) {
            markBonus += bonus;
        }
        public void takeDamage(int amount) {
            amount += markBonus;
            markBonus = 0;
            int absorbed = Math.min(block, amount);
            block -= absorbed;
            amount -= absorbed;
            hp = Math.max(0, hp - amount);
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
        public String getName() {
            return name;
        }
        public int getHP() {
            return hp;
        }
        public int getMaxHp() {
            return maxHP;
        }
        public int getBasic() {
            return basicDamage;
        }
        
            
        }
        
    
