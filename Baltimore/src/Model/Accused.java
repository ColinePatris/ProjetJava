package Model;

public class Accused {
    private int age;
    private String sex;
    private String race; 

    public Accused() {
    }   
    
    public Accused(int age, String sex, String race){
        this.age = age;
        this.sex=sex;
        this.race=race;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getRace() {
        return race;
    }
    
    @Override
    public String toString(){
        String stringList;
        String raceFull = new String();
        stringList = "Accused : \n";
        stringList += "" + age + " years old \n";
        switch (race){
            //case = W :
        }
        stringList += raceFull + "\n";
        
        return stringList;
    }
    
}
