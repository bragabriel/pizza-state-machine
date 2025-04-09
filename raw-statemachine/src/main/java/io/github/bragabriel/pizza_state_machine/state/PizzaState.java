package io.github.bragabriel.pizza_state_machine.state;

import io.github.bragabriel.pizza_state_machine.entity.Pizza;

public interface PizzaState {

	void startPrepare(Pizza pizza);

	void startAssembling(Pizza pizza);

	void startBaking(Pizza pizza);

	void finish(Pizza pizza);

	void cancel(Pizza pizza);

	String getStatus();
}

