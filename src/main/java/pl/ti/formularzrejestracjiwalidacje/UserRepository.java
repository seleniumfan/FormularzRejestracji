package pl.ti.formularzrejestracjiwalidacje;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
