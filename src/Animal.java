public class Animal {
        private String name;
        private int hp;
        private int maxHP;
        private int block;
        private boolean retire;

        Animal (String name, int hp, int maxHP) { //retire is "is the animal dead or not?"
            this.name = name;
            this.hp = hp;
            this.maxHP = maxHP;
            block = 0;
            retire = false;
        }
        public void describe () {
            System.out.println(name);
            System.out.println("HP: " + hp + "/" + maxHP);
        }
        public void takeDamage(int damage) {
            hp -= damage;
            if (hp < 0) {
                hp = 0;
            }
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
        
            
        }
        
    
