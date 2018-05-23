package befaster.runner;

@SuppressWarnings("serial")
public class ConfigNotFoundException extends Exception {
    ConfigNotFoundException(String message) {
        super(message);
    }

}
