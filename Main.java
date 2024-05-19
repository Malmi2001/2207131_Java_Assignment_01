import java.util.*;
import java.io.*;

class Student {
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String toString() {
        return this.name;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(33, "Rumpa", 3.68));
        students.add(new Student(85, "Ashis", 3.85));
        students.add(new Student(56, "Samiha", 3.75));
        students.add(new Student(19, "Samara", 3.75));
        students.add(new Student(22, "Fahim", 3.76));

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s2.cgpa != s1.cgpa) {
                    return Double.compare(s2.cgpa, s1.cgpa);
                } else if (!s1.name.equals(s2.name)) {
                    return s1.name.compareTo(s2.name);
                } else {
                    return Integer.compare(s1.id, s2.id);
                }
            }
        });

        for(Student s : students) {
            System.out.println(s);
        }

        saveToFile(students, "yourIndexNumber.txt");
    }

    public static void saveToFile(List<Student> students, String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            for (Student s : students) {
                writer.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while saving to file: " + e.getMessage());
        }
    }
}
