
package services;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.Float;
import domain.Procession;

@Transactional
public class ProcessionServiceTest extends AbstractTest {

	@Autowired
	private ProcessionService	processionService;


	@Test
	public void createTest() {
		final Collection<Float> floats;
		floats.add();
		final Procession procession = this.processionService.create(floats);
		Assert.notNull(procession);
	}

	//En este test se prueba que un objeto procession cuando es editado se guarda correctamente en bd, 
	//y también se comprueba que no se guarda un objeto procession que es editado tras haber desactivado el draft mode.
	@Test
	public void saveTest() {
		Procession procession = this.processionService.findOne(16);
		Assert.notNull(procession);
		procession.setDraft(false);
		this.processionService.save(procession);
		Assert.isTrue(this.processionService.findOne(16).getDraft() == false);
		procession = this.processionService.findOne(16);
		procession.setDescription("");
		this.processionService.save(procession);
		Assert.isTrue(!(this.processionService.findOne(16).getDescription().equals("")));
	}

}
