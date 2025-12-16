import java.util.ArrayList;
import java.util.List;

public class AgendaTelefonica implements method {

    List<Contatos> Agenda = new ArrayList<>();

    @Override
    public void add(Contatos p) {
        Agenda.add(p);
    }

    public void show(){
        for (Contatos pessoas:Agenda){
            System.out.println(pessoas);

        }
    }
    @Override
    public void remover(String numero){
        boolean removido = Agenda.removeIf(pessoas -> pessoas.getTelefone().equals(numero));
        if(!removido){
            System.out.println("não encontrado");
        }
    }

    @Override
    public void verificar(String numero) {
      boolean Encontrado = false;
       for(Contatos pessoas:Agenda){
           if(pessoas.getTelefone().equals(numero)){
               Encontrado = true;
               System.out.println(pessoas);
               break;
           }else{
               Encontrado = false;
           }


       }

        if(!Encontrado){
            System.out.println("não encontrado");
        }
    }

    @Override
    public String toString() {
        return "blocPeople{" +
                "bloc=" + Agenda + "}";
    }


}
