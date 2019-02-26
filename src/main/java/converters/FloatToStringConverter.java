
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Float;

@Component
@Transactional
public class FloatToStringConverter implements Converter<Float, String> {

	@Override
	public String convert(final Float arg0) {
		String res;
		if (arg0 == null)
			res = null;
		else
			res = String.valueOf(arg0.getId());
		return res;

	}

}
