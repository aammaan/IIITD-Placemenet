package oop;

import java.util.Scanner;

public class PlacementCell {
    static Scanner input = new Scanner(System.in);
    static String StudentOpen;
    static String StudentClose;
    static String CompanyOpen;
    static String CompanyClose;
    static public String print(){
        return "\u001B[31m"+"Welcome IIITD Placement Cell\n" +
                "1) Open Student Registrations\n" +
                "2) Open Company Registrations\n" +
                "3) Get Number of Student Registrations\n" +
                "4) Get Number of Company Registrations\n" +
                "5) Get Number of Offered/Unoffered/Blocked Students\n" +
                "6) Get Student Details\n" +
                "7) Get Company Details\n" +
                "8) Get Average Package\n" +
                "9) Get Company Process Results\n" +
                "10) Back\n"+"\u001B[0m";
    }
    static public void OpenStudentRegi(){
        System.out.println("\u001B[36m"+"Fill in the details:-\n" +
                "1) Set the Opening time for Student registrations\n" +
                "2) Set the Ending time for Student registrations.");
        StudentOpen = input.next();
        StudentClose = input.next();
    }
    static public void OpenCompanyRegi(){
        System.out.println("Fill in the details:-\n" +
                "1) Set the Opening time for Company registrations\n" +
                "2) Set the Ending time for Company registrations."+"\u001B[0m");
        CompanyOpen = input.next();
        CompanyClose = input.next();
    }
    static public void getregisteredstudent(){
        System.out.println(Storeroom.registeredstudents);
    }

    static public void getregisteredcompany(){
        System.out.println(Storeroom.registeredcompanies);
    }
    static public void updatecgpa(int roll, double oldcgpa , double newcgpa){
         int i=Storeroom.searchstudent(roll );
        if(Storeroom.listofstudents.get(i).cgpa == oldcgpa) {
            Storeroom.listofstudents.get(i).cgpa = newcgpa;
            System.out.println("CGPA UPDATED!!");
        }else{
            System.out.println("OLD CGPA DOESN'T MATCH");
        }
    }
    static public void getstudentdetails(int roll){
        int u=Storeroom.searchstudent(roll);
        for(int i=0;i<Student.appliedCompany.size();i++){
            System.out.println(Storeroom.listofstudents.get(u).name+" have applied in following companies: ");
            System.out.println(i+1+") "+Storeroom.listofstudents.get(u).appliedCompany.get(i).name);
        }
        if(Storeroom.listofstudents.get(u).company!=""){
            System.out.println(Storeroom.listofstudents.get(u).name+" has accepted a placement in "+Storeroom.listofstudents.get(u).company);
        }
    }
    static public void getcompanydetails(String company){
        int uu=Storeroom.searchcompany(company);
        for(int i=0;i<Company.offeredStudent.size();i++){
            System.out.println(company+" has offered placement to following students: ");
            System.out.println(i+1+") "+Storeroom.listofcompany.get(uu).offeredStudent.get(i).name+"  "+Storeroom.listofcompany.get(uu).offeredStudent.get(i).roll);
        }
    }
    static public void average(){
        int y=0;
        for(int i=0;i<Storeroom.listofcompany.size();i++){
            y+=Storeroom.listofcompany.get(i).ctc;
        }
        System.out.println(y/Storeroom.listofcompany.size());
    }

}
