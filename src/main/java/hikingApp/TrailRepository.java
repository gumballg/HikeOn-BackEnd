package hikingApp;

import org.springframework.data.repository.CrudRepository;

public interface TrailRepository extends CrudRepository<Trail, Long> {
    Iterable<Trail>  findByUser(User user);
}
