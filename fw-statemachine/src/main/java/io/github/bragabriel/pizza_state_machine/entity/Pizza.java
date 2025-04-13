package io.github.bragabriel.pizza_state_machine.entity;

import io.github.bragabriel.pizza_state_machine.state.PizzaState;
import lombok.Data;

@Data
public class Pizza {

	private Long id;
	private PizzaState state;

	public Pizza(Long id) {
		this.id = id;
		state = PizzaState.ORDER_RECEIVED;
	}
}

