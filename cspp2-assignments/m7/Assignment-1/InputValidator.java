/**
 * Class for input validator.
 */
public class InputValidator {

    String ka;

    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    public  InputValidator(String s) {
        this.ka = s;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean validateData() {
        if (ka.length() >= 6) {
            return true;
        } else {
            return false;
        }

    }
}