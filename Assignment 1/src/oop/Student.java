package oop;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {
    static Scanner input = new Scanner(System.in);
    static public String name;
    static public int roll;
    static public double cgpa;
    static public String branch;
    static public String status;
    static public int ctc =0;
    static public String company="";
    static public int Accept=0;
    static public int offer=0;

    static List<Company> appliedCompany = new ArrayList<Company>();

    public Student(String name, int roll, double cgpa, String branch) {
        this.name = name;
        this.roll = roll;
        this.cgpa = cgpa;
        this.branch = branch;
    }
    static public String print() {
        return "\u001B[36m" + "Choose the Student Query to perform-\n" +
                "1) Enter as a Student(Give Student Name, and Roll No.)\n" +
                "2) Add students\n" +
                "3) Back" + "\u001B[0m";
    }
    static public void driveregister(Student s){
        Storeroom.drivestudent.add(s);
        System.out.println("You are successfully registered to drive!!");
    }
    static public void Addstudentstudent(){
        System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
        System.out.println("NAME:");
        String name1 = input.next();
        System.out.println("ROLL NO:");
        int roll1 = input.nextInt();
        System.out.println("CGPA");
        double cgpa1 = input.nextDouble();
        System.out.println("BRANCH:");
        String branch1 = input.next();

        Student student1 = new Student(name1,roll1,cgpa1,branch1);
        Storeroom.listofstudents.add(student1);
        Storeroom.registeredstudents++;
        student1.status = "not-applied";

    }
    static public int checkEligibility(String name,int roll,String company){
        int checkpresence=0;
        int checkstatus=0;
        int i=Storeroom.searchstudent(roll);


        int k=Storeroom.searchcompany(company);
        if (Storeroom.listofstudents.get(i).Accept==1 ){
            if(3*(Storeroom.listofstudents.get(i).ctc) >= Storeroom.listofcompany.get(k).ctc) {
                return 1;
            }
            }else {
                System.out.println("Student has already accepted any offer");
                return 0;

        }
        if(Storeroom.listofstudents.get(i).name != name || Storeroom.listofstudents.get(i).roll != roll ){
                System.out.println("Either NAME or ROLL NO not matched");
                return 0;
        } else if(Storeroom.listofstudents.get(i).cgpa < Storeroom.listofcompany.get(k).cgpa){
            System.out.println("CGPA is less then "+Storeroom.listofcompany.get(k).cgpa);
            return 0;
        } else if(Storeroom.listofstudents.get(i).status == "blocked"){
            System.out.println("Student is Blocked.");
            return 0;
        }

        return 1;
    }
    static public void registerforcompany(int roll, String company){
        int k=Storeroom.searchstudent(roll);
        int kk=Storeroom.searchcompany(company);
        Storeroom.listofstudents.get(k).status = "applied";
        Company.appliedStudent.add(Storeroom.listofstudents.get(k));
        Storeroom.listofstudents.get(k).appliedCompany.add(Storeroom.listofcompany.get(kk));
        System.out.println("Successfully Registered for"+Storeroom.listofcompany.get(kk).role+" Role at "+Storeroom.listofcompany.get(kk).name);
    }
    static public void allavailablecompanies(String name,int roll){
        int check=0;
        for(int j=0;j<Storeroom.listofcompany.size();j++) {
            if(checkEligibility(name,roll,Storeroom.listofcompany.get(j).name) == 1){
                System.out.println("COMPANY NAME: " + Storeroom.listofcompany.get(j).name);
                System.out.println(" COMPANY ROLE OFFERING: " + Storeroom.listofcompany.get(j).role);
                System.out.println("COMPANY CTC: " + Storeroom.listofcompany.get(j).ctc);
                System.out.println("COMPANY CGPA CRITERIA: " + Storeroom.listofcompany.get(j).cgpa);
                check=1;

            }
        }
        if(check==0){
            System.out.println("UNAVAILABLE");
        }
    }
    static public void getcurrentstatus(int roll){
        int de=Storeroom.searchstudent(roll);
        System.out.println(Storeroom.listofstudents.get(de).status);
        if(Storeroom.listofstudents.get(de).status == "offered"){
            System.out.println("Student got offered from: ");
            for(int i=0;i< Storeroom.listofcompany.size();i++){
                if(Arrays.asList(Storeroom.listofcompany.get(i).offeredStudent).contains(Storeroom.listofstudents.get(de))){
                    System.out.println("COMPANY NAME: " + Storeroom.listofcompany.get(i).name);
                    System.out.println(" ROLE: " + Storeroom.listofcompany.get(i).role);
                    System.out.println("CTC: " + Storeroom.listofcompany.get(i).ctc);
                    System.out.println("CGPA: " + Storeroom.listofcompany.get(i).cgpa);


                }
            }
        }
    }
    static public void requestupdatecgpa(int roll, double old, double naw      ){
        PlacementCell.updatecgpa(roll, old, naw);
    }
    static public void accept(int roll, String companyname){
        int s=Storeroom.searchstudent(roll);
        int c=Storeroom.searchcompany(companyname);
        Storeroom.listofstudents.get(s).Accept=1;
        Storeroom.listofcompany.get(c).acceptedStudent.add(Storeroom.listofstudents.get(s));
        System.out.println("Congrats!! You have accepted the offer by"+companyname+"!!");

    }

}

