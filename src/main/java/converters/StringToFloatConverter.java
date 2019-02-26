
package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.FloatRepository;
import domain.Float;

@Component
@Transactional
public class StringToFloatConverter implements Converter<String, Float> {

	@Autowired
	FloatRepository	floattRepository;


	@Override
	public Float convert(final String arg0) {
		Float res;
		int id;
		try {
			if (StringUtils.isEmpty(arg0))
				res = null;
			else {
				id = Integer.valueOf(arg0);
				res = this.floattRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}
