package CirArray;

import java.util.List;
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
}
