package UI;

import Domain.Patient;
import Repository.DuplicateEntityException;
import Service.PatientService;

import java.util.Collection;
import java.util.Scanner;

public class Console {
    PatientService patientService;
    Scanner scanner = new Scanner(System.in);

    public Console(PatientService patientService)
    {
        this.patientService = patientService;
    }

    public void runMenu()
    {
        while (true)
        {
            printMenu();
            String option = scanner.nextLine();
            switch (option)
            {
                case "1": {
                    try {
                        System.out.println("Give id: ");
                        int id = scanner.nextInt();
                        System.out.println("Give name: ");
                        String name = scanner.next();
                        System.out.println("Give age: ");
                        int age = scanner.nextInt();

                        patientService.addPatient(id, name, age);
                    }
                    catch (DuplicateEntityException ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    catch (Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }

                    break;
                }
                case "p": {
                    Collection<Patient> patients = patientService.getAll();
                    for (Patient p: patients)
                    {
                        System.out.println(p);
                    }
                    break;
                }
                case "x": {
                    return;
                }
                default: {
                    System.out.println("Wrong option! Try again.");
                }
            }
        }
    }

    private void printMenu()
    {
        System.out.println("1. Add patient");
        System.out.println("p. Show all patients");
        System.out.println("x. Exit");
    }
}
