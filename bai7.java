import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
class Student{
    private String studentId;
    private String name;
    private double averageScore;
    public Student(String studentId, String name, double averageScore) {
        this.studentId = studentId;
        this.name = name;
        this.averageScore = averageScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getAverageScore() {
        return averageScore;
    }

    @Override
    public String toString() {
        return "Sinh_Vien{" +
                "Ma_SV='" + studentId + '\'' +
                ", Ten='" + name + '\'' +
                ", DTB=" + averageScore +
                '}';
    }
}

class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String studentId) {
        students.removeIf(student -> student.getStudentId().equals(studentId));
    }

    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void sortStudentsByScore() {
        Collections.sort(students, Comparator.comparingDouble(Student::getAverageScore));
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        // Thêm sinh viên từ đầu vào của người dùng
        System.out.println("Nhập số lượng sinh viên:");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng mới sau khi nhập số

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Nhập mã sinh viên:");
            String studentId = scanner.nextLine();
            System.out.println("Nhập tên sinh viên:");
            String name = scanner.nextLine();
            System.out.println("Nhập điểm trung bình:");
            double averageScore = scanner.nextDouble();
            scanner.nextLine(); // Đọc bỏ dòng mới sau khi nhập điểm

            manager.addStudent(new Student(studentId, name, averageScore));
        }

        // Hiển thị danh sách sinh viên
        System.out.println("Danh sách sinh viên:");
        manager.displayStudents();

        // Tìm kiếm sinh viên theo mã
        System.out.println("\nNhập mã sinh viên cần tìm:");
        String searchId = scanner.nextLine();
        System.out.println(manager.findStudentById(searchId));

        // Sắp xếp sinh viên theo điểm
        manager.sortStudentsByScore();
        System.out.println("\nDanh sách sinh viên sau khi sắp xếp theo điểm:");
        manager.displayStudents();

        // Xóa sinh viên
        System.out.println("\nNhập mã sinh viên cần xóa:");
        String removeId = scanner.nextLine();
        manager.removeStudent(removeId);
        System.out.println("\nDanh sách sinh viên sau khi xóa sinh viên:");
        manager.displayStudents();

        scanner.close();
    }
}
