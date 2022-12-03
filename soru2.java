import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        solaDayali();
        sagaDayali();

    }


    static void solaDayali() {
        for (int i = 0; i < 6; i++) {
            for (int j = i; j > 0; --j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void sagaDayali() {
        for (int i = 0; i < 6; i++) {
            for (int j = 6; j > 0; --j) {
                if (i < j)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}








