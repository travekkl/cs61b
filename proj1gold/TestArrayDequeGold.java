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
        }

        for (int i = 0; i < 10; i++) {
            Integer expected = stdAnswer.get(i);
            Integer actual = stuAnswer.get(i);
            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                    + " not equal to " + expected + "!", expected, actual);
        }

        //addFirst
        for (int i = 0; i < 10; i++) {
            int randomNum = StdRandom.uniform(100);
            stdAnswer.addFirst(randomNum);
            stuAnswer.addFirst(randomNum);
        }

        for (int i = 0; i < 10; i++) {
            Integer expected = stdAnswer.get(i);
            Integer actual = stuAnswer.get(i);
            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                    + " not equal to " + expected + "!", expected, actual);
        }

        //removeFirst
        ArrayDequeSolution<Integer> actualAnswer = new ArrayDequeSolution<>();
        ArrayDequeSolution<Integer> expectedAnswer = new ArrayDequeSolution<>();
        for (int i = 0; i < 10; i++) {
            expectedAnswer.addLast(stdAnswer.removeFirst());
            actualAnswer.addLast(stuAnswer.removeFirst());
        }

        for (int i = 0; i < 10; i++) {
            Integer expected = expectedAnswer.get(i);
            Integer actual = actualAnswer.get(i);
            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                    + " not equal to " + expected + "!", expected, actual);
        }

        //removeLast
        for (int i = 0; i < 10; i++) {
            expectedAnswer.addFirst(stdAnswer.removeLast());
            actualAnswer.addFirst(stuAnswer.removeLast());
        }

        for (int i = 0; i < 10; i++) {
            Integer expected = expectedAnswer.get(i);
            Integer actual = actualAnswer.get(i);
            assertEquals("Oh noooo!\nThis is bad:\n   Random number " + actual
                    + " not equal to " + expected + "!", expected, actual);
        }



    }
}
