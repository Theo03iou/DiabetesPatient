import java.util.Scanner;

class patient {
    String patientName = null;
    boolean diabetes = false;
    int regiment = 0;
}

public class Testprep6 {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        System.out.println("How many patients' details do you want to enter? MUST BE 300 or less");
        Scanner scanner = new Scanner(System.in);
        int numPatients = scanner.nextInt();

        if (numPatients <= 300) {
            askPatients(numPatients);
        } else {
            start();
        }
    }

    private static void askPatients(int numPatients) {
        patient[] newPatient = new patient[numPatients];
        for (int i = 0; i < numPatients; i++) {
            System.out.println("Enter the name of the patient, or enter 'XXX' to exit");
            Scanner scanner = new Scanner(System.in);
            String userName = scanner.nextLine();
            newPatient[i] = new patient();

            setName(userName, newPatient, i);
            System.out.println(newPatient[i].patientName);
        }

        nextStage(newPatient, numPatients);
    }

    private static void nextStage(patient[] newPatient, int numPatients) {
        for (int i = 0; i < numPatients; i++) {
            System.out.println("Choose from the following options:");
            System.out.println("[1]: Exit the program");
            System.out.println("[2]: Input further details");
            System.out.println("[3]: Print out full details");

            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();

            if (userChoice == 3) {
                String pName = getName(newPatient, i);
                boolean gDiabetes = getDiabetes(newPatient, i);
                int gRegiment = getRegiment(newPatient, i);
                
            } else if (userChoice == 2) {
                furtherDetails(newPatient, numPatients);
            }
            else {
                System.exit(0);
            }

        }
    }

    private static void furtherDetails(patient[] newPatient, int numPatients) {
    }

    private static void setName(String userName, patient[] newPatient, int i) {
        newPatient[i].patientName = userName;
    }
}
