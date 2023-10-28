package com.javatechie.dto;

import com.javatechie.entity.Riesgo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiesgoEvent {

    private String eventType;
    private Riesgo product;
    
	public RiesgoEvent(String eventType, Riesgo product) {
		super();
		this.eventType = eventType;
		this.product = product;
	}
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Riesgo getProduct() {
		return product;
	}
	public void setProduct(Riesgo product) {
		this.product = product;
	}
    
    
}
