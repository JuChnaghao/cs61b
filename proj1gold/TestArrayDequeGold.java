import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void testArrayDeque() {
        ArrayDequeSolution<Integer> l1 = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> l2 = new StudentArrayDeque<>();
        int num = 100;
        int size = 0;
        String operations = "";
        while (true) {
            int numberBetweenZeroAndFour = StdRandom.uniform(4);
            if (numberBetweenZeroAndFour == 0) {
                Integer x = StdRandom.uniform(num);
                l1.addFirst(x);
                l2.addFirst(x);
                size++;
                operations += String.format("addFirst(%d)\n",x);
            } else if (numberBetweenZeroAndFour == 1) {
                Integer x = StdRandom.uniform(num);
                l1.addLast(x);
                l2.addLast(x);
                size++;
                operations += String.format("addLast(%d)\n",x);
            } else if (numberBetweenZeroAndFour == 2) {
                if(size != 0){
                    Integer remove1,remove2;
                    remove1 = l1.removeFirst();
                    remove2 = l2.removeFirst();
                    operations += "removeFirst()\n";
                    assertEquals(operations, remove1, remove2);
                    size--;
                }
            }
            else {
                if(size != 0) {
                    Integer remove1,remove2;
                    remove1 = l1.removeLast();
                    remove2 = l2.removeLast();
                    operations += "removeLast()\n";
                    assertEquals(operations, remove1, remove2);
                    size--;
                }
            }
        }
    }
}
