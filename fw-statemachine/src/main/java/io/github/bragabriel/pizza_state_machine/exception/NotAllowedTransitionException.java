package io.github.bragabriel.pizza_state_machine.exception;

import io.github.bragabriel.pizza_state_machine.event.PizzaEvent;
import io.github.bragabriel.pizza_state_machine.state.PizzaState;

public class NotAllowedTransitionException extends RuntimeException {

	private static final String MESSAGE = "This transition is not allowed from the current state '%s' to '%s'.";

	public NotAllowedTransitionException(PizzaState currentStatus, PizzaEvent nextStatus) {
		super(String.format(MESSAGE, currentStatus, nextStatus));
	}
}
