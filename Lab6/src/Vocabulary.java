public abstract class Data {
    public abstract String getWord();
}

public class WordEnglish extends Data {
    private String word;

    public WordEnglish(String word) {
        this.word = word;
    }

    @Override
    public String getWord() {
        return word;
    }
}

public class WordGerman extends Data {
    private String word;

    public WordGerman(String word) {
        this.word = word;
    }

    @Override
    public String getWord() {
        return word;
    }
}
