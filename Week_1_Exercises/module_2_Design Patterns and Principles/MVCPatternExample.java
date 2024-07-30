//  Define Model Class
class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

//  Define View Class
class StudentView {
    public void displayStudentDetails(String name, int id, String grade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}

//  Define Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(int id) {
        model.setId(id);
    }

    public int getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

//  Test the MVC Implementation
public class MVCPatternExample {
    public static void main(String[] args) {
        // Create a student model
        Student student = new Student("Edward peterson", 1, "A");

        // Create a view to display student details
        StudentView view = new StudentView();

        // Create a controller to manage the student model and view
        StudentController controller = new StudentController(student, view);

        // Update view to display initial student details
        controller.updateView();

        // Update student details via the controller
        controller.setStudentName("Johny cinny");
        controller.setStudentGrade("B");

        // Update view to display updated student details
        controller.updateView();
    }
}

