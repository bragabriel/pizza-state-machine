package io.github.bragabriel.pizza_state_machine;

import io.github.bragabriel.pizza_state_machine.entity.Pizza;
import io.github.bragabriel.pizza_state_machine.state.AssemblingState;
import io.github.bragabriel.pizza_state_machine.state.BakingState;
import io.github.bragabriel.pizza_state_machine.state.FinishedState;

public class PizzaStateMachineApplication {

	public static void main(String[] args) {
		Pizza pizza = new Pizza();
		System.out.println("Current State: " + pizza.getStatus());

		pizza.prepare();
		System.out.println("Current State: " + pizza.getStatus() + "\n");

		pizza.setState(new AssemblingState());
		pizza.assemble();
		System.out.println("Current State: " + pizza.getStatus() + "\n");

		pizza.setState(new BakingState());
		pizza.bake();
		System.out.println("Current State: " + pizza.getStatus() + "\n");

		pizza.setState(new FinishedState());
		pizza.finish();
		System.out.println("Current State: " + pizza.getStatus() + "\n");
	}

}
