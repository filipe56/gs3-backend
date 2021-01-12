package com.desafio.backend.entities;

import java.io.Serializable;
import java.text.ParseException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.text.MaskFormatter;

import com.desafio.backend.entities.enums.PhoneType;

@Entity
@Table(name = "tb_phone")
public class Phone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String number;
	private Integer phoneType;
	
	private String ddd;
	
	public Phone() {
		
	}

	public Phone(Long id,String number, String ddd, Integer phoneType) {
		super();
		this.id = id;
		this.number = number;
		this.ddd = ddd;
		this.phoneType = phoneType;	
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		if(this.phoneType == 1) {
			String pattern = "#####-####";
		 	String numeroProcesso = number;
	        return format(pattern, numeroProcesso) ;
		}else {
			String pattern = "####-####";
		 	String numeroProcesso = number;
	        return format(pattern, numeroProcesso) ;
		}
	}

	public void setNumber(String number) {
		String unmaskedNumber = number.replaceAll("\\D", "");
		this.number = unmaskedNumber;
	}
	

	public PhoneType getPhoneType() {
		return PhoneType.valueOf(phoneType);
	}

	public void setPhoneType(PhoneType phoneType) {
		if(phoneType != null) {
			this.phoneType = phoneType.getCode();
		}
	}


	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
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
		Phone other = (Phone) obj;
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
