import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testArrayDeque() {
        ArrayDequeSolution<Integer> stdAnswer = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> stuAnswer = new StudentArrayDeque<>();

        //addLast
        for (int i = 0; i < 10; i++) {
            int randomNum = StdRandom.uniform(100);
            stdAnswer.addLast(randomNum);
            stuAnswer.addLast(randomNum);

            Integer expected = stdAnswer.get(i);
            Integer actual = stuAnswer.get(i);
            assertEquals("addLast(" + randomNum + ")", expected, actual);
            System.out.printf("addLast(%d)\n", randomNum);
        }

        //addFirst
        for (int i = 0; i < 10; i++) {
            int randomNum = StdRandom.uniform(100);
            stdAnswer.addFirst(randomNum);
            stuAnswer.addFirst(randomNum);
            Integer expected = stdAnswer.get(i);
            Integer actual = stuAnswer.get(i);
            assertEquals("addFirst(" + randomNum + ")", expected, actual);
            System.out.printf("addFirst(%d)\n", randomNum);

        }

        //removeFirst
        for (int i = 0; i < 10; i++) {
            Integer expected = stdAnswer.removeFirst();
            Integer actual = stuAnswer.removeFirst();
            assertEquals("removeFirst()", expected, actual);
            System.out.printf("removeFirst()\n");
        }

        //removeLast
        for (int i = 0; i < 10; i++) {
            Integer expected = stdAnswer.removeLast();
            Integer actual = stuAnswer.removeLast();
            assertEquals("removeLast()", expected, actual);
            System.out.printf("removeLast()\n");
        }
    }
}
