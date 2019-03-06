
package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import repositories.EnrolmentRepository;
import domain.Enrolment;

public class StringToEnrolmentConverter implements Converter<String, Enrolment> {

	@Autowired
	EnrolmentRepository	enrolmentRepository;


	@Override
	public Enrolment convert(final String text) {
		Enrolment res;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				res = null;
			else {
				id = Integer.valueOf(text);
				res = this.enrolmentRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}
}
