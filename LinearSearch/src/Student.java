import java.util.Objects;

/**
 * @Author Alex Zheng
 * @Date 2021/2/8 20:35
 * @Annotation
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return this.name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
