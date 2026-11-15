import com.google.gson.Gson; //this is to activate JSON
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Animal sheep = new Animal("Desert Bighorn Sheep", 37, 37, 7);
        /*Animal pupfish = new Animal("Desert Pupfish", 35, 35);
        Animal squirrel = new Animal("Mojave Ground Squirrel", 30, 30);
        Animal tortoise = new Animal("Mojave Desert Tortoise", 47, 47);
        Animal owl = new Animal("Burrowing Owl", 24, 24);
        Animal lizard = new Animal("Flat-Tailed Horned Lizard", 28, 28);

        Animal[] party = {sheep, pupfish, squirrel, tortoise, owl, lizard};
        for (Animal overview : party) {
            overview.describe();
        } */
        Scanner scan = new Scanner(System.in);
        Animal[] party = {sheep};
        Intent[] surveyDroneOptions = {
            new Intent("Mark", "DEBUFF", 3, 30),
            new Intent("Ping", "ATTACK", 4, 70)
        };
        Enemy surveyDrone = new Enemy("Survey Drone", 12, surveyDroneOptions);

        Intent[] stakeBotAOptions = {
            new Intent("Stake Strike", "ATTACK", 5, 55),
            new Intent("Protect", "BLOCK", 5, 45)
        };
        Enemy stakeBotA = new Enemy("Stake Bot A", 16, stakeBotAOptions);

        Intent[] stakeBotBOptions = {
            new Intent("Stake Strike", "ATTACK", 5, 55),
            new Intent("Protect", "BLOCK", 5, 45)
        };
        Enemy stakeBotB = new Enemy("Stake Bot B", 16, stakeBotBOptions);

        Enemy[] gang = {stakeBotA, stakeBotB};

        Battle battle = new Battle(party, gang, 0, scan);

        battle.run();
        /*
        for (Enemy enemy : enemies) {
            enemy.chooseIntent();
            System.out.print(current intent)
        }
        while (areEnemiesDefeated = false) {
          for (Animal unit : party) {
            chooseAbility = scan.nextInt();
            if (chooseAbility = 1) {
                basicSkill 
            }
            else {
                specialSkill    
            }
            for (Enemy enemy : enemies) {

            }
            for (Enemy enemy : enemies) {
                enemy.executeIntent
            }
          }
        }
    
        
        
        
        
        
        */
        
        
    }
}
