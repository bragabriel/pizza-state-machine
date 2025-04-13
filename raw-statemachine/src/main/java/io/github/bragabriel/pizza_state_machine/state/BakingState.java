package io.github.bragabriel.pizza_state_machine.state;

import io.github.bragabriel.pizza_state_machine.entity.Pizza;
import io.github.bragabriel.pizza_state_machine.exception.NotAllowedTransitionException;

public class BakingState implements PizzaState{

	@Override
	public void startPrepare(Pizza pizza) {
		throw new NotAllowedTransitionException(pizza.getStatus(), "preparing");
	}

	@Override
	public void startAssembling(Pizza pizza) {
		throw new NotAllowedTransitionException(pizza.getStatus(), "assembling");
	}

	@Override
	public void startBaking(Pizza pizza) {
		System.out.println("Pizza está no forno assando!");
	}

	@Override
	public void finish(Pizza pizza) {

	}

	@Override
	public void cancel(Pizza pizza) {
		throw new NotAllowedTransitionException(pizza.getStatus(), "cancel");
	}

	@Override
	public String getStatus() {
		return "Baking";
	}
}
