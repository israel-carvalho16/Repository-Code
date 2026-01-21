public class Exc2Class {
    //Reverse a string:"Geeks"/"skeeG"
    public void exc2(String string) {

        for (int i = string.length(); i > 0; i--) {

            System.out.print(string.charAt(i - 1));
        }
        System.out.println();
    }
}
