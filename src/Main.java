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
            new Intent("null", null, 0, 0)
        }
        Enemy stakeBot = new Enemy("Stake Bot", 16, 16, 5, 0, 0,
            new String[]{"BLOCK", "BLOCK", "ATTACK", "ATTACK"},
            new int[]{5, 5, 5, 5}
        );


    }
}
