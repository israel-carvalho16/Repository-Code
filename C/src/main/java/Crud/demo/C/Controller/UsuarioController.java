package Crud.demo.C.Controller;

import Crud.demo.C.Business.UserService;
import Crud.demo.C.Infra.Entity.Usuario;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UserService usuarioService;

    public UsuarioController(UserService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario Usuario){
        usuarioService.salvaUsuario(Usuario);
        return new ResponseEntity<>(HttpStatusCode.valueOf(500));
    }

    @GetMapping
    public ResponseEntity<Usuario> buscaUSerEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.BuscaUserEmail(email));

    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUserEmail(@RequestParam String email){
        usuarioService.deletarUserEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> AtualizaUserID(@RequestParam Integer id, @RequestBody Usuario U){
        usuarioService.salvaUsuario(U);
        return ResponseEntity.ok().build();
    }
}
