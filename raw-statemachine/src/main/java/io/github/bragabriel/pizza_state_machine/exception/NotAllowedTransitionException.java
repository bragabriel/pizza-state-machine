package io.github.bragabriel.pizza_state_machine.exception;

public class NotAllowedTransitionException extends RuntimeException {

	private static final String MESSAGE = "This transition is not allowed from the current state '%s' to '%s'.";

	public NotAllowedTransitionException(String currentStatus, String nextStatus) {
		super(String.format(MESSAGE, currentStatus, nextStatus));
	}
}
