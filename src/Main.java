import com.google.gson.Gson; //this is to activate JSON
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Animal sheep = new Animal("sheep", "Desert Bighorn Sheep", 37, 37, 7, 21);
        Animal sheepB = new Animal("sheep", "Desert Bighorn Sheep", 37, 37, 7, 21);
        Animal pupfish = new Animal("pupfish", "Desert Pupfish", 35, 35, 0, 10);
        Animal squirrel = new Animal("squirrel", "Mojave Ground Squirrel", 30, 30, 0, 0);
        Animal tortoise = new Animal("tortoise", "Mojave Desert Tortoise", 47, 47, 0, 0);
        Animal owl = new Animal("owl", "Burrowing Owl", 24, 24, 4, 20);
        Animal lizard = new Animal("lizard", "Flat-Tailed Horned Lizard", 28, 28, 3, 15);

        /*Animal[] party = {sheep, pupfish, squirrel, tortoise, owl, lizard};
        for (Animal overview : party) {
            overview.describe();
        } */
        Scanner scan = new Scanner(System.in);
        Animal[] party = {lizard, owl, sheep};
        Intent[] surveyDroneOptions = {
            new Intent("Mark", "DEBUFF", 3, 30),
            new Intent("Ping", "ATTACK", 4, 70)
        };
        Enemy surveyDrone = new Enemy("Survey Drone", 12, surveyDroneOptions, false);

        Intent[] stakeBotAOptions = {
            new Intent("Stake Strike", "ATTACK", 5, 55),
            new Intent("Protect", "BLOCK", 5, 45)
        };
        Enemy stakeBotA = new Enemy("Stake Bot A", 16, stakeBotAOptions, false);

        Intent[] stakeBotBOptions = {
            new Intent("Stake Strike", "ATTACK", 5, 55),
            new Intent("Protect", "BLOCK", 5, 45)
        };
        Enemy stakeBotB = new Enemy("Stake Bot B", 16, stakeBotBOptions, false);

        Intent[] trencherOptions = {
            new Intent("Wind-up", "CHARGE", 0, 0),
            new Intent("Wind-up", "CHARGE", 0, 0),
            new Intent("Tectonic Slam", "ATTACK", 20, 0)
        };
        Enemy trencher = new Enemy("The Threncher", 22, trencherOptions, true);

        Intent[] droneAidOptions = {
            new Intent("Emergency Repair", "HEAL", 6, 50),
            new Intent("Fly", "BLOCK", 4, 50)
        };
        Enemy droneAid = new Enemy("Drone Aid", 8, droneAidOptions, false);

        Enemy[] gang = {stakeBotA, trencher, droneAid};

        Water mizu = new Water(30);

        Battle battle = new Battle(party, gang, mizu, scan); //The absolute CORE of the entire code

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
