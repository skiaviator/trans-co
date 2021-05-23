package transport.co.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transport.co.api.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    AppUser findByUsername(String username);
}
