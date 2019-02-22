
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Floatt;

@Component
@Transactional
public class FloattToStringConverter implements Converter<Floatt, String> {

	@Override
	public String convert(final Floatt arg0) {
		String res;
		if (arg0 == null)
			res = null;
		else
			res = String.valueOf(arg0.getId());
		return res;

	}

}
