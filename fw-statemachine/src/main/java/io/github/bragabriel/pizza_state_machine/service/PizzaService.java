package io.github.bragabriel.pizza_state_machine.service;

import io.github.bragabriel.pizza_state_machine.entity.Pizza;
import io.github.bragabriel.pizza_state_machine.enumerator.PizzaEvent;
import io.github.bragabriel.pizza_state_machine.state.PizzaState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PizzaService {

	@Autowired
	private final StateMachineFactory<PizzaState, PizzaEvent> stateMachineFactory;

	public void processEvent(Pizza pizza, PizzaEvent event) {

		StateMachine<PizzaState, PizzaEvent> machine =
				stateMachineFactory.getStateMachine(String.valueOf(pizza.getId()));

		machine.stop();
		machine.getStateMachineAccessor().doWithAllRegions(accessor -> {
			accessor.resetStateMachine(new DefaultStateMachineContext<>(pizza.getState(), null, null, null));
		});

		machine.start();

		boolean accepted = machine.sendEvent(event);

		if (!accepted) {
			throw new IllegalStateException("Invalid transition from " + pizza.getState() + " with event " + event);
		}

		pizza.setState(machine.getState().getId());
	}
}
