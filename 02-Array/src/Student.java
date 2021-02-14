import java.util.Objects;

/**
 * @Author Alex Zheng
 * @Date 2021/2/8 20:35
 * @Annotation
 */
public class Student {

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        //自反性
        if (this == o){
            return true ;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return this.score==student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alex",100));
        arr.addLast(new Student("Sam",56));
        arr.addLast(new Student("Mike",77));

        System.out.println(arr);

    }
}
