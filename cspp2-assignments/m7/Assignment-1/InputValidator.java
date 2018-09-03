public class InputValidator {

	String ka;

	public  InputValidator(String s) {
		this.ka = s;
	}
	public boolean validateData() {
		if (ka.length() >= 6) {
			return true;
		} else {
			return false;
		}

	}
}