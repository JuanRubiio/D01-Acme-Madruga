
package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

	//	@Query("select avg(c.fixUpTasks.size),min(c.fixUpTasks.size),max(c.fixUpTasks.size),stddev(c.fixUpTasks.size) from Customer c")
	//	List<Object> query1();
	//
	//	@Query("select avg(fut.applications.size),min(fut.applications.size),max(fut.applications.size),stddev(fut.applications.size) from FixUpTask fut")
	//	List<Object> query2();
	//
	//	@Query("select min(f.maxPrice),avg(f.maxPrice), stddev(f.maxPrice),max(f.maxPrice)from FixUpTask f")
	//	List<Object> query3();
	//
	//	@Query("select min(a.price),avg(a.price), stddev(a.price),max(a.price)from Application a")
	//	List<Object> query4();
	//
	//	@Query("select sum(case when a.status='PENDING' then 1.00 else 0.00 end)/count(a)*1.0 from Application a")
	//	Double query5();
	//
	//	@Query("select sum(case when a.status='ACCEPTED' then 1.00 else 0.00 end)/count(a)*1.0 from Application a")
	//	Double query6();
	//
	//	@Query("select sum(case when a.status='REJECTED' then 1.00 else 0.00 end)/count(a)*1.0 from Application a")
	//	Double query7();
	//
	//	@Query("select 1.0*count(a)/(select count(a) from Application a) from Application a join a.fixUpTask f where a.status = 'PENDING' and a.moment > f.maxDate")
	//	Double query8();

	@Query("select min(f.maxPrice),avg(f.maxPrice), stddev(f.maxPrice),max(f.maxPrice)from Brotherhood f")
	List<Object> query1();

	@Query("select f from Brotherhood f where max(f.enrolment.size)")
	Object query2();

	@Query("select f from Brotherhood f where min(f.enrolment.size)")
	List<Object> query3();

	@Query("select sum(a.status = 'PENDING'), sum(a.status = 'REJECTED'), sum(a.status = 'APPROVED') from March a")
	List<Object> query4();

	@Query("select f from Procession f where f.moment between CURRENT_DATE and CURRENT_DATE + 30")
	List<Object> query5();

	@Query("select a from Procession a where a.moment.month = 2")
	Object query6();

	@Query("select count(r.march)/(select count(a.march) from Member a where a.march.status = 'APPROVED')*1.0 from Member r")
	Double query7();

}
