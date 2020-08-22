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
            assertEquals("addLast is bad:", expected, actual);
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
            assertEquals("addFirst is bad:", expected, actual);
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
            assertEquals("removeFirst is bad:", expected, actual);
        }

        //removeLast
        for (int i = 0; i < 10; i++) {
            expectedAnswer.addFirst(stdAnswer.removeLast());
            actualAnswer.addFirst(stuAnswer.removeLast());
        }

        for (int i = 0; i < 10; i++) {
            Integer expected = expectedAnswer.get(i);
            Integer actual = actualAnswer.get(i);
            assertEquals("removeLast is bad:", expected, actual);
        }



    }
}
