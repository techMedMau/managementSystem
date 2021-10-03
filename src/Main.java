import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Company company = new Company();
        Office noNameOffice = new Office("noName");
        while(true) {
            int choice = input("select function",1,6,false);

            switch (choice) {
                case 1://   create new office
                    company.addOffice(new Office(input("input office name:",3,true)));
                    break;
                case 2://   create officer to noName office
                    noNameOffice.addPerson(new Person(input("input name:", 2,true)
                            , input("input age:",10,100, true)
                            , Person.genderArr[input("input sex:",0,1, true)]
                            , Person.positionArr[input("input position:",0,2, true)]));
                    break;
                case 3:
                    System.out.println(noNameOffice.toString());
                    Office filtOff = filter(noNameOffice);
                    System.out.println(filtOff.toString());
                    company.consumer(office -> System.out.println(office.getName()));
                    Office findOff = findOffice(company);
                    if(findOff != null){
                        findOff.addPeople(filtOff);
                        noNameOffice.remove(filtOff);
                    }

                    break;
                case 4:
                    Office findOff2 = findOffice(company);
                    if(findOff2 != null){
                        int opt = input("function1, 2,or 3",1,3,false);
                        switch (opt){
                            case 1:
                                printOffice(findOff2);
                                break;
                            case 2:
                                Office filtOff2 = filter(findOff2);
                                if(filtOff2 != null){
                                    findOff2.remove(filtOff2);
                                    noNameOffice.addPeople(filtOff2);
                                }
                                break;
                            case 3:
                                break;
                        }
                    }
                    break;
                case 5://   print all
                    company.consumer(Main::printOffice);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    public static Office filter(Office office){
        int opt;
        do{
            opt = input("filter by?：",1,5,false);
            switch(opt){
                case 1:
                    final String name = input("input office name：",3,false);
                    office = office.filter(person -> person.getName().equals(name));
                    break;
                case 2:
                    final int min = input("min age：",0,100,false);
                    final int max = input("max age：",0,100,false);
                    office = office.filter(person -> {
                        return person.getAge() >= min && person.getAge() <= max;
                    });
                    break;
                case 3:
                    final String gender = input("search gender?",1,false);
                    office = office.filter(person -> person.getGender().equals(gender));
                    break;
                case 4:
                    final String position = input("search position?",3,false);
                    office = office.filter(person -> person.getPosition().equals(position));
                    break;
            }
        } while(opt != 5);
        return office;
    }

    public static void printOffice(Office office){
        System.out.println(office.getName());
        System.out.println("------------------");
        office.consumer(System.out::println);
    }

    public static Office findOffice(Company company){
        String key = input("search office?",3,false);
        company = company.filter(office -> office.getName().equals(key));
        if(company.getOfficeCount() == 0){
            return null;
        }
        return company.getOffice(0);
    }

    public static int random(int min, int max){
        return (int)(Math.random()*(max-min+1)+min);
    }

    public static String input(String hint, int length, boolean isRandom){
        Scanner sc = new Scanner(System.in);
        if(isRandom){
            String str = "";
            for(int i = 0; i < length; i++){
                str += (char)random(97,122);
            }
            System.out.println("auto input(String)："+str);
            return str;
        }
        String str2;
        do{
            System.out.println(hint+"(length"+length+"):");
            str2 = sc.nextLine();
            return str2;
        }while(str2.length() != length);
    }

    public static int input(String hint, int min,int max, boolean isRandom){
        Scanner sc = new Scanner(System.in);
        if(isRandom){
            int n = (int)(Math.random()*(max-min+1)+min);
            System.out.println("auto input(int)："+n);
            return n;
        }
        int n2;
        do{
            System.out.println(hint+"("+min+"~"+max+"):");
            n2 = sc.nextInt();
            return n2;
        }while(n2 < min || n2 > max);
    }

}
