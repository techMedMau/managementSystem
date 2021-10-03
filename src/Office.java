public class Office {
    private Person[] people;
    private int pplCount;
    private String name;

    public Office(String name){
        this.people = new Person[2];
        this.pplCount = 0;
        this.name = name;
    }

    public void addPerson(Person person){
        if(pplCount == people.length){
            doubleArr();
        }
        people[pplCount++] = person;
    }

    public void addPeople(Office office){
        for(int i = 0 ; i < office.pplCount; i++){
            addPerson(office.getPerson(i));
        }
    }

    public void remove(int index){
        if(index < 0 || index >= pplCount){
            return;
        }
        for(int i = index; i < pplCount-1; i++){
            people[i] = people[i+1];
        }
        pplCount--;
    }

    public void remove(Person person){
        int i;
        for(i = 0; i <pplCount; i ++){
            if(person.equals(people[i])){
                break;
            }
        }
        if(i == pplCount){
            return;
        }
        remove(i);
    }

    public void remove(Office office){
        for(int i = 0; i < office.getPplCount(); i++){
            remove(office.getPerson(i));
        }
    }

    public Person getPerson(int index){
        if(index<0 || index >= pplCount){
            return null;
        }
        return people[index];
    }

    public Office filter(Filter filter){
        Office storageOffice = new Office("暫存");
        for(int i = 0; i < this.getPplCount(); i ++){
            if(filter.qualify(people[i])){
                storageOffice.addPerson(people[i]);
            }
        }
        return storageOffice;
    }

    public Office consumer(Consumer consumer){
        for(int i = 0; i < pplCount; i++){
            consumer.run(people[i]);
        }
        return this;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < pplCount; i++){
            str += people[i] + "\n";
        }
        return str;
    }

    private void doubleArr(){
        Person[] tmp = new Person[people.length*2];
        for(int i = 0; i < people.length; i ++){
            tmp[i] = people[i];
        }
        people = tmp;
    }

    public String getName(){
        return this.name;
    }

    public int getPplCount() {
        return pplCount;
    }

    public Person[] getPeople() {
        return people;
    }
}
