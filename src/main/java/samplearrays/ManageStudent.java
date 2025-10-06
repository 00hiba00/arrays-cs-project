package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        int maxAge = 0;
        int maxId = 0;
        for(int i = 0; i < students.length; i++){
            if(students[i].getAge() > maxAge){
                maxAge = students[i].getAge();
                maxId = i;
            }
        }
        Student oldest = students[maxId];
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for(int i = 0; i < students.length; i++){
            if(students[i].isAdult()){
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if(students.length == 0){
            return -1;
        }
        double sum = 0;
        for(int i = 0; i < students.length; i++){
            sum += students[i].getGrade();
        }
        return sum / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(int i = 0; i < students.length; i++){
            if(students[i].getName().equalsIgnoreCase(name)){
                return students[i];
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getGrade).reversed());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(int i = 0; i < students.length; i++){
            if(students[i].getGrade()>=15){
                System.out.println(students[i].getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(int i = 0; i < students.length; i++){
            if(students[i].getId() == id){
                students[i].setGrade(newGrade);
                System.out.println("Updated grade for " +students[i].getName()+ "is: " + students[i].getGrade());
                return true;
            }
        }
        System.out.println("No grade found or no id found");
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for(int i = 0; i < students.length; i++){
            for(int j = i+1; j < students.length; j++){
                if(students[i].getName().equalsIgnoreCase(students[j].getName())){
                    System.out.println("Duplicate names found: " +  students[i].getName() + " " + students[j].getName());
                    return true;
                }
            }
        }
        System.out.println("No duplicate names found");
        return false;

    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents = new Student[students.length + 1];
        for(int i = 0; i < students.length; i++){
            newStudents[i] = students[i];
        }
        newStudents[students.length-1] = newStudent;
        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr=new Student[5];
        arr[0] = new Student(0,"hiba",22,11);
        arr[1] = new Student(1,"alae",19,15);
        arr[2] = new Student(2,"farah",19,14);
        arr[3] = new Student(3,"aya",21,12);
        arr[4] = new Student(4,"nour",20,13);


        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println(findOldest(arr).getName());


        // 3) Count adults
        System.out.println(countAdults(arr));


        // 4) Average grade
        System.out.println(averageGrade(arr));


        // 5) Find by name
        System.out.println(findStudentByName(arr, "hiba"));


        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        System.out.println(updateGrade(arr,0,20));


        // 9) Duplicate names
        System.out.println(hasDuplicateNames(arr));

        // 10) Append new student
        Student stu = new Student(5,"maroua",22,12);
        Student[] newstu = appendStudent(arr,stu);
        System.out.println("== All Students ==");
        for (Student s : newstu) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());
    }
}

