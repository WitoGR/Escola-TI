package escola.ti.controleparental.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import escola.ti.controleparental.model.HistoricoModel;
import escola.ti.controleparental.model.dto.HistoricoEnvioDTO;
import escola.ti.controleparental.model.dto.HistoricoPostDTO;
import escola.ti.controleparental.model.dto.UserLoginInfoDTO;
import escola.ti.controleparental.repository.HistoricoRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(path="/historico")
public class HistoricoController {
    
    @Autowired
    private HistoricoRepository historicoRepository;

    @PostMapping(path="/all")
    public List<HistoricoEnvioDTO> getUserHistorico(@RequestBody UserLoginInfoDTO body ){
        HistoricoEnvioDTO resposta = new HistoricoEnvioDTO();
        List<HistoricoEnvioDTO> lista = new ArrayList<HistoricoEnvioDTO>();

        for(HistoricoModel h : historicoRepository.findAll())
            if(h.getIdUser()==body.getIdUser()){
                resposta.setHorario(""+h.getHorarioDeAcesso());
                resposta.setUrl(h.getUrl());
                lista.add(resposta);
            }

        return lista;
    }

    @PostMapping(path="/save")
    public String postMethodName(@RequestBody HistoricoPostDTO body) {
        HistoricoModel historicoModel = new HistoricoModel();

        historicoModel.setHorarioDeAcesso(body.getHorario());
        historicoModel.setUrl(body.getUrl());
        historicoModel.setIdUser(body.getIdUser());

        historicoRepository.save(historicoModel);
        
        return "Historico Salvo";
    }
    

}