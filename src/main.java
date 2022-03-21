import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class main {

    private static final int frameNumber=10;
    private static int countOfPin =10;
    private static final Scanner myObj = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.print("Please enter your name: ");
        Player player=new Player(myObj.nextLine());
        do {
            System.out.println("Would you like to play 1.Active or 2.Passive (1/2) ?");
            if(myObj.nextLine().equals("1")){
                printRulesToPlayer(player);
                //startActiveGame(player);
            }
            else{
               // startPassiveGame(player);
            }


            System.out.println("Would you like to play again (y/n) ?");
        } while (!myObj.nextLine().equals("n"));

    }

    private static void startActiveGame(Player player) throws InterruptedException {

        int rollScore,frameScore=0;
        boolean wasPreviousFrameStrike=false;
        boolean wasPreviousFrameSpare=false;
        boolean isThisFrameStrike=false;
        boolean isThisFrameSpare=false;


        for(int i=1;i<=frameNumber;i++){
            for(int j=1;j<=2;j++){
                Thread.sleep(2000);

                rollScore=rollTheBall(countOfPin);
                countOfPin-=rollScore;
                frameScore+=rollScore;

                if(wasPreviousFrameStrike){
                    player.addToScoresList(i-2,)
                }
                if(j==1 && rollScore==10){ //Strike
                    player.addToScoresList(i-1,frameScore+player.getScores().get(i-1));
                }

            }
            player.addToScoresList(i-1,frameScore+player.getScores().get(i-1));
            countOfPin=10;
            frameScore=0;
        }
    }

    private static void startPassiveGame(Player player) {

    }

    private static int rollTheBall(int countOfPinsLeft){
        return ThreadLocalRandom.current().nextInt(0, countOfPinsLeft + 1);
    }
    private static void printRulesToPlayer(Player player){
        System.out.println("Welcome "+player.getName().toUpperCase(Locale.ROOT)+"\n" +
                "--To make a shot, you have to write \"roll\" to console.\n" +
                "--You have 2 roll chance in each frame.\n" +
                "--After each roll, how many pins you have knock down will be printed.\n" +
                "--After each frame, your round by round score will be printed.\n" +
                "Good Luck");
    }


}
