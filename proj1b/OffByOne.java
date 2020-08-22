public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        //System.out.println((x - y == 1) || (x - y == -1));
        return (Math.abs(x - y) == 1);
    }
}
