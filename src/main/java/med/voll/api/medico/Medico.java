package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    private Boolean ativo;
    
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    
    @Embedded
    private Endereco endereco;
    
    public Medico(DadosCadastroMeidco dados) {
    	
    	this.nome = dados.nome();
    	this.email = dados.email();
    	this.crm = dados.crm();
    	this.especialidade = dados.especialidade();
    	this.endereco = new Endereco(dados.endereco());
    	this.telefone = dados.telefone();
    	this.ativo = true;
		
	}

	public void atualizarInformacoes(@Valid DadosAtualizarMedicos dados) {
		
		if(dados.nome() != null){
		
			this.nome = dados.nome();
				
		}
		
		if(dados.telefone() != null){
			
			this.telefone = dados.telefone();
				
		}
		
		if(dados.endereco() != null){
			
			this.endereco.atualizaInformacao(dados.endereco());
				
		}
		// TODO Auto-generated method stub
		
	}

	public void excluir() {
		
		
		this.ativo = false;
		// TODO Auto-generated method stub
		
	}

	
}
