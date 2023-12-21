public class Main {
    public static void main(String[] args) {
        Vocabulary<Data> book = new Vocabulary<>();

        WordEnglish enemyEnglish = new WordEnglish("Enemy");
        WordEnglish animalEnglish = new WordEnglish("Animal");
        WordGerman schiffGerman = new WordGerman("Schiff");

        book.addLine(enemyEnglish, new WordEnglish("Противник"));
        book.addLine(animalEnglish, new WordEnglish("Тварина"));
        book.addLine(schiffGerman, new WordGerman("Корабель"));

        book.showVocabulary();

        book.findMaxWord();
        book.deleteLine(2);
        book.showVocabulary();
        book.findMaxWord();

        book.addLine(new WordEnglish("32132132131232321312"), new WordEnglish("ds"));
        book.findMaxWord();
        book.showVocabulary();
    }
}
