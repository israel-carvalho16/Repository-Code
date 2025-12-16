public class Main {

    static void main() {
        Exc1Class teste1 = new Exc1Class("GeeksGeeks","For",5);
        System.out.println(teste1.exc1());

        Exc2Class teste2 = new Exc2Class();
        teste2.exc2("Geeks");

        Exc3Class teste3 = new Exc3Class();
        teste3.sort("software");

        Exc4Class teste4 = new Exc4Class();
        teste4.Replace("geek for geek",6,"F");
    }
}