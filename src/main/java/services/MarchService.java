
package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.MarchRepository;
import security.Authority;
import domain.Actor;
import domain.March;

@Service
@Transactional
public class MarchService {

	@Autowired
	private MarchRepository	marchRepository;
	@Autowired
	private ActorService	actorService;


	public March create() {

		final March res = new March();

		final Actor actor = this.actorService.getPrincipal();
		final Collection<Authority> autorities = actor.getUserAccount().getAuthorities();
		final ArrayList<String> listAuth = new ArrayList<String>();

		if (!autorities.isEmpty())
			for (final Authority au : autorities)
				listAuth.add(au.getAuthority());

		Assert.isTrue(listAuth.contains("MEMBER"));

		return res;
	}
	public Collection<March> findAll() {
		Collection<March> res;
		res = this.marchRepository.findAll();
		Assert.notNull(res);
		return res;
	}

	public March findOne(final Integer marchId) {
		March res;
		Assert.notNull(marchId);
		res = this.marchRepository.findOne(marchId);
		Assert.notNull(res);
		return res;
	}

	public void delete(final March march) {
		Assert.notNull(march);

		final Actor actor = this.actorService.getPrincipal();
		final Collection<Authority> autorities = actor.getUserAccount().getAuthorities();
		final ArrayList<String> listAuth = new ArrayList<String>();

		if (!autorities.isEmpty())
			for (final Authority au : autorities)
				listAuth.add(au.getAuthority());

		Assert.isTrue(listAuth.contains("MEMBER"));
		this.marchRepository.delete(march);
	}
}
