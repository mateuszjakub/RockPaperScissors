import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        int choice;
        int randomisedNumber;
        int result = 0;
        int computerResult = 0;
        String wynik;
        String wybor = "";
        String wyborKomputera = "";

        System.out.println("Witaj w grze papier, kamień nożyce. Kto pierwszy zdobędzie 3 wygrane?");
        System.out.println(("Kamień - 1 \nPapier - 2 \nNożyce - 3"));

        Scanner scan = new Scanner(System.in);
        while (result<3 && computerResult<3) {
            do {
                System.out.println("Wprowadź wybór wpisując numer od 1 do 3");
                choice = scan.nextInt();
            }
            while (choice > 3 || choice < 1);

            randomisedNumber = randomiseChoice();

            wybor = getChoiceName(choice, wybor);
            wyborKomputera = getRandomisedNumberName(randomisedNumber, wyborKomputera);
            System.out.println("Twój wybór: " + wybor + " -- Wybór komutera: " + wyborKomputera);

            wynik = checkResult(wybor, wyborKomputera);
            System.out.println(wynik);
            if (wynik.equals("Wygrałeś"))
                result += 1;
            if (wynik.equals("Przegrałeś"))
                computerResult += 1;

            System.out.println("Twój wynik: " + result + " -- Wynik komputera: " + computerResult+"\n");
        }
        System.out.println("----------------------------");

    if (result>computerResult) {
        System.out.println("Gratulacje! Wygrałeś grę!");
    }
        else {
            System.out.println("Niestety przegrałeś. Spróbuj jeszce raz.");
        }

    }

    private static String getRandomisedNumberName(int randomisedNumber, String wyborKomputera) {
        switch (randomisedNumber) {
            case 1 -> wyborKomputera = "Kamień";
            case 2 -> wyborKomputera = "Papier";
            case 3 -> wyborKomputera = "Nożyce";
        }
        return wyborKomputera;
    }


    private static String getChoiceName(int choice, String wybor) {
        switch (choice) {
            case 1 -> wybor = "Kamień";
            case 2 -> wybor = "Papier";
            case 3 -> wybor = "Nożyce";
        }
        return wybor;
    }



    public static String checkResult(String wybor, String wyborKomputera){
        String wynik = "";
        switch(wybor){
            case "Kamień":
                if (wyborKomputera.equals("Kamień"))
                    wynik = "Remis";
                if (wyborKomputera.equals("Papier"))
                    wynik = "Przegrałeś";
                if (wyborKomputera.equals("Nożyce"))
                    wynik = "Wygrałeś";
                break;
            case "Papier":
                if (wyborKomputera.equals("Kamień"))
                    wynik = "Wygrałeś";
                if (wyborKomputera.equals("Papier"))
                    wynik = "Remis";
                if (wyborKomputera.equals("Nożyce"))
                    wynik = "Przegrałeś";
                break;
            case "Nożyce":
                if (wyborKomputera.equals("Kamień"))
                    wynik = "Przegrałeś";
                if (wyborKomputera.equals("Papier"))
                    wynik = "Wygrałeś";
                if (wyborKomputera.equals("Nożyce"))
                    wynik = "Remis";
                break;
        }
        return wynik;
    }

    public static int randomiseChoice() {
        return 1+ ((int) (Math.random()*3));
    }

}
