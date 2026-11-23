public class Animal {
        private String label;
        private String name;
        private int hp;
        private int maxHP;
        private int block = 0;
        private int markBonus;
        private int basicDamage;
        private int specialValue;

        Animal (String label, String name, int hp, int maxHP, int basicDamage, int specialValue) { //retire is "is the animal dead or not?"
            this.label = label;
            this.name = name;
            this.hp = hp;
            this.maxHP = maxHP;
            this.basicDamage = basicDamage;
            this.specialValue = specialValue;
            block = 0;
        }
        public void describe () {
            System.out.println(label);
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
            System.out.println(name + " got healed by " + healAmount + " HP!");
        }
        public int getBlock() {
            return block;
        }
        public void gainBlock(int blockAmount) {
            block += blockAmount;
        }
        public boolean isKnockedOut() {
            if (hp == 0) {
                return true;
            }
            else {
                return false;
            }
    
        }
        public String getLabel() {
            return label;
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
        public int getSpecial() {
            return specialValue;
        }
        
            
}
        
    
