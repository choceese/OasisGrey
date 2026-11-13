import com.google.gson.Gson; //this is to activate JSON
public class Main {
    
    public static void main(String[] args) {
        Animal sheep = new Animal("Desert Bighorn Sheep", 37, 37);
        Animal pupfish = new Animal("Desert Pupfish", 35, 35);
        Animal squirrel = new Animal("Mojave Ground Squirrel", 30, 30);
        Animal tortoise = new Animal("Mojave Desert Tortoise", 47, 47);
        Animal owl = new Animal("Burrowing Owl", 24, 24);
        Animal lizard = new Animal("Flat-Tailed Horned Lizard", 28, 28);

        Animal[] party = {sheep, pupfish, squirrel, tortoise, owl, lizard};
        for (Animal overview : party) {
            overview.describe();
        }
        Intent[] surveyDroneOptions = {
            new Intent("Mark", "DEBUFF", 3, 30),
            new Intent("Ping", "ATTACK", 4, 70)
        };
        Enemy surveyDrone = new Enemy("Survey Drone", 12, surveyDroneOptions);

        Intent[] stakeBotOptions = {
            new Intent("Stake Strike", "ATTACK", 5, 55),
            new Intent("Protect", "BLOCK", 5, 45)
        };
        Enemy stakeBot = new Enemy("Stake Bot", 16, stakeBotOptions);
        
        int blocks = 0;
        int attacks = 0;
        for (int i = 0; i < 1000; i++) {
            stakeBot.chooseIntent();
            if (stakeBot.getCurrentIntent().label.equals("Protect")) {
                blocks++;
            } else {
                attacks++;
            }
        }
        System.out.println("Blocks: " + blocks + ", Attacks: " + attacks);
    }
}
