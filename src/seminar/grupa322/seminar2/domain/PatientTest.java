package seminar.grupa322.seminar2.domain;

// Stefanescu Stefan


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PatientTest {
    private Patient patient;

    @BeforeEach
    void setUp() {
        patient = new Patient(1, "Coco", 12);
    }

    @Test
    void setName() {
        patient.setName("Coco Rico");
        assert ("Coco Rico".equals(patient.getName()));
    }

    @Test
    void getName() {
        assert ("Coco".equals(patient.getName()));
    }

    @Test
    void setAge() {
        patient.setAge(30);
        assert (patient.getAge() == 30);
    }
}
