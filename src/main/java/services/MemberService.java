
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.MemberRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Member;
import forms.RegisterMemberForm;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepository	memberRepository;
	@Autowired
	private ActorService		actorService;


	public MemberService() {
		super();
	}

	public Member create() {
		Member res;
		res = new Member();

		final UserAccount userAccount = new UserAccount();

		final List<Authority> authorities = new ArrayList<Authority>();
		final Authority authority = new Authority();
		authority.setAuthority(Authority.MEMBER);
		authorities.add(authority);
		userAccount.setAuthorities(authorities);

		res.setUserAccount(userAccount);

		return res;
	}
	public Member save(final Member member) {
		Member res;
		Assert.notNull(member);
		res = this.memberRepository.save(member);
		Assert.notNull(res);
		return res;
	}

	public Member save(final RegisterMemberForm registerMemberForm) {
		final Member res = this.create();

		final UserAccount userAccount = new UserAccount();
		final String password = registerMemberForm.getPassword();
		final Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		final String hashedPassword = encoder.encodePassword(password, null);
		userAccount.setPassword(hashedPassword);
		userAccount.setUsername(registerMemberForm.getUsername());

		res.setAddress(registerMemberForm.getAddress());
		res.setMiddleName(registerMemberForm.getMiddleName());
		res.setEmail(registerMemberForm.getEmail());
		res.setName(registerMemberForm.getName());
		res.setPhone(registerMemberForm.getPhone());
		res.setPhoto(registerMemberForm.getPhoto());
		res.setSurname(registerMemberForm.getSurname());

		this.save(res);

		return res;
	}

	public void delete(final Member member) {
		Assert.notNull(member);
		Assert.isTrue(member.getId() != 0);
		Assert.isTrue(this.memberRepository.exists(member.getId()));
		final int id = LoginService.getPrincipal().getId();
		final int memberid = member.getId();
		Assert.isTrue(id == memberid || LoginService.getPrincipal().getAuthorities().contains(Authority.ADMIN));

		this.memberRepository.delete(member);
	}

	public Collection<Member> findAll() {
		Collection<Member> res;
		res = this.memberRepository.findAll();
		Assert.notNull(res);
		return res;
	}

	public Member findOne(final Integer memberId) {
		Member res;
		Assert.notNull(memberId);
		res = this.memberRepository.findOne(memberId);
		Assert.notNull(res);
		return res;
	}

}
