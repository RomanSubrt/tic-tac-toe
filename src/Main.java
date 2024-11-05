import java.util.Scanner;

public class Main {

    public static void PrintPlane(char[] gamePlane) {
        System.out.println(gamePlane[0] + " | " + gamePlane[1] + " | " + gamePlane[2]);
        System.out.println("---------");
        System.out.println(gamePlane[3] + " | " + gamePlane[4] + " | " + gamePlane[5]);
        System.out.println("---------");
        System.out.println(gamePlane[6] + " | " + gamePlane[7] + " | " + gamePlane[8]);
    }

    public static boolean CheckField(char[] gamePlane, int index, char player) {
        if ((index < 0) || (index > 8)) {
            System.out.println("toto pole nemuzes zadat, neexistuje");
            return false;
        }
        if ((gamePlane[index] == 'X') || (gamePlane[index] == 'O')) {
            System.out.println("toto pole nemuzes zadat, je obsazene");
            return false;
        }
        return true;
    }

    public static boolean IsWinner(char[] gamePlane, char player) {
        if ((gamePlane[0] == player) && (gamePlane[1] == player) && (gamePlane[2] == player)) return true;
        if ((gamePlane[3] == player) && (gamePlane[4] == player) && (gamePlane[5] == player)) return true;
        if ((gamePlane[6] == player) && (gamePlane[7] == player) && (gamePlane[8] == player)) return true;
        if ((gamePlane[0] == player) && (gamePlane[3] == player) && (gamePlane[6] == player)) return true;
        if ((gamePlane[1] == player) && (gamePlane[4] == player) && (gamePlane[7] == player)) return true;
        if ((gamePlane[2] == player) && (gamePlane[5] == player) && (gamePlane[8] == player)) return true;
        if ((gamePlane[0] == player) && (gamePlane[4] == player) && (gamePlane[8] == player)) return true;
        if ((gamePlane[2] == player) && (gamePlane[4] == player) && (gamePlane[6] == player)) return true;
        return false;
    }

    public static boolean IsTie(char[] gamePlane) {
        for (int i = 0; i < gamePlane.length; i++) {
            if (gamePlane[i] != 'X' && gamePlane[i] != 'O') return false;
        }
        return true;
    }


    public static void main(String[] args) {
        char[] gamePlane = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char player = 'O';
        int index;
        boolean tie = false;
        Scanner scanner = new Scanner(System.in);
        PrintPlane(gamePlane);
        while (!IsWinner(gamePlane, player)) {
            if (IsTie(gamePlane)) {
                tie = true;
                break;
            }
            if (player == 'O') player = 'X';
            else player = 'O';
            do {
                System.out.print("pole pro hrace " + player + ": ");
                index = scanner.nextInt();
            }
            while (!CheckField(gamePlane, index - 1, player));
            gamePlane[index - 1] = player;
            PrintPlane(gamePlane);
        }
        if (tie) System.out.println("Je to nerozhodne");
        else System.out.println("Hrac " + player + " vyhral");
    }
}
