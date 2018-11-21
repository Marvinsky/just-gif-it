package schultz.dustin.io.health;

import javax.inject.Inject;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.justgifit.JustGiftItProperties;

@Component
public class JustGifItHealthIndicator implements HealthIndicator  {

	@Inject
	private JustGiftItProperties properties;
	
	@Override
	public Health health() {
		if (!properties.getGifLocation().canWrite()) {
			return Health.down().build();
		}
		return Health.up().build();
	}

}
