package io.github.bragabriel.pizza_state_machine.config;

import io.github.bragabriel.pizza_state_machine.enumerator.PizzaEvent;
import io.github.bragabriel.pizza_state_machine.state.PizzaState;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class PizzaStateMachineConfig extends EnumStateMachineConfigurerAdapter<PizzaState, PizzaEvent> {

	@Override
	public void configure(StateMachineStateConfigurer<PizzaState, PizzaEvent> states) throws Exception {
		states
				.withStates()
				.initial(PizzaState.ORDER_RECEIVED)
				.states(EnumSet.allOf(PizzaState.class))
				.end(PizzaState.READY)
				.end(PizzaState.CANCELLED);
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<PizzaState, PizzaEvent> transitions) throws Exception {
		transitions
				.withExternal()
				.source(PizzaState.ORDER_RECEIVED).target(PizzaState.PREPARING).event(PizzaEvent.START_PREPARE)
				.and()
				.withExternal()
				.source(PizzaState.PREPARING).target(PizzaState.ASSEMBLING).event(PizzaEvent.START_ASSEMBLING)
				.and()
				.withExternal()
				.source(PizzaState.ASSEMBLING).target(PizzaState.BAKING).event(PizzaEvent.START_BAKING)
				.and()
				.withExternal()
				.source(PizzaState.BAKING).target(PizzaState.READY).event(PizzaEvent.FINISH)
				.and()
				// Cancelamento permitido até começar a assar
				.withExternal()
				.source(PizzaState.ORDER_RECEIVED).target(PizzaState.CANCELLED).event(PizzaEvent.CANCEL)
				.and()
				.withExternal()
				.source(PizzaState.PREPARING).target(PizzaState.CANCELLED).event(PizzaEvent.CANCEL)
				.and()
				.withExternal()
				.source(PizzaState.ASSEMBLING).target(PizzaState.CANCELLED).event(PizzaEvent.CANCEL);
	}
}
