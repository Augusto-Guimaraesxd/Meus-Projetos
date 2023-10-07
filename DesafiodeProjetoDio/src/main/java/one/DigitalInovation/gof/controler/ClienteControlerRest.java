package one.DigitalInovation.gof.controler;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import one.DigitalInovation.gof.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import one.DigitalInovation.gof.service.ClienteService;
@RestController
@RequestMapping
public class ClienteControlerRest {
    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public ResponseEntity<Iterable<Cliente>>buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente>buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }
    @PostMapping
    public ResponseEntity<Cliente>inserir(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping
    public ResponseEntity<Cliente>atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.atualizar(id,cliente);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
