package io.github.bragabriel.pizza_state_machine.entity;

import io.github.bragabriel.pizza_state_machine.state.PizzaState;
import io.github.bragabriel.pizza_state_machine.state.PreparingState;
import lombok.Data;

@Data
public class Pizza {

	private String flavor;
	private PizzaState state;

	public Pizza() {
		state = new PreparingState();
	}

	public void prepare() {
		state.startPrepare(this);
	}

	public void bake(){
		state.startBaking(this);
	}

	public void assemble(){
		state.startAssembling(this);
	}

	public void finish() {
		state.finish(this);
	}

	public void cancel(){
		state.cancel(this);
	}

	public String getStatus() {
		return state.getStatus();
	}
}

