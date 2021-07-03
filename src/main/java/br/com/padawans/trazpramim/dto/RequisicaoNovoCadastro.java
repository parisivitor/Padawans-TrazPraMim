package br.com.padawans.trazpramim.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import br.com.padawans.trazpramim.model.User;

@Controller
public class RequisicaoNovoCadastro {

	@NotBlank
	@Email
	private String login;
	@NotBlank
	private String senha;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}")
	private String dataNascimento;
	@NotBlank
	private String sexo;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public User toCadastro() {
		User user = new User();
		user.setLogin(login);
		user.setSenha(new BCryptPasswordEncoder().encode(senha));
		user.setDataNascimento(LocalDate.parse(this.dataNascimento,formatter));
		user.setNome(nome);
		user.setSobrenome(sobrenome);
		user.setSexo(sexo);
		return user;
	}

}
