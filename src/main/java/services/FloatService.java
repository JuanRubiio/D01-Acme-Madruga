
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.FloatRepository;
import domain.Float;

@Service
@Transactional
public class FloatService {

	@Autowired
	private FloatRepository	floattRepository;


	public Float create() {
		final Float res;
		res = new Float();
		return res;
	}

	public Float save(final Float floatt) {
		Float res = new Float();
		Assert.notNull(floatt);
		Assert.isTrue(floatt.getDescription() != "");

		res = this.floattRepository.save(floatt);
		Assert.notNull(res);
		return res;
	}

	public Float findOne(final Integer floattId) {
		Float res;
		Assert.notNull(floattId);
		res = this.floattRepository.findOne(floattId);
		Assert.notNull(res);
		return res;
	}

	public Collection<Float> findAll() {
		Collection<Float> res;
		res = this.floattRepository.findAll();
		Assert.notNull(res);
		return res;
	}

	public void delete(final Float floatt) {
		Assert.notNull(floatt);
		this.floattRepository.delete(floatt);
	}
}
