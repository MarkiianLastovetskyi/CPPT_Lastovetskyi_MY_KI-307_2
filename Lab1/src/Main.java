import java.io.*;
import java.util.*;

/**
 * Клас Main реалізує створення зубчастого массиву , вивід його та запис у файл
 * "MyFile.txt"
 */
public class Main {
    /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args
     * @throws FileNotFoundException
     */

    public static void main(String[] args) throws FileNotFoundException {

        // Оголошення змінних
        int nColumns;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        // Створення файлу для запису
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);
        // Присвоєння довжини з консолі
        System.out.print("Lenght : ");
        nColumns = in.nextInt();
        in.nextLine();
        // Створення зубчастого массиву
        arr = new char[nColumns][];
        for (int i = 0; i < nColumns; i += 2) {
            arr[i] = new char[nColumns];

        }
        // Вибір символу для массиву

        System.out.print("\nSymbol : ");
        filler = in.nextLine();
        in.close();
        // Перевірка на привильністий ввід символу
        if (filler.length() == 1) {
            // Вивід та запис у файл массиву
            for (int j = 0; j < nColumns; j++) {
                for (int i = 0; i < nColumns; i += 2) {

                    arr[i][j] = (char) filler.codePointAt(0);
                    System.out.print(arr[i][j] + "    ");
                    fout.print(arr[i][j] + "    ");

                }

                System.out.print("\n");
                fout.print("\n");
            }
        }

        else if (filler.length() == 0)
            System.out.print("\n Your symbol is absent\n");

        else
            System.out.print("\n Too much symbols\n  ");

        fout.flush();
        fout.close();

    }
}