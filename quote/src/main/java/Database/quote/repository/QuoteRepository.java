package Database.quote.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public class QuoteRepository extends JpaRepositoriesAutoConfiguration<Quote> {

}
