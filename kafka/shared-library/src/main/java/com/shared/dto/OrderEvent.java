package com.shared.dto;

public class OrderEvent {
	 private String message;
	    private String status;
	    private Order order;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Order getOrder() {
			return order;
		}
		public void setOrder(Order order) {
			this.order = order;
		}
		@Override
		public String toString() {
			return String.format("OrderEvent [message=%s, status=%s, order=%s]", message, status, order);
		}
	    
}