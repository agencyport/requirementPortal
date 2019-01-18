package com.accenture.springmvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "lobdata")
public class LobData implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dataId;
	    @JoinColumn(name = "lob_reference_id")
	    private int  lobReferenceId;
	    @Column(length = 555)
	    private String data;
		public int getDataId() {
			return dataId;
		}
		public void setDataId(int dataId) {
			this.dataId = dataId;
		}
		
		public int getLobReferenceId() {
			return lobReferenceId;
		}
		public void setLobReferenceId(int lobReferenceId) {
			this.lobReferenceId = lobReferenceId;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		

}
