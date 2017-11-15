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
