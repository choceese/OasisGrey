import java.util.Scanner;
public class Story {
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void delay(){
        try {
            Thread.sleep(3000);
            System.out.println("");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static void enterCont(){
        Scanner scan = new Scanner(System.in);
        try {
            Thread.sleep(3000);
            System.out.println("");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.print("Press enter to continue...");
        scan.nextLine();
        System.out.print("\033[1A\033[2K");
        System.out.flush();
    }
    
    public static void main(String[] args) {
        clearScreen();
        System.out.println("");
        System.out.println("It all began in a vast desert, with grains of sand that rival the stars of the night sky." + 
        "\nThe desert began as a dry wasteland, but you, a spirit named [username], poured forth water "+
        "\nabove and below the sands, and thus, life began to flourish."+
        "Through your powers, varieties \nof flora and fauna managed to flourish and survive the challenges "+
        "that the desert provides: \nharsh sandstorms and the blistering heat from the golden sun. "+ 
        "Eventually, you became worshipped \nby the desert wildlife as the Spirit of the Springs. "+
        "The waters are your life force and a vital \nresource for all life, especially in the dry ecosystem. "+
        "Without them, life in the \ndesert would simply cease to exist.");
        delay();
        System.out.println("Then came the humans, beasts who once utilized sticks and stones to survive in ancient times. "+
        "\nHowever, they have evolved drastically as time goes by. They have created vast settlements, giant "+
        "\nbeetles with wheels as well as birds from cold, lifeless steel, "+
        "and now, steel that can \nimitate the intellect of the clever primates.");
        enterCont();
        System.out.println("");
        clearScreen();
        System.out.println("");
        System.out.println("Recently, the humans, aided by the thinking steel they call 'robots', have invaded the desert "+
        "\nto build a massive facility known as the Data Center. Inside, they seek to create the most intelligent \ncreature "+
        "the world will ever see. But the waters of the desert, and all life that thrives there, \nmust be sacrificed to fulfill "+
        "their ambitions. The waters are your life force as well, and as the \nwaters slowly disappear, you begin to feel weak. "+
        "Much of the desert wildlife began to suffer from \nlack of food and water, habitat loss, and rising temperatures caused "+
        "by the Data Center's construction. ");
        delay();
        System.out.println("They soon pray to you:");
        System.out.println("");
        System.out.println("'O merciful [username], hear our prayers, bring us back the waters of "+
        "the desert and end our suffering!'");
        enterCont();
        System.out.println("");
        clearScreen();
        System.out.println("");
        System.out.println("Hearing their pleas, you decide to stop this destructive campaign immediately "+
        "at all costs. \nBut you cannot fight alone, as your own strength is not enough to take down the massive infrastructure, "+
        "\nand your efforts will only pollute what's left of the desert's waters. So you turn your sight upon your \nhumble "+
        "followers, the fauna of the desert.");
        delay();
        System.out.println("You began by giving a faithful animal the blessing of strength and protection necessary to "+
        "fight back \nagainst the construction. Meanwhile, other animals are scattered out there, frightened of the terrifying \nbeasts "+
        "of steel. If you manage to gather and bring them under your blessing, the chance for victory \nshall increase "+
        "significantly. However, water remains a necessary currency for the animals to utilize \ntheir newfound strength, "+
        "and you only have a limited amount before it runs out, so you must manage \nthe vital resource strategically.");
        delay();
        System.out.println("The animals are the desert's last hope. If they have all fallen, or if you are too late, then "+
        "the \ndesert is lost, and what's left will be a grey oasis of steel. \n\nNow go forth, and fight for the future of the sands!");
        enterCont();
        clearScreen();
    }
}
