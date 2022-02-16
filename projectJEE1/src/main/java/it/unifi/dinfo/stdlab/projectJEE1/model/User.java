package it.unifi.dinfo.stdlab.projectJEE1.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Users")
public class User {
	private Long id;
	private String username;
	private String email;
	private String password;
	private Arbitro arbitro;
	private Designatore designatore;
	
	@Id
	@Column(name ="id", nullable=false)
	@NotNull
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRolePresent(String role) {
		if (this.arbitro!=null && "ARBITRO".equals(role) ) {
			return true;}
		if(this.designatore!=null && "DESIGNATORE".equals(role) )
			return true;
	
		return false;
	}
	
	@OneToOne
	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	
	@OneToOne
	public Designatore getDesignatore() {
		return designatore;
	}

	public void setDesignatore(Designatore designatore) {
		this.designatore = designatore;
	}

	
	
	
	
	
}
