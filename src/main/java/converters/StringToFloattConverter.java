
package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import repositories.FloattRepository;
import domain.Floatt;

@Component
@Transactional
public class StringToFloattConverter implements Converter<String, Floatt> {

	@Autowired
	FloattRepository	floattRepository;


	@Override
	public Floatt convert(final String arg0) {
		Floatt res;
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
