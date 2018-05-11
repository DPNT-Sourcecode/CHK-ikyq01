package befaster.solutions.SUM;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import befaster.solutions.HLO.HelloSolution;

public class HelloSolutionTest {
    private HelloSolution hello;

    @Before
    public void setUp() {
    	hello = new HelloSolution();
    }

    @Test
    public void compute_sum() {
        assertThat(hello.hello(null), equalTo("Hello, World!"));
        assertThat(hello.hello("John"), equalTo("Hello, John!"));
    }
}
