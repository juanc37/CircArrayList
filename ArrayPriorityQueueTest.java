package CirArray;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayPriorityQueueTest extends TestCase {

    private static final int DEFAULT_TEST_SIZE = 8086;
    private static final int DEFAULT_NUM_EPOCH = 4;
    private static final List<String> TEST_NAMES = generateTestValues
            (DEFAULT_TEST_SIZE << DEFAULT_NUM_EPOCH, new NameGenerator());

    private Queue<String> sut;

    private static List<String> generateTestValues(int count,
                                                   IValueGenerator<String>
                                                           generator) {
        List<String> testVals = new java.util.ArrayList<>();
        for (int num = 0; num < count; num++) {
            testVals.add(generator.generate());
        }
        return testVals;
    }

    public void setUp() throws Exception {
        super.setUp();
        sut = new ArrayPriorityQueue<>();
    }

    public void test_constructorDefault_correctInitialValues() {
        assertThat(sut.size(), is(0));
        assertNull(sut.peek());
    }
    public void test_constructorCollection_correctInitialValues() {
        final List<String> testNames = TEST_NAMES.subList(0, DEFAULT_TEST_SIZE);
        sut = new ArrayPriorityQueue<>(testNames);

        assertThat(sut.size(), is(DEFAULT_TEST_SIZE));
        assertTrue(sut.containsAll(testNames));
    }

    public void test_pollFromEmpty_returnsNull() {
        assertNull(sut.poll());
    }

    public void test_elementFromInitiallyEmpty_exception() {
        try {
            sut.element();
            fail("NoSuchElementException expected.");
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }

    public void test_removeFromInitiallyEmpty_exception() {
        try {
            sut.remove();
            fail("NoSuchElementException expected.");
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }

    public void test_offer_containsAllItems() {
        final List<String> testNames = TEST_NAMES.subList(0, DEFAULT_TEST_SIZE);
        for (String item : testNames) {
            sut.offer(item);
        }
        assertTrue(sut.containsAll(testNames));
    }
}
