
public class main {
    public static void main(String[] args) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int row = 0; row < 10; row++) {
            System.out.print(row + " ");
            for (int column = 0; column < 10; column++) {
                System.out.print(". ");
            }
            System.out.println();
        }
    }
}
