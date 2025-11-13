package delft;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;
import java.util.stream.*;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.*;
import static delft.Field.*;
import static delft.Property.*;
import static delft.SportsHallPlanner.planHalls;

class SportsHallPlannerTests {

    private List<Request> requests;
    private List<SportsHall> sportsHalls;

    private Set<Property> properties_request_1= Set.of(NEAR_CITY_CENTRE, CLOSE_PUBLIC_TRANSPORT);
    private Request request_1= new Request(properties_request_1, TENNIS,1);
    private Set<Property> properties_request_2= Set.of(NEAR_CITY_CENTRE, HAS_RESTAURANT);
    private Request request_2= new Request(properties_request_2, BADMINTON,2);

    private Set<Property> properties_sporthall_1=Set.of(NEAR_CITY_CENTRE, CLOSE_PUBLIC_TRANSPORT);
    private Map fields_sporthall_1= Set.of(TENNIS,BASKETBALL);
    private SportsHall sportsHall_1 = new SportsHall(properties_request_1,);

    @BeforeEach
    void setUp() {
        requests = new ArrayList<>();
        sportsHalls = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {}



}
