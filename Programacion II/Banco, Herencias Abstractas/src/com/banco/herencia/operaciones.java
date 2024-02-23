package com.banco.herencia;

public class operaciones {
	private String name;
	private String ID;
	private String type;
	private Double money;
	
	
		public operaciones(String name, String ID, String type, Double money) {
			
			this.name = name;
			this.ID = ID;
			this.type = type;
			this.money = money;
		}

		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getID() {
			return ID;
		}


		public void setID(String iD) {
			ID = iD;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public Double getMoney() {
			return money;
		}


		public void setMoney(Double money) {
			this.money = money;
		}


	
}


