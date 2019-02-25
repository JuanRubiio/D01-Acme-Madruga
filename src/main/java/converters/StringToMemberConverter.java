
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import repositories.MemberRepository;
import domain.Member;

public class StringToMemberConverter implements Converter<String, Member> {

	@Autowired
	MemberRepository	memberRepository;


	@Override
	public Member convert(final String text) {
		Member res;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				res = null;
			else
				id = Integer.valueOf(text);
			res = this.memberRepository.findOne(id);
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}
}
