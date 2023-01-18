import oop.Company;
import oop.PlacementCell;
import oop.Storeroom;
import oop.Student;

import java.awt.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {

            System.out.println("\u001B[32m" + "Welcome to FutureBuilder: \n1) Enter the Application\n2) Exit the Application " + "\u001B[0m");
            Scanner first = new Scanner(System.in);
            int jj=0;
            int pehli = first.nextInt();
            if (pehli == 1) {
                while (true) {
                    System.out.println("\u001B[35m" + "Choose The mode you want to Enter in: \n1) Enter as Student Mode\n2) Enter as Company Mode\n3) Enter as Placement Cell Mode\n4) Return To Main Application" + "\u001B[0m");
                    int second = first.nextInt();

                    if (second == 1) {
                        while (true) {
                            System.out.println(Student.print());
                            int query=first.nextInt();
                            if(query ==1) {
                                System.out.println("Enter the name of the student: ");
                                String name = first.next();
                                System.out.println("Enter the roll no of the student: ");
                                int roll = first.nextInt();
                                int check = 0;
                                int j = Storeroom.searchstudent(roll);
                                jj=j;
                                for (int i = 0; i < Storeroom.listofstudents.size(); i++) {
                                    if (Storeroom.listofstudents.get(i).roll == roll) {
                                        check = 1;
                                    }
                                }
                                if (check == 1) {
                                    while (true) {
                                        System.out.println("Welcome " + Storeroom.listofstudents.get(j).name);
                                        System.out.println("1) Register For Placement Drive\n" +
                                                "2) Register For Company\n" +
                                                "3) Get All available companies\n" +
                                                "4) Get Current Status\n" +
                                                "5) Update CGPA\n" +
                                                "6) Accept offer\n" +
                                                "7) Reject offer\n" +
                                                "8) Back");
                                        int input1 = first.nextInt();
                                        if (input1 == 1) {
                                            Student.driveregister(Storeroom.listofstudents.get(j));
                                        } else if (input1 == 2) {
                                            System.out.println("Enter companies name: ");
                                            String company = first.next();
                                            Student.registerforcompany(roll, company);
                                        } else if (input1 == 3) {
                                            Student.allavailablecompanies(name, roll);
                                        } else if (input1 == 4) {
                                            Student.getcurrentstatus(roll);
                                        } else if (input1 == 5) {
                                            System.out.println("Enter old cgpa");
                                            double old = first.nextDouble();
                                            System.out.println("Enter new cgpa");
                                            double naw = first.nextDouble();
                                            Student.requestupdatecgpa(roll, old, naw);
                                        } else if (input1 == 6) {
                                            System.out.println("Enter the name of the company: ");
                                            String comp = first.next();
                                            Student.accept(roll, comp);
                                        } else if (input1 == 7) {

                                        } else if (input1 == 8) {
                                            break;
                                        }
                                    }
                                } else if(check ==0) {
                                    System.out.println("Student details donot match. ");
                                    break;
                                }
                            }else if(query == 2){
                                System.out.println("Enter the number of students ou want to enter: ");
                                int count=first.nextInt();
                                for(int i=0;i<count;i++) {
                                    Student.Addstudentstudent();
                                }
                            }else if( query == 3){
                                break;
                            }
                        }
                        } else if (second == 2) {
                        while (true) {
                            System.out.println(Company.print());
                            int input2 = first.nextInt();
                            if (input2 == 1) {
                                Company.AddCompany();
                            } else if (input2 == 2) {
                                Company.ChooseCompany();
                            } else if (input2 == 3) {
                                Company.GetAvailableCompany();
                            } else if (input2 == 4) {
                                Company.getselectedstudent();
                            } else if (input2 == 5) {
                                break;
                            }
                        }
                        } else if (second == 3) {
                        while (true) {
                            System.out.println(PlacementCell.print());
                            int input3 = first.nextInt();
                            if (input3 == 1) {
                                PlacementCell.OpenStudentRegi();
                            } else if (input3 == 2) {
                                PlacementCell.OpenCompanyRegi();
                            } else if (input3 == 3) {
                                PlacementCell.getregisteredstudent();
                            } else if (input3 == 4) {
                                PlacementCell.getregisteredcompany();
                            }else if(input3 ==6){
                                System.out.println("Enter the roll no of the student: ");
                                int pp = first.nextInt();
                                PlacementCell.getstudentdetails(pp);
                            }else if(input3 == 7){
                                System.out.println("Enter the name of the company: ");
                                String ii=first.next();
                                PlacementCell.getcompanydetails(ii);
                            }else if(input3 == 8){
                                PlacementCell.average();
                            }
                            else if (input3 == 10) {
                                break;
                            }
                        }
                        } else if (second == 4) {
                            break;
                        }
                    }

            }else if (pehli == 2) {
            System.out.println("\u001B[33m" + "Thanks For Using FutureBuilder!!!!!!" + "\u001B[0m");
        }

    }
}


