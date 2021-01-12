package com.desafio.backend.entities;

import java.io.Serializable;
import java.text.ParseException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.swing.text.MaskFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_adress")
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String street;
	private String uf;
	private String city;
	private String district;
	private String zipCode;
	private String complement;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "client_id")
	private Clients client;
	
	public Address() {
		
	}
	
	public Address(Long id, String street, String uf, String city, String district, Clients client, String zipCode, String complement) {
		super();
		this.id = id;
		this.street = street;
		this.uf = uf;
		this.city = city;
		this.district = district;
		this.client = client;
		this.zipCode = zipCode;
		this.complement = complement;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Clients getClient() {
		return client;
	}
	
	public String getZipCode() {
		String pattern = "#####-###";
	 	String numeroProcesso = zipCode;
        return format(pattern, numeroProcesso) ;
	}

	public void setZipCode(String zipCode) {
		String unmaskedZip = zipCode.replaceAll("\\D", "");
		this.zipCode = unmaskedZip;
	}

	public void setClient(Clients client) {
		this.client = client;
	}
	
	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
