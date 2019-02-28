
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
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

}
