package CirArray;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit tests modified in class ...
 */
public class CirArrayListTest extends TestCase {

    private static final int TEST_SIZE = 2048;
    private static final int VALUE_INVALID = -1;
    private static final int VALUE_VALID = 310;
    private static final int VALUE_IGNORE = 5555;

    private List<Integer> sut;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CirArrayListTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CirArrayListTest.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        sut = new CirArrayList<>();
    }

    public void test_constructorDefault_initializedCorrectly() {
        assertThat(sut.size(), is(equalTo(0)));
    }

    public void test_constructorCollection_initializedCorrectly() {

        final Integer[] values = getSequentialIntArray(TEST_SIZE);
        sut = new CirArrayList<>(Arrays.asList(values));

        assertThat(sut.size(), is(equalTo(values.length)));
        assertTrue(sut.containsAll(Arrays.asList(values)));
    }

    private Integer[] getSequentialIntArray(int size) {
        Integer[] values = new Integer[size];
        for (int i = 0; i < size; i++)
            values[i] = i;

        return values;
    }
    public void test_add_startEmptyEndPosition_contentsCorrect() {
        Integer[] values = getSequentialIntArray(TEST_SIZE);
        for (int position = 0; position < values.length; position++) {
            sut.add(position, values[position]);
        }

        assertThat(sut.size(), is(equalTo(values.length)));
        for (int position = 0; position < values.length; position++) {
            assertThat(sut.get(position), is(equalTo(values[position])));
        }
    }

    public void test_add_startEmptyFrontPosition_contentsCorrect() {
        Integer[] values = getSequentialIntArray(TEST_SIZE);
        for (int position = 0; position < values.length; position++) {
            sut.add(0, values[position]);
        }

        assertThat(sut.size(), is(equalTo(values.length)));
        Arrays.sort(values, Comparator.reverseOrder());
        for (int position = 0; position < values.length; position++) {
            assertThat(sut.get(position), is(equalTo(values[position])));
        }
    }

    public void test_add_existingCollectionFrontPosition_contentsCorrect() {
        Integer[] values = getSequentialIntArray(TEST_SIZE);
        sut = new CirArrayList(Arrays.asList(values));
        for (int value = TEST_SIZE - 1; value >= 0; value--) {
            sut.add(0, value);
        }

        assertThat(sut.size(), is(equalTo(TEST_SIZE << 1)));
        for (int position = 0; position < TEST_SIZE; position++) {
            assertThat(sut.get(position), is(equalTo(position)));
            assertThat(sut.get(position + TEST_SIZE), is(equalTo(position)));
        }
    }
}
