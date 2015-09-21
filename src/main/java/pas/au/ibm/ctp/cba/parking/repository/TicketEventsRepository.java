package pas.au.ibm.ctp.cba.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pas.au.ibm.ctp.cba.parking.domain.TicketEvents;

import java.util.List;

/**
 * Created by pasapicella on 20/09/15.
 */
public interface TicketEventsRepository extends JpaRepository<TicketEvents, Long>
{
    @Query("select a from TicketEvents a where a.userId = ?1")
    List<TicketEvents> findByUserid(Long userId);
}
