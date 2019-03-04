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
// import domain.Member;
//
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = {
// "classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
// })
// @Transactional
// public class MemberServiceTest extends AbstractTest {
//
// @Autowired
// private MemberService memberService;
//
//
// @Test
// public void testCreateMember() {
// final Member member = new Member();
// member.setName("Julio");
// member.setMiddleName("Andres");
// member.setSurname("Diaz Robles");
// member.setEmail("julio13@gmail.com");
// member.setPhone("639852100");
// member.setAddress("plaza anabel,14");
// Assert.notNull(member);
// }
//
// @Test
// public void testSaveMember() {
// //Falta meter un valor en findOne
// final Member member = this.memberService.findOne();
// member.setName("William");
// this.memberService.save(member);
// Assert.notNull(this.memberService.findAll().contains(member));
// }
//
// @Test
// public void testFindOne() {
// //Falta meter un valor en findOne
// final Member member = this.memberService.findOne();
// Assert.notNull(member);
// }
//
// @Test
// public void testFindAll() {
// final Collection<Member> member = this.memberService.findAll();
// Assert.notEmpty(member);
// }
//
//}
