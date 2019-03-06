
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.BrotherhoodRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Brotherhood;
import domain.Enrolment;

@Service
@Transactional
public class BrotherhoodService {

	// Managed Repository ----------------------------------------------------

	@Autowired
	private BrotherhoodRepository	brotherhoodRepository;

	// Supporting services ----------------------------------------------------

	@Autowired
	private AreaService				areaService;


	// Constructor ----------------------------------------------------

	public BrotherhoodService() {
		super();
	}

	public Brotherhood register(final RegisterBrotherhoodForm registerBrotherhoodForm) {
		final Brotherhood result = this.create();

		final UserAccount userAccount = new UserAccount();
		final String password = registerBrotherhoodForm.getPassword();
		final Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		final String hashedPassword = encoder.encodePassword(password, null);
		Assert.isTrue(registerBrotherhoodForm.getPassword().equals(registerBrotherhoodForm.getPassword2()));
		userAccount.setPassword(hashedPassword);
		userAccount.setUsername(registerBrotherhoodForm.getUsername());
		userAccount.setAccountNonLocked(true);

		//Seteo los atributos al resultado
		final Authority authority = new Authority();
		authority.setAuthority(Authority.BROTHERHOOD);
		final List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(authority);
		userAccount.setAuthorities(authorities);

		result.setUserAccount(userAccount);
		result.setAddress(registerBrotherhoodForm.getAddress());
		result.setMiddleName(registerBrotherhoodForm.getMiddleName());
		result.setEmail(registerBrotherhoodForm.getEmail());
		result.setName(registerBrotherhoodForm.getName());
		result.setPhone(registerBrotherhoodForm.getPhone());
		result.setPhoto(registerBrotherhoodForm.getPhoto());
		result.setSurname(registerBrotherhoodForm.getSurname());
		result.setTitle(registerBrotherhoodForm.getTitle());
		result.setEstablishment(registerBrotherhoodForm.getEstablishment());

		this.save(result);

		return result;
	}

	public Brotherhood create() {
		Brotherhood res;

		res = new Brotherhood();

		res.setArea(this.areaService.findByName("defaultArea").iterator().next());

		res.setEnrolments(new HashSet<Enrolment>());
		res.setFloats(new HashSet<Float>());
		res.setProcessions(new HashSet<Procession>());
		res.setEstablishmentDate(new Date());
		res.setPhotos(new HashSet<String>());

		return res;

	}

	public Brotherhood save(final Brotherhood brotherhood) {
		Assert.notNull(brotherhood);
		Brotherhood result;
		result = this.brotherhoodRepository.save(brotherhood);
		this.brotherhoodRepository.flush();
		return result;
	}

	public void delete(final Brotherhood brotherhood) {
		Assert.notNull(brotherhood);
		Assert.isTrue(brotherhood.getId() != 0);
		Assert.isTrue(this.brotherhoodRepository.exists(brotherhood.getId()));
		final int id = LoginService.getPrincipal().getId();
		final int memberid = brotherhood.getId();
		Assert.isTrue(id == memberid || LoginService.getPrincipal().getAuthorities().contains(Authority.ADMIN));

		this.brotherhoodRepository.delete(brotherhood);
	}

	public Collection<Brotherhood> findAll() {
		Collection<Brotherhood> result;

		result = this.brotherhoodRepository.findAll();

		return result;
	}

	public Brotherhood findOne(final int brotherhoodId) {
		Brotherhood result;

		result = this.brotherhoodRepository.findOne(brotherhoodId);
		Assert.notNull(result);

		return result;
	}

	public void flush() {
		this.brotherhoodRepository.flush();
	}

	//Other Business Methods

	public Brotherhood findByPrincipal() {
		Brotherhood result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = this.findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Brotherhood findByUserAccount(final UserAccount userAccount) {
		Assert.notNull(userAccount);

		Brotherhood result;

		result = this.brotherhoodRepository.findbyUserAccountID(userAccount.getId());

		return result;
	}

	//	public Brotherhood findByRequest(final Request request) {
	//		Assert.notNull(request);
	//		Assert.isTrue(request.getId() != 0);
	//
	//		Brotherhood result;
	//		result = this.brotherhoodRepository.findbyRequestId(request.getId());
	//		Assert.notNull(result);
	//
	//		return result;
	//	}

	//	public Collection<Brotherhood> findByArea(final int areaId) {
	//		Assert.isTrue(areaId != 0);
	//		Collection<Brotherhood> result;
	//
	//		result = this.brotherhoodRepository.findByAreaId(areaId);
	//		Assert.notNull(result);
	//
	//		return result;
	//	}

	public Collection<Brotherhood> findByMember(final int memberId) {
		Assert.isTrue(memberId != 0);
		final Collection<Brotherhood> result;
		result = this.brotherhoodRepository.findByMemberId(memberId);
		Assert.notNull(result);

		return result;
	}

	public Collection<Brotherhood> findByActiveMember(final int memberId) {
		Assert.isTrue(memberId != 0);
		final Collection<Brotherhood> result;
		result = this.brotherhoodRepository.findByActiveMemberId(memberId);
		Assert.notNull(result);

		return result;
	}

	public Collection<Float> brotherhoodFloats(final Brotherhood brotherhood, final Procession procession) {
		final Collection<Float> floats = brotherhood.getFloats();
		final Collection<Float> res = new ArrayList<Float>(floats);
		final Collection<Procession> processions = brotherhood.getProcessions();
		for (final Procession p : processions)
			if (!p.equals(procession))
				res.removeAll(p.getFloats());
		return res;
	}
}
