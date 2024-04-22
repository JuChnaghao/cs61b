import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void testArrayDeque() {
        ArrayDequeSolution<Integer> l1 = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> l2 = new StudentArrayDeque<>();
        int num = 100;
        int size=0;
        String operations = "";
        while (true) {
            double numberBetweenZeroAndFour = 4*StdRandom.uniform();
            if (numberBetweenZeroAndFour < 1) {
                Integer x = StdRandom.uniform(num);
                l1.addFirst(x);
                l2.addFirst(x);
                size++;
                operations += String.format("addFirst(%d)\n",x);
            } else if (numberBetweenZeroAndFour < 2) {
                Integer x = StdRandom.uniform(num);
                l1.addLast(x);
                l2.addLast(x);
                size++;
                operations += String.format("addLast(%d)\n",x);
            } else if (numberBetweenZeroAndFour < 3) {
                if(size != 0){
                    operations += "removefirst()\n";
                    assertEquals(operations, l1.removeFirst(), l2.removeFirst());
                    size--;
                }
            }
            else {
                if(size != 0) {
                    operations += "removeLast()\n";
                    assertEquals(operations, l1.removeLast(), l2.removeLast());
                    size--;
                }
            }
        }
    }
}
