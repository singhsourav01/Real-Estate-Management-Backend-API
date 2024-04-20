package com.example.ExcleRBackEndCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
 interface BrokerRepository extends JpaRepository<Broker, Long> {

	Optional<Broker> findByEmail(String email);
	Optional<Broker> findById(Long broker_id);
}

@Repository
interface PropertyRepository extends JpaRepository<Property, Long> {
	Optional<Property> findById(Long prop_id);

	List<Property> findByBrokerId(Long id);

	List<Property> findByType(String type);
}

@Repository
 interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

@Repository
interface user_statusRepository extends JpaRepository<user_status, Long> {

	List<user_status> findByBrokerId(Long brokerId);
}

@Repository
interface AdminRepository extends JpaRepository<Admin, Long> {

	Optional<Admin> findByEmail(String email);
	Optional<Admin> findById(Long id);
}