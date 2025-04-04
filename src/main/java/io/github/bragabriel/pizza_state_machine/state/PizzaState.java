package io.github.bragabriel.pizza_state_machine.state;

import io.github.bragabriel.pizza_state_machine.entity.Pizza;
import io.github.bragabriel.pizza_state_machine.exception.NotAllowedTransitionException;

public interface PizzaState {

	void startPrepare(Pizza pizza);

	void startAssembling(Pizza pizza);

	void startBaking(Pizza pizza);

	void finish(Pizza pizza);

	void cancel(Pizza pizza);

	String getStatus();
}

