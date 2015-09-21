package pas.au.ibm.ctp.cba.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pas.au.ibm.ctp.cba.parking.domain.ParkingLocations;

public interface LocationsRepository extends JpaRepository<ParkingLocations, Long>
{
}
