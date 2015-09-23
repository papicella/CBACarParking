package pas.au.ibm.ctp.cba.parking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pas.au.ibm.ctp.cba.parking.domain.ParkingLocations;
import pas.au.ibm.ctp.cba.parking.domain.ParkingUsers;
import pas.au.ibm.ctp.cba.parking.domain.TicketEvents;
import pas.au.ibm.ctp.cba.parking.repository.LocationsRepository;
import pas.au.ibm.ctp.cba.parking.repository.TicketEventsRepository;
import pas.au.ibm.ctp.cba.parking.repository.UsersRepository;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController
{
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    LocationsRepository locationsRepository;

    @Autowired
    TicketEventsRepository ticketEventsRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model, HttpSession session)
    {
        return "login";
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String book(Model model, HttpSession session)
    {
        RestTemplate restTemplate = new RestTemplate();

        ParkingUsers user = (ParkingUsers) session.getAttribute("user");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String url = String.format("http://pas-telstrasmsapi.mybluemix.net/telstrasms?to=%s&body=%s",
                                   user.getMobileno(), "Parking confirmed, enjoy the event from the CBA Parking Application");

        String response = restTemplate.postForObject(url, headers, String.class);

        logger.info("HTTP POST sent");

        model.addAttribute("actionStr", "Sent message to your mobile number " + user.getMobileno());

        return "confirmation";
    }

    @RequestMapping(value = "/parkinglocations", method = RequestMethod.GET)
    public String parkingLocations(Model model, HttpSession session)
    {
        List<ParkingLocations> parkingLocations = locationsRepository.findAll();

        model.addAttribute("parkingLocations", parkingLocations);
        model.addAttribute("parkingLocationsCount", parkingLocations.size());
        model.addAttribute("userid", (String) session.getAttribute("userid"));

        return "parkingeventdetails";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginForm
            (@RequestParam(value="userid", required = true) String userid,
             @RequestParam(value="ticketno", required = true) String password,
             Model model,
             HttpSession session)
    {

        // login using userid / password
        ParkingUsers user = usersRepository.findByLogin(userid);

        List<TicketEvents> ticketEvents = ticketEventsRepository.findByUserid(user.getId());

        model.addAttribute("ticketEvents", ticketEvents);
        model.addAttribute("ticketEventsCount", ticketEvents.size());
        model.addAttribute("userid", userid);

        session.setAttribute("userid", userid);
        session.setAttribute("user", user);

        return "events";
    }

    @RequestMapping(value="/survey", method = RequestMethod.POST)
    public String surveyForm
            (@RequestParam(value="helpful", required = true) String helpful,
             @RequestParam(value="use", required = true) String use,
             @RequestParam(value="again", required = true) String again,
             Model model,
             HttpSession session)
    {
        return "login";
    }
}
