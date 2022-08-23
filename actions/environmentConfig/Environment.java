package environmentConfig;

import org.aeonbits.owner.Config.Key;

public interface Environment {
	String osName();

	@Key("app.url")
	String appUrl();

	@Key("app.username")
	String appUsername();

	@Key("app.password")
	String appPassword();
}
