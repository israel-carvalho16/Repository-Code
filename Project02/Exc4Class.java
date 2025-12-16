public class Exc4Class {
    //Replace a character at a specific index	"Geeks for geeks", 10, 'G'	"Geeks for Geeks"

    public void Replace(String string,int index,String LetraInserir){

        System.out.println(string.substring(0,index - 1) +  string.replace(string.substring(0,index), LetraInserir));
    }
}
