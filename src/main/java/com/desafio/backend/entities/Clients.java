package com.desafio.backend.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.swing.text.MaskFormatter;

@Entity
@Table(name = "tb_client")
public class Clients implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String cpf;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="client_id")
	private Set<Phone> phones = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="client_id")
	private Address address;
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="email", joinColumns = @JoinColumn(name = "client_id"))
	@Column(name = "email")
	private Set<String> emails = new HashSet<>();
	
	public Clients() {
	}
	
	
	public Clients(Long id, String name, String cpf, Set<Phone> phones, Address address, Set<String> email) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.emails = email;
		this.phones = phones;
		this.address = address;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		 	String pattern = "###.###.###-##";
		 	String numeroProcesso = cpf;
	        return format(pattern, numeroProcesso) ;
	}

	public void setCpf(String cpf) {
		String unsmaskedCpf = cpf.replaceAll("\\D", "");
		this.cpf = unsmaskedCpf;
	}
	
	public Set<Phone> getPhones() {
		return phones;
	}

	public Address getAddress() {
		return address;
	}

	public Set<String> getEmails() {
		return emails;
	}
	
	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}


	public void setAddresses(Address address) {
		this.address = address;
	}


	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clients other = (Clients) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	private static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
