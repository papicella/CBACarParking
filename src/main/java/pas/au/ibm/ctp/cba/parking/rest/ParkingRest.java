package pas.au.ibm.ctp.cba.parking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pas.au.ibm.ctp.cba.parking.domain.ParkingLocations;
import pas.au.ibm.ctp.cba.parking.domain.ParkingUsers;
import pas.au.ibm.ctp.cba.parking.domain.TicketEvents;
import pas.au.ibm.ctp.cba.parking.repository.LocationsRepository;
import pas.au.ibm.ctp.cba.parking.repository.TicketEventsRepository;
import pas.au.ibm.ctp.cba.parking.repository.UsersRepository;

import java.util.List;

@RestController
public class ParkingRest
{
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    LocationsRepository locationsRepository;

    @Autowired
    TicketEventsRepository ticketEventsRepository;

    @RequestMapping("/alllocations")
    public List<ParkingLocations> parkingLocations()
    {
        return locationsRepository.findAll();
    }

    @RequestMapping("/allusers")
    public List<ParkingUsers> parkingUsers()
    {
        return usersRepository.findAll();
    }

    @RequestMapping("/allticketevents")
    public List<TicketEvents> ticketEvents()
    {
        return ticketEventsRepository.findAll();
    }
}
