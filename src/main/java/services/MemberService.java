
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.MemberRepository;
import security.Authority;
import security.UserAccount;
import domain.Actor;
import domain.BrotherHood;
import domain.Member;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepository	memberRepository;
	@Autowired
	private ActorService		actorService;


	public Member create() {
		Member res;
		res = new Member();
		final UserAccount userAccount = new UserAccount();
		final Actor actor = this.actorService.getPrincipal();
		final Collection<Authority> authorities2 = actor.getUserAccount().getAuthorities();
		final List<Authority> authorities = new ArrayList<Authority>();
		final ArrayList<String> listAuth = new ArrayList<String>();
		final Authority authority = new Authority();
		authority.setAuthority(Authority.MEMBER);
		authorities.add(authority);
		userAccount.setAuthorities(authorities);
		res.setUserAccount(userAccount);

		if (!authorities2.isEmpty())
			for (final Authority au : authorities2)
				listAuth.add(au.getAuthority());
		Assert.isTrue(listAuth.contains("ADMIN"));
		Assert.notNull(res);

		final BrotherHood brotherHood = new BrotherHood();
		res.setBrotherHood(brotherHood);

		return res;
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

	public Member save(final Member member) {
		Member res;
		Assert.notNull(member);
		res = this.memberRepository.save(member);
		Assert.notNull(res);
		return res;
	}

}
