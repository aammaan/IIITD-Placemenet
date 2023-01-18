package oop;

import java.util.ArrayList;
import java.util.List;

public class Storeroom {
  public static   List<Student> listofstudents = new ArrayList<Student>() ;
  public static   List<Company> listofcompany = new ArrayList<Company>() ;

  public static   List<Student> drivestudent = new ArrayList<Student>() ;
  public static   List<Company> drivecompany = new ArrayList<Company>() ;


  static int registeredstudents =0;
  static int registeredcompanies =0;

  static public int searchstudent(int roll){
    int de=0;
    for(int o=0;o<Storeroom.listofstudents.size();o++) {
      if(Storeroom.listofstudents.get(o).roll == roll){
        de = o;
        break;
      }
    }
    return de;
  }
  static public int searchcompany(String name){
    int de=0;
    for(int o=0;o<Storeroom.listofcompany.size();o++) {
      if(Storeroom.listofcompany.get(o).name == name){
        de = o;
        break;
      }
    }
    return de;
  }
}
