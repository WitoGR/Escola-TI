package escola.ti.controleparental.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_historico")
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_historico")
    @Getter
    @Setter
    private Integer idHistorico;

    @Column(name="id_user")
    @Getter
    @Setter
    private Integer idUser;

    @Column(name="url")
    @Getter
    @Setter
    private String url;

    @Column(name="horario")
    @Getter
    @Setter
    private Timestamp horarioDeAcesso;
}
