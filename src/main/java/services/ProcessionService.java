
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ProcessionRepository;
import domain.Float;
import domain.Procession;

@Service
@Transactional
public class ProcessionService {

	@Autowired
	private ProcessionRepository	processionRepository;


	public Procession findOne(final Integer processionId) {
		Procession res;
		res = this.processionRepository.findOne(processionId);
		Assert.notNull(res);
		return res;
	}

	public Collection<Procession> findAll() {
		Collection<Procession> res;
		res = this.processionRepository.findAll();
		Assert.notNull(res);
		return res;
	}

	public Procession create(final Collection<Float> floats) {
		Procession res;
		res = new Procession();

		Assert.notNull(floats);

		res.setFloats(floats);
		res.setTicker("111111-AAAAA");
		res.setDraft(true);

		Assert.notNull(res);

		return res;

	}

	public Procession save(final Procession procession) {
		Assert.notNull(procession);
		Assert.isTrue(procession.getDraft() == false);

		final Procession res = this.processionRepository.save(procession);
		Assert.notNull(res);

		return res;
	}

	public Procession delete(final Procession procession) {
		Assert.notNull(procession);
		this.processionRepository.delete(procession);
		Assert.isNull(this.processionRepository.findOne(procession.getId()));
		return procession;

	}

}
