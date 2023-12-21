import java.io.*;

public class FileWriteExample {
    public static void main(String[] args) {
        try {
            // Створення об'єкта для зчитування з консолі
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Запит користувача ввести число
            System.out.print("Введіть число: ");
            double number = Double.parseDouble(reader.readLine().trim());

            // Запис у текстовий файл
            writeResultToTxt("src/txt.txt", number);

            // Запис у бінарний файл
            writeResultToBin("src/bin.bin", number);

            System.out.println("Число було успішно записане в файли.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeResultToTxt(String fileName, double number) throws IOException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.printf("%f ", number);
        writer.close();
    }

    public static void writeResultToBin(String fileName, double number) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
        dos.writeDouble(number);
        dos.close();
    }
}

