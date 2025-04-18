package io.github.bragabriel.pizza_state_machine.state;


import io.github.bragabriel.pizza_state_machine.entity.Pizza;
import io.github.bragabriel.pizza_state_machine.exception.NotAllowedTransitionException;

public class AssemblingState implements PizzaState {

	@Override
	public void startPrepare(Pizza pizza) {
		System.out.println("Pedido voltou para o estado inicial");
	}

	@Override
	public void startAssembling(Pizza pizza) {
		System.out.println("Montando a pizza!");
	}

	@Override
	public void startBaking(Pizza pizza) {

	}

	@Override
	public void finish(Pizza pizza) {
		throw new NotAllowedTransitionException(pizza.getStatus(), "finish");
	}

	@Override
	public void cancel(Pizza pizza) {
		System.out.println("Cancelando pedido");
		pizza.setState(new CanceledState());
	}

	@Override
	public String getStatus() {
		return "Assembling";
	}
}
