
package services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.Float;
import domain.Procession;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class ProcessionServiceTest extends AbstractTest {

	@Autowired
	private ProcessionService	processionService;
	@Autowired
	private FloatService		floatService;


	@Test
	public void createTest() {
		final List<Float> floats = new ArrayList<>();
		floats.add(this.floatService.findOne(13));
		final Procession procession = this.processionService.create(floats);
		Assert.notNull(procession);
	}

	@Test
	public void saveTest() {
		final Procession procession = this.processionService.findOne(16);
		Assert.notNull(procession);
		procession.setTitle("Prueba");
		this.processionService.save(procession);
		Assert.isTrue(this.processionService.findOne(16).getTitle().equals("Prueba"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void saveNoDraftTest() {
		final Procession procession = this.processionService.findOne(17);
		procession.setTitle("Prueba");
		this.processionService.save(procession);
	}

}
