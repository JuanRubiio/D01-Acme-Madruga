
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Brotherhood;

@Component
@Transactional
public class BrotherhoodToStringConverter implements Converter<Brotherhood, String> {

	@Override
	public String convert(final Brotherhood brotherhood) {
		String res;

		if (brotherhood == null)
			res = null;
		else
			res = String.valueOf(brotherhood.g);

		return res;
	}
}
