
package services;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class FloatServiceTest extends AbstractTest {

	@Autowired
	private FloatService	floatService;


	@Test
	public void testSaveFloat() {
		super.authenticate("brotherhood1");
		final domain.Float floatt = this.floatService.findOne(10);
		floatt.setDescription("esta es una nueva descripcion");
		this.floatService.save(floatt);
		Assert.isTrue(this.floatService.findAll().contains(floatt));
	}

	@Test
	public void testCreate() {
		super.authenticate("brotherhood1");
		final domain.Float floatt = this.floatService.create();
		Assert.notNull(floatt);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteFloat() {
		super.authenticate("brotherhood1");
		domain.Float floatt;
		floatt = this.floatService.findOne(10);
		this.floatService.delete(floatt);
		this.floatService.findOne(10);
		super.authenticate(null);
	}
}
