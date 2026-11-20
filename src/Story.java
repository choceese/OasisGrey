import java.util.Scanner;
public class Story {
    public static final String CYAN= "\u001B[38;5;117m";
    public static final String RESET = "\u001B[0m";
    public static final String GOLD = "\u001B[38;5;222m";
    public static final String CORAL = "\u001B[38;5;210m";
    public static final String GREY = "\u001B[38;5;103m";
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
        System.out.println("");
        clearScreen();
        System.out.println("It all began in a vast "+GOLD+"desert"+RESET+", with grains of sand that rival the stars of the night sky." + 
        "\nThe "+GOLD+"desert"+RESET+" began as a dry wasteland, but you, a spirit named [username], poured forth "+CYAN+"water"+RESET+
        "\nabove and below the sands, and thus, life began to flourish. "+
        "Through your powers, varieties \nof flora and "+CORAL+"fauna"+RESET+" managed to flourish and survive the challenges "+
        "that the "+GOLD+"desert"+RESET+" provides: \nharsh sandstorms and the blistering heat from the golden sun. "+ 
        "Eventually, you became worshipped \nby the "+GOLD+"desert"+CORAL+" wildlife"+RESET+" as the Spirit of the Springs. "+
        "The "+CYAN+"waters"+RESET+" are your life force and a vital \nresource for all life, especially in the dry ecosystem. "+
        "Without them, life in the \n"+GOLD+"desert"+RESET+" would simply cease to exist.");
        delay();
        System.out.println("Then came the humans, beasts who once utilized sticks and stones to survive in ancient times. "+
        "\nHowever, they have evolved drastically as time goes by. They have created vast settlements, giant "+
        "\nbeetles with wheels as well as birds from cold, lifeless "+GREY+"steel,"+RESET+" "+
        "and now, "+GREY+"steel that can \nimitate the intellect of the clever primates."+RESET);
        enterCont();
        System.out.println("");
        clearScreen();
        System.out.println("");
        System.out.println("Recently, the humans, aided by the thinking steel they call "+GREY+"'robots'"+RESET+", have invaded the "+GOLD+"desert"+RESET+" "+
        "\nto build a massive facility known as the Data Center. Inside, they seek to create "+GREY+"the most intelligent \ncreature "+
        "the world will ever see."+RESET+" But the "+CYAN+"waters"+RESET+" of the "+GOLD+"desert"+RESET+", and all life that thrives there, \nmust be sacrificed to fulfill "+
        "their ambitions. The "+CYAN+"waters"+RESET+" are your life force as well, and as it \nslowly disappears, you begin to feel weak. "+
        "Much of the "+GOLD+"desert "+CORAL+"wildlife"+RESET+" began to suffer from \nlack of food and "+CYAN+"water"+RESET+", habitat loss, and rising temperatures caused "+
        "by the Data Center's construction. ");
        delay();
        System.out.println(CORAL+"They"+RESET+" soon pray to you:");
        System.out.println("");
        System.out.println("'O merciful [username], hear our prayers, bring "+CORAL+"us"+RESET+" back the "+CYAN+"waters"+RESET+" of "+
        "the "+GOLD+"desert"+RESET+" and end our suffering!'");
        enterCont();
        System.out.println("");
        clearScreen();
        System.out.println("");
        System.out.println("Hearing "+CORAL+"their"+RESET+" pleas, you decide to stop this destructive campaign immediately "+
        "at all costs. \nBut you cannot fight alone, as your own strength is not enough to take down the massive infrastructure, "+
        "\nand your efforts will only pollute what's left of the "+GOLD+"desert's"+RESET+" "+CYAN+"waters"+RESET+". So you turn your sight upon your \nhumble "+
        "followers, the "+CORAL+"fauna"+RESET+" of the "+GOLD+"desert"+RESET+".");
        delay();
        System.out.println("You began by giving a faithful "+CORAL+"animal"+RESET+" the blessing of strength and protection necessary to "+
        "fight back \nagainst the construction. Meanwhile, other "+CORAL+"animals"+RESET+" are scattered out there, frightened by the "+GREY+
        "cold, \nliving steel."+RESET+" If you manage to gather and bring "+CORAL+"them"+RESET+" under your blessing, the chance for victory \nshall increase "+
        "significantly. However, "+CYAN+"water"+RESET+" remains a necessary currency for the "+CORAL+"animals"+RESET+" to utilize \ntheir newfound strength, "+
        "and you only have a limited amount before it runs out, so you must manage \nthe vital resource strategically.");
        delay();
        System.out.println("The "+CORAL+"animals"+RESET+" are the "+GOLD+"desert's"+RESET+" last hope. If "+CORAL+"they"+RESET+" all have fallen, or if you are too late, then "+
        "the \n"+GOLD+"desert"+RESET+" is lost, and what's left will be a "+GREY+"grey oasis of steel."+RESET+" \n\nNow go forth, and fight for the future of the "+GOLD+"sands!"+RESET);
        enterCont();
        clearScreen();
    }
}
