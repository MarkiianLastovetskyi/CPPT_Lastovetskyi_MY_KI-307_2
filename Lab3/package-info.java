package Lab_3_lahan;
public class Main {
    public static void main(String[] args) {
        try {
            // Створення об'єкту AndroidPhone (підкласу Phone)
            Phone androidPhone = new AndroidPhone();
            // Тепер можна використовувати об'єкт androidPhone для виклику методів та взаємодії з класом.

            // Створення об'єкту IPhone (підкласу Phone)
            Phone iPhone = new IPhone();
            // Тепер можна використовувати об'єкт iPhone для виклику методів та взаємодії з класом.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
