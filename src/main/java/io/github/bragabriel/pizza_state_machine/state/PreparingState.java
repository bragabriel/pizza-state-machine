package io.github.bragabriel.pizza_state_machine.state;

import io.github.bragabriel.pizza_state_machine.entity.Pizza;

// Estado inicial: Pedido recebido
public class PreparingState implements PizzaState {

	@Override
	public void startPrepare(Pizza pizza) {
		System.out.println("Pedido recebido! Abrindo a massa...");
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
		System.out.println("Cancelando pedido");
		pizza.setState(new CanceledState());
	}

	@Override
	public String getStatus() {
		return "Preparing";
	}
}

