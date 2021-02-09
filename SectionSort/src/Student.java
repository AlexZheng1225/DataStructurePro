import java.util.Objects;

/**
 * @Author Alex Zheng
 * @Date 2021/2/8 20:35
 * @Annotation implements Comparable<Student>接口需要实现compareTo方法
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name,int score) {
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
    public int compareTo(Student another) {
//        if (this.score<another.score){
//            return -1;
//        }else if (this.score == another.score){
//            return 0;
//        }else{
//            return 1;
//        }
        //从小到大排序
        return this.score - another.score;
        //从大到小排序
//        return another.score - this.score;
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

    @Override
    public String toString() {
        return String.format("Student(name:%s,score:%d)",name,score);
    }
}
