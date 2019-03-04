//
// package services;
//
// import java.util.Collection;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.util.Assert;
//
// import utilities.AbstractTest;
// import domain.March;
// import domain.Procession;
//
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = {
// "classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
// })
// @Transactional
// public class MarchServiceTest extends AbstractTest {
//
// @Autowired
// private MarchService marchService;
//
// @Autowired
// private ProcessionService processionService;
//
//
// @Test
// public void testCreateMarch() {
// //Poner un numero para los findOne
// final Procession procession = this.processionService.findOne();
// final March march = this.marchService.create(procession);
// Assert.notNull(march);
// }
//
// @Test
// public void testFindOne() {
// //Falta meter un valor en findOne
// final March march = this.marchService.findOne();
// Assert.notNull(march);
// }
//
// @Test
// public void testFindAll() {
// final Collection<March> march = this.marchService.findAll();
// Assert.notEmpty(march);
// }
//
//}
