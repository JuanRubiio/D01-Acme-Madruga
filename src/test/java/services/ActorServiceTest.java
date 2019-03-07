
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.Actor;

// NOTA: ES NECESARIO POPULAR ANTES DE EJECUTAR EL TEST, PARA PREVENIR POSIBLES FALLOS

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class ActorServiceTest extends AbstractTest {

	@Autowired
	private ActorService	actorService;


	@Test
	public void findAllActorTest() {
		final Collection<Actor> act = this.actorService.findAll();

		Assert.isTrue(!act.isEmpty());

	}

	@Test
	public void findOneActorTest() {
		final Actor act = this.actorService.findOne(13);

		Assert.isTrue(act.getName().equals("Juan"));

	}

	@Test
	public void saveActorTest() {

		final Actor before = this.actorService.findOne(13);

		before.setName("pepito");
		this.actorService.save(before);
		final Actor later = this.actorService.findOne(13);

		Assert.isTrue(later.getName().equals("pepito"));

	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteTest() {

		final Actor before = this.actorService.findOne(13);
		this.actorService.delete(before);
		final Actor later = this.actorService.findOne(13);

	}

	//	@Test
	//	public void getPrincipalTest() {
	//
	//		this.actorService.getPrincipal();
	//
	//	}

}
