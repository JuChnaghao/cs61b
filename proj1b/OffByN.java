public class OffByN implements CharacterComparator{
    private int N;
    private OffByN(int n)
    {
        N = n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if(x + N == y || x == y + N)
            return true;
        return false;
    }
}
