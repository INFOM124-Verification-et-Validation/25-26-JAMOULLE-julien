package delft;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.within;
import java.time.temporal.ChronoUnit;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.time.*;

// On aurait pu mettre plus d'information en haut pour avoir des test plus clean en pratique par exemple les etudiant
// que j'utilise dans mes tests
class AutoAssignerTest {

    private ZonedDateTime date(int year, int month, int day, int hour, int minute) {
        return ZonedDateTime.of(year, month, day, hour, minute, 0, 0, ZoneId.systemDefault());
    }

    private AutoAssigner autoAsigner;
    private ArrayList<Student> listStudent;
    private ArrayList<Workshop> listWorkshop;

    @BeforeEach
    void setUp() {
        autoAsigner= new AutoAssigner();
        listStudent= new ArrayList<>();
        listWorkshop= new ArrayList<>();
    }

    @AfterEach
    void tearDown() {}


    //Test Student
    @Test
    void testgetemail(){

        //Arrange
        Student student= new Student(10,"Jamoulle","julien.jamoulle@gmail.com");

        //Act
        String email= student.getEmail();

        //Assert
        assertThat(email).isEqualTo("julien.jamoulle@gmail.com");

    }


    @Test
    void testgetid(){

        //Arrange
        Student student= new Student(10,"Jamoulle","julien.jamoulle@gmail.com");

        //Act
        Integer id= student.getId();

        //Assert
        assertThat(id).isEqualTo(10);

    }

    @Test
    void testequals(){

        //Arrange
        Student student_1= new Student(10,"Jamoulle","julien.jamoulle@gmail.com");
        Student student_2= new Student(10,"Jamoulle","julien.jamoulle@gmail.com");

        //Assert
        assert student_1.equals(student_2);
        assert student_2.equals(student_1);

    }


    @Test
    void testHashcode(){
        //Arrange
        Student student= new Student(10,"Jamoulle","julien.jamoulle@gmail.com");

        //Assert
        assert  student.hashCode() == Objects.hash(10,"Jamoulle", "julien.jamoulle@gmail.com");

    }

    // Class Workshop

    @Test
    void testworkshopgetter(){

        //Arrange
        Map<ZonedDateTime,Integer> MathSchedule = new HashMap<>();
        Workshop workshop=new Workshop(12,"Math",MathSchedule);

        //Assert
        assert workshop.getName()=="Math";
        assert workshop.getId()==12;
        assert workshop.getSpotsPerDate().equals(MathSchedule);
        assert workshop.hashCode()==Objects.hash(workshop.getName(),workshop.getId(),MathSchedule);


    }



    // Test autoAssigner
    @Test
    void testSingleStudentSingleDatavailable() {

        //Arrange

        Map<ZonedDateTime,Integer> MathSchedule = new HashMap<>();
        MathSchedule.put(date(2025,11,4,9,2),2);
        Student student= new Student(10,"Jamoulle","julien.jamoulle@gmail.com");
        Workshop workshop=new Workshop(12,"Math",MathSchedule);


        listStudent.add(student);
        listWorkshop.add(workshop);

        //Act
        AssignmentsLogger assignmentsLogger= autoAsigner.assign(listStudent,listWorkshop);
        List<String> assignments= assignmentsLogger.getAssignments();

        //Assert
        assertThat(assignments).isNotEmpty();
         assertThat(assignments).containsExactlyInAnyOrder("Math,Jamoulle,04/11/2025 09:02");

    }

    @Test
    void testMutipleStudentOneDatavailable() {

        //Arrange
        Map<ZonedDateTime,Integer> MathSchedule = new HashMap<>();
        MathSchedule.put(date(2025,11,4,9,2),1);
        Student student_1= new Student(10,"Jamoulle","julien.jamoulle@gmail.com");
        Student student_2= new Student(11,"Busoni","thomas.busoni@gmail.com");
        Workshop workshop=new Workshop(12,"Math",MathSchedule);


        listStudent.add(student_1);
        listStudent.add(student_2);
        listWorkshop.add(workshop);

        //Act
        AssignmentsLogger assignmentsLogger= autoAsigner.assign(listStudent,listWorkshop);
        List<String> assignments= assignmentsLogger.getAssignments();
        List<String> errors= assignmentsLogger.getErrors();

        //Assert
        assertThat(assignments).isNotEmpty();
        assertThat(assignments).containsExactlyInAnyOrder("Math,Jamoulle,04/11/2025 09:02");
        assertThat(errors).isNotEmpty();
        assertThat(errors).containsExactlyInAnyOrder("Math,Busoni");


    }

}
