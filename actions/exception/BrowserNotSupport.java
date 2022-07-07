package exception;

public class BrowserNotSupport extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public BrowserNotSupport(String browserName) {
		super(String.format("Browser name = %s is not support!", browserName.toUpperCase()));
	}
}
