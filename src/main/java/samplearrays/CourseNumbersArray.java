package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = new int[registeredCourses.length + 1];
        for(int i = 0; i < registeredCourses.length; i++){
            updatedCourses[i] = registeredCourses[i];
        }
        int newCourse = 2170;
        updatedCourses[updatedCourses.length - 1] = newCourse;
        System.out.println("Updated Course list is: ");
        for(int i = 0; i < updatedCourses.length; i++){
            System.out.print(updatedCourses[i] + ", ");
        }
        int CourseNumber = 2000;
        int c=0;
        for(int i = 0; i < updatedCourses.length; i++){
            if(updatedCourses[i] != CourseNumber){
                c++;
            }
        }
        if(c == updatedCourses.length){
            System.out.println("\nCourse number "+CourseNumber+" not found");
        }
        else{
            System.out.println("\nCourse number "+CourseNumber+" found");
        }
    }

}
