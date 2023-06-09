public class OffByN implements CharacterComparator {
    private int offsetN;
    public OffByN(int N) {
        this.offsetN = N;
    }

    @Override
    public boolean equalChars(char a, char b) {
        return Math.abs(a - b) == offsetN;
    }
}
