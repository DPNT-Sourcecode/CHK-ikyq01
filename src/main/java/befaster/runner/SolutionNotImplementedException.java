package befaster.runner;

@SuppressWarnings("serial")
public class SolutionNotImplementedException extends RuntimeException {
    public SolutionNotImplementedException() {
        super("Solution not implemented");
    }

}
