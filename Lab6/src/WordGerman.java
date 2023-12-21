public class WordGerman implements Data {
    private String word;
    private  int Length;

    public WordGerman(String word) {
        this.word = word;
        Length = word.length();
    }
    @Override
    public int getSize() {
        return Length;
    }

    @Override
    public void print() {
        System.out.println(word);
    }

    @Override
    public int compareTo(Data o) {
        Integer s= Length;
        return s.compareTo(o.getSize());
    }

    @Override
    public String getWord() {
        return word;
    }
}
