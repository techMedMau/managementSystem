/*
    1. 請撰寫一個類別Person


   - 其他屬性與方法請自行視情況添加
 */
public class Person {
    public static final String[] positionArr = {"工程師","設計師","專案經理"};
    public static final String[] genderArr = {"女","男"};
    private String name;
    private int age;
    private String gender;
    private String position;

    public Person(String name, int age, String gender,String position){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.position = position;
    }

    public String toString(){
        return "姓名 " +getName()+" 性別 "+getGender()+" 年齡 "+getAge()+" 職位 "+position;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGender(){
        return gender;
    }

    public String getPosition() {
        return position;
    }

}
