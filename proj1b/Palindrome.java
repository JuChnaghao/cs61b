public class Palindrome {
    public Deque<Character> wordToDeque(String word)
    {
        Deque<Character> result = new LinkedListDeque();
        for(int i=0;i<word.length();i++)
        {
            result.addLast(word.charAt(i));
        }
        return result;
    }
    public boolean isPalindrome(String word)
    {
        /**Deque f = wordToDeque(word);
        while(!f.isEmpty() && f.size()!=1)
        {
            if(f.removeFirst() != f.removeLast())
                return false;
        }
        return true;*/
        int i=0, j=word.length()-1;
        while(i<j)
        {
            if(word.charAt(i) != word.charAt(j))
                return false;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc)
    {
        int i=0, j=word.length()-1;
        while(i<j)
        {
            if(!cc.equalChars(word.charAt(i),word.charAt(j)))
                return false;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
