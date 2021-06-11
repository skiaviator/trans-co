package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import transport.co.api.model.Person;

@NoRepositoryBean
public interface PersonRepository<T extends Person, Long> extends JpaRepository<T,Long> {
}
