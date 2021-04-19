package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import transport.co.api.model.Address;
import transport.co.api.model.Person;

@NoRepositoryBean
public interface PersonRepository<T extends Person, Long> extends JpaRepository<T,Long> {
}
