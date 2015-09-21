package pas.au.ibm.ctp.cba.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pas.au.ibm.ctp.cba.parking.domain.ParkingUsers;

public interface UsersRepository extends JpaRepository<ParkingUsers, Long>
{
    @Query("select a from ParkingUsers a where a.email = ?1 and a.accPassword = ?2")
    ParkingUsers findByLogin(String userId, String password);
}
