
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import repositories.MarchRepository;
import domain.March;

public class StringToMarchConverter implements Converter<String, March> {

	@Autowired
	MarchRepository	marchRepository;


	@Override
	public March convert(final String text) {
		final March res;
		final int id;

		try {
			if (StringUtils.isEmpty(text))
				res = null;
			else {
				id = Integer.valueOf(text);
				res = this.marchRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}
}
