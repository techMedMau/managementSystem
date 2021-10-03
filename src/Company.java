import java.util.Arrays;

public class Company {
    private Office[] offices;
    private int officeCount;

    public Company(){
        this.offices = new Office[2];
        this.officeCount = 0;
    }

    public void addOffice(Office office){
        if(officeCount == offices.length){
            doubleArr();
        }
        offices[officeCount++] = office;
    }

    private void doubleArr(){
        Office[] tmp = new Office[offices.length*2];
        for(int i = 0; i < offices.length; i ++){
            tmp[i] = offices[i];
        }
        offices = tmp;
    }

    public Company filter(ComFilter filter){
        Company tmp = new Company();
        for(int i = 0; i < this.officeCount; i++){
            if(filter.comQualify(offices[i])){
                tmp.addOffice(offices[i]);
            }
        }
        return tmp;
    }

    public Company consumer(ComConsumer consumer){
        for(int i = 0; i < officeCount; i++){
            consumer.comRun(offices[i]);
        }
        return this;
    }

    public Office getOffice(int index){
        if(index<0 || index >= officeCount){
            return null;
        }
        return offices[index];
    }

    public int getOfficeCount() {
        return officeCount;
    }
}
