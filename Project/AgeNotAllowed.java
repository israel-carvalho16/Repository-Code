public class AgeNotAllowed extends RuntimeException {
    public AgeNotAllowed(String message) {
        super(message);
    }

    public AgeNotAllowed(){
        System.out.println("A pessoa precisa ser maior de 18 anos");
    }
}
