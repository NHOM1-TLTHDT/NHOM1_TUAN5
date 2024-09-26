import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class bai7 {
    class Student {
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
            return "Student{" +
                    "studentId='" + studentId + '\'' +
                    ", name='" + name + '\'' +
                    ", averageScore=" + averageScore +
                    '}';
        }
    }

    class StudentManager {
        private ArrayList<Student> students = new ArrayList<>();

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

    public class Main {
        public static void main(String[] args) {
            StudentManager manager = new StudentManager();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Xóa sinh viên");
                System.out.println("3. Tìm kiếm sinh viên theo mã");
                System.out.println("4. Sắp xếp sinh viên theo điểm");
                System.out.println("5. Hiển thị danh sách sinh viên");
                System.out.println("6. Thoát");
                System.out.print("Chọn một tùy chọn: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Nhập mã sinh viên: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Nhập tên sinh viên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập điểm trung bình: ");
                        double averageScore = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        manager.addStudent(new Student(studentId, name, averageScore));
                        break;
                    case 2:
                        System.out.print("Nhập mã sinh viên cần xóa: ");
                        String idToRemove = scanner.nextLine();
                        manager.removeStudent(idToRemove);
                        break;
                    case 3:
                        System.out.print("Nhập mã sinh viên cần tìm: ");
                        String idToFind = scanner.nextLine();
                        Student foundStudent = manager.findStudentById(idToFind);
                        if (foundStudent != null) {
                            System.out.println(foundStudent);
                        } else {
                            System.out.println("Không tìm thấy sinh viên với mã " + idToFind);
                        }
                        break;
                    case 4:
                        manager.sortStudentsByScore();
                        System.out.println("Danh sách sinh viên sau khi sắp xếp theo điểm:");
                        manager.displayStudents();
                        break;
                    case 5:
                        System.out.println("Danh sách sinh viên:");
                        manager.displayStudents();
                        break;
                    case 6:
                        System.out.println("Thoát chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            }
        }
    }





}
