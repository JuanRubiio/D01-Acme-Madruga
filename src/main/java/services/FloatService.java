
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.FloattRepository;
import domain.Floatt;

@Service
@Transactional
public class FloatService {

	@Autowired
	private FloattRepository	floattRepository;


	private Floatt create() {
		final Floatt res;
		res = new Floatt();
		return res;
	}

	private Floatt save(final Floatt floatt) {
		Floatt res = new Floatt();
		Assert.notNull(floatt);
		Assert.isTrue(floatt.getDescription() != "");

		res = this.floattRepository.save(floatt);
		Assert.notNull(res);
		return res;
	}

	public Floatt findOne(final Integer floattId) {
		Floatt res;
		Assert.notNull(floattId);
		res = this.floattRepository.findOne(floattId);
		Assert.notNull(res);
		return res;
	}

	public Collection<Floatt> findAll() {
		Collection<Floatt> res;
		res = this.floattRepository.findAll();
		Assert.notNull(res);
		return res;
	}
}
