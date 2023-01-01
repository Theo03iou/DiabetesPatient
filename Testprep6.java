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
            System.out.println("[3]: Print out full details of every patient");

            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();

            if (userChoice == 2) {
                furtherDetails(newPatient, numPatients, i);
                
            } else if (userChoice == 3) {

                for (int j = 0; j < numPatients; j++) {
                     String pName = getName(newPatient, j);
                     boolean gDiabetes = getDiabetes(newPatient, j);
                     int gRegiment = getRegiment(newPatient, j);

                    System.out.println(pName);
                    System.out.println(gDiabetes);
                    System.out.println(gRegiment);
                }  

                System.exit(0);            }
            else {
                System.exit(0);
            }

        }
    }

    private static void furtherDetails(patient[] newPatient, int numPatients, int i) {
        System.out.println("Please enter the name of the patient:");
        Scanner scanner = new Scanner(System.in);
        String pName = scanner.nextLine();
        setName(pName, newPatient, i);

        System.out.println("Do they have diabetes? (Enter true or false)");
        boolean pDiabetes = scanner.nextBoolean();
        if (pDiabetes == true) {
            setDiabetes(newPatient, true, i);
        }
        
        System.out.println("What improvement regime are they on? \n[1]: Diet\n[2]: Exercise\n[3]: Drugs");
        int pRegiment = scanner.nextInt();
        setRegime(newPatient, pRegiment, i);
    }


    private static void setName(String userName, patient[] newPatient, int i) {
        newPatient[i].patientName = userName;
    }

    private static void setRegime(patient[] newPatient, int pRegiment, int i) {
        newPatient[i].regiment = pRegiment; 
    }

    private static void setDiabetes(patient[] newPatient, boolean b, int i) {
        newPatient[i].diabetes = b;
    }

    private static int getRegiment(patient[] newPatient, int i) {
        return newPatient[i].regiment;
    }

    private static boolean getDiabetes(patient[] newPatient, int i) {
        return newPatient[i].diabetes;
    }

    private static String getName(patient[] newPatient, int i) {
        return newPatient[i].patientName;
    }
    
}
