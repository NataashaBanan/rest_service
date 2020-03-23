package my_code.rest_service.interfaces;

import my_code.rest_service.controller.Girl;
import org.springframework.data.repository.CrudRepository;

public interface GirlRepo extends CrudRepository<Girl, Integer> {
}
