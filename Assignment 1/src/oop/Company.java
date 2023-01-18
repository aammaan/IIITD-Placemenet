package oop;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Company {
    static String name;
    static String role;
    static int ctc;
    static double cgpa;
    static List<Student> appliedStudent = new ArrayList<Student>();
    static List<Student> offeredStudent = new ArrayList<Student>();


    static List<Student> acceptedStudent = new ArrayList<Student>();
    static String time;
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date = new Date();



    public Company(String name, String role, int ctc, double cgpa) {
        this.name = name;
        this.role = role;
        this.ctc = ctc;
        this.cgpa = cgpa;
    }

    static Scanner input = new Scanner(System.in);
    static public String print() {
        return "\u001B[36m" + "Choose the Company Query to perform-\n" +
                "1) Add Company and Details name\n" +
                "2) Choose Company\n" +
                "3) Get Available Companies\n" +
                "4) Get Selected students\n"+
                "5) Back" + "\u001B[0m";

    }
     static public void AddCompany(){
        System.out.println("Please add company NAME,ROLE,CTC, CGPA,(in order):");
        System.out.println("NAME:");
        String name1 = input.nextLine();
        System.out.println("ROLE:");
        String role1 = input.next();
        System.out.println("CTC");
        int ctc1 = input.nextInt();
        System.out.println("CGPA:");
        double cgpa1 = input.nextDouble();
        Company company1 = new Company(name1,role1,ctc1,cgpa1);
        Storeroom.listofcompany.add(company1);
        Storeroom.registeredcompanies++;
    }
    static public void getselectedstudent(){
        int cj=0;
        for(int i=0;i<offeredStudent.size();i++){

            System.out.println(i+1 + ") NAME: " + offeredStudent.get(i).name);
            System.out.println("   ROLL NO: " + offeredStudent.get(i).roll);
            cj=1;
        }
        if(cj==0){
            System.out.println("No student is selected ");
        }
    }
    static public void ChooseCompany(){
        for(int i=0;i< Storeroom.listofcompany.size();i++){
            System.out.println(i+1+") "+Storeroom.listofcompany.get(i).name);
        }
        System.out.println("Choose the number of company: ");
        int welcome = input.nextInt();

        while  (true){
            System.out.println("\u001B[34m" + "Welcome " + Storeroom.listofcompany.get(welcome-1).name);
            System.out.println("1) Update Role\n" +
                    "2) Update Package\n" +
                    "3) Update CGPA criteria\n" +
                    "4) Register To Institute Drive\n" +
                    "5) Back" + "\u001B[0m");
            int first = input.nextInt();
            if(first ==1){
                String role = input.next();
                Storeroom.listofcompany.get(welcome-1).role=role;
            } else if(first == 2){
                int pack = input.nextInt();
                Storeroom.listofcompany.get(welcome-1).ctc=pack;
            }else if( first == 3){
                double cgpa = input.nextDouble();
                Storeroom.listofcompany.get(welcome-1).cgpa=cgpa;
            } else if (first ==  4){
                Storeroom.drivecompany.add(Storeroom.listofcompany.get(welcome-1));
                Storeroom.listofcompany.get(welcome-1).time=formatter.format(date);
                System.out.println(formatter.format(date));
                System.out.println("Registered!!");
            }else if(first == 5){
                break;
            }
        }
    }
    static public void GetAvailableCompany(){
        for(int i=0;i<Storeroom.listofcompany.size();i++){
            System.out.println(i+1 + ") " +Storeroom.listofcompany.get(i).name);
        }
    }

}

