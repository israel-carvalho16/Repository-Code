public class Exc1Class {
    //Insert a string into another string at a specific index
    protected String  string;
    protected String stringInsert;
    protected int index;

    public Exc1Class(String string, String stringAdd, int index) {
        this.string = string;
        this.stringInsert = stringAdd;
        this.index = index;
    }

    public String exc1(){
        return string.substring(0,index) + stringInsert + string.substring(index);
    }
}
