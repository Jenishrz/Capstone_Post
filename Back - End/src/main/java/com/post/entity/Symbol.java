package com.post.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_symbol")
@Component
public class Symbol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="symbol_id")
	private long symbolId;
	@Column(name="Symbol_name")
	private String symbolName;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="post_id")
//	private List<PostMapping> postMapping;
	
	public Symbol() {
		super();

	}
	
	public Symbol(long symbolId, String symbolName) {
		super();
		this.symbolId = symbolId;
		this.symbolName = symbolName;
	}

	public long getSymbolId() {
		return symbolId;
	}

	public void setSymbolId(long symbolId) {
		this.symbolId = symbolId;
	}

	public String getSymbolName() {
		return symbolName;
	}

	public void setSymbolName(String symbolName) {
		this.symbolName = symbolName;
	}


	
	

}
