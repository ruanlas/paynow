package br.edu.ifsp.PayNow.web.controller;

import br.com.caelum.vraptor.*;
import javax.inject.Inject;
import static java.util.Arrays.asList;
import br.edu.ifsp.PayNow.model.repository.UsuarioRepository;
import br.edu.ifsp.PayNow.model.entity.Usuario;

@Controller
public class UsuarioController {

    @Inject
    private Result result;

    @Inject
    UsuarioRepository paganteRepository;

    public void lista() {
        result.include("pagandores", paganteRepository.todas());
    }

    public void adiciona() {

    }
    
    public void salva(Usuario pagador) {
        paganteRepository.salvar(pagador);
        result.redirectTo(UsuarioController.class).resumo(pagador);
    }

    public void resumo(Usuario pagador) {
        result.include("resumo", pagador);
    }

    public String index() {
        return "ok";
    }
}