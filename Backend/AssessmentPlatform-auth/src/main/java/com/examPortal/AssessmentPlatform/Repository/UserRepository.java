package com.examPortal.AssessmentPlatform.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examPortal.AssessmentPlatform.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> findAll();

	@Query(value = "select * from users where username= ? ", nativeQuery = true)
	public User findByUsername(String username);

}
