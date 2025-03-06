package sh.jfm.upgradeexample;

import org.springframework.data.repository.ListCrudRepository;

/**
 * CrudRepositories can now return List instead of iterators, which simplifies usage.
 * <p>
 * See <a href="https://spring.io/blog/2022/02/22/announcing-listcrudrepository-friends-for-spring-data-3-0#repositories-returning-lists">
 * Announcing ListCrudRepository</a> for more details.
 */
public interface DBMessageRepository extends ListCrudRepository<DBMessage, Long> {
}
