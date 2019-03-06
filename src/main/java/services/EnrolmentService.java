
package services;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.EnrolmentRepository;
import domain.Brotherhood;
import domain.Enrolment;

@Service
@Transactional
public class EnrolmentService {

	@Autowired
	private EnrolmentRepository	enrolmentRepository;

	@Autowired
	private MemberService		memberService;

	@Autowired
	private BrotherHoodService	brotherHoodService;


	//	@Autowired
	//	private ActorService		actorService;

	public EnrolmentService() {
		super();
	}

	public Enrolment create(final Brotherhood brotherhood) {

		Assert.isTrue(!brotherhood.getArea().getName().equals("defaultArea"));
		final Enrolment res = new Enrolment();

		final Member member = this.memberService.findByPrincipal();

		res.setMember(member);

		res.setMoment(Calendar.getInstance().getTime());

		res.setBrotherhood(brotherhood);

		return res;
	}

	public Collection<Enrolment> findAll() {
		Collection<Enrolment> result;

		result = this.enrolmentRepository.findAll();

		Assert.notNull(result);

		return result;

	}

	public Enrolment findOne(final Integer enrolmentId) {
		Enrolment res;
		Assert.notNull(enrolmentId);
		res = this.enrolmentRepository.findOne(enrolmentId);
		Assert.notNull(res);
		return res;

	}

	public Enrolment save(final Enrolment enrolment) {
		Enrolment res;
		final Brotherhood brotherhood = res.getBrotherhood();
		Assert.notNull(enrolment);

		if (enrolment.getId() == 0 || enrolment.getMoment() == null)
			enrolment.setMoment(new Date(System.currentTimeMillis() - 1));

		res = this.enrolmentRepository.save(enrolment);
		brotherhood.getEnrolments().add(res);
		Assert.notNull(res);
		return res;
	}

	public void delete(final Enrolment enrolment) {
		Assert.notNull(enrolment);
		this.enrolmentRepository.delete(enrolment);

	}
}
