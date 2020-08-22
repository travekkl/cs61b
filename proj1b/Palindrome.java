public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (word == null) {
            return null;
        }
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    private boolean isPalindromeHelp(Deque<Character> item) {
        if (item.size() <= 1) {
            return true;
        }
        return ((item.removeFirst() == item.removeLast()) && (isPalindromeHelp(item)));
    }

    public boolean isPalindrome(String word) {
        /*if (word.length() <= 1) {
            return true;
        }
        String str = "";
        for (int i = word.length() - 1; i >= 0 ; i--) {
            str += word.charAt(i);
        }
        return word.equals(str);*/
        Deque<Character> d = wordToDeque(word);
        return isPalindromeHelp(d);

    }

    private boolean isPalindromeHelp(Deque<Character> item, CharacterComparator cc) {
        if (item.size() <= 1) {
            return true;
        }
        return ((cc.equalChars(item.removeFirst(), item.removeLast())) && (isPalindromeHelp(item, cc)));
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        return isPalindromeHelp(d, cc);
    }

}
