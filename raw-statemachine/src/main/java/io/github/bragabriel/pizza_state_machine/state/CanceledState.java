package io.github.bragabriel.pizza_state_machine.state;

import io.github.bragabriel.pizza_state_machine.entity.Pizza;

public class CanceledState implements PizzaState{

	@Override
	public void startPrepare(Pizza pizza) {

	}

	@Override
	public void startAssembling(Pizza pizza) {

	}

	@Override
	public void startBaking(Pizza pizza) {

	}

	@Override
	public void finish(Pizza pizza) {

	}

	@Override
	public void cancel(Pizza pizza) {

	}

	@Override
	public String getStatus() {
		return "Cancel";
	}

}
