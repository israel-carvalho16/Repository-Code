public class Exc3Class {
    //Sort the characters in a string:	"software"/"aeforstw"

    public void sort(String string){
        char[] Alfabeto = new char[] {'a','b','c','d','e','f','g','h','i','j','k','m','n','o','p','q','r','s','t','u','v','w','y','z'};

        string = string.toLowerCase();

        for (char letras : Alfabeto) {

            for (int j = 0; j < string.length(); j++) {

                if (letras == string.charAt(j)) {
                    System.out.print(string.charAt(j));
                    break;
                }
            }
        }

        System.out.println();
    }
}
