package io.github.bragabriel.pizza_state_machine.service;

import io.github.bragabriel.pizza_state_machine.entity.Pizza;
import io.github.bragabriel.pizza_state_machine.event.PizzaEvent;
import io.github.bragabriel.pizza_state_machine.exception.NotAllowedTransitionException;
import io.github.bragabriel.pizza_state_machine.state.PizzaState;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineEventResult;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PizzaService {

	@Autowired
	private final StateMachineFactory<PizzaState, PizzaEvent> stateMachineFactory;

	public Mono<Void> processEvent(Pizza pizza, PizzaEvent targetEvent) {
		StateMachine<PizzaState, PizzaEvent> machine =
				stateMachineFactory.getStateMachine(String.valueOf(pizza.getId()));

		if (machine.getState() == null) {
			machine.getStateMachineAccessor().doWithAllRegions(accessor -> {
				accessor.resetStateMachineReactively(
						new DefaultStateMachineContext<>(pizza.getState(), null, null, null)
				).subscribe();
			});

			machine.startReactively().subscribe();
		}

		return machine.sendEvent(Mono.just(MessageBuilder.withPayload(targetEvent).build()))
				.next()
				.flatMap(result -> {
					if (result.getResultType() == StateMachineEventResult.ResultType.DENIED) {
						return Mono.error(new NotAllowedTransitionException(pizza.getState(), targetEvent));
					}
					if (machine.getState() != null) {
						pizza.setState(machine.getState().getId());
						return Mono.empty();
					} else {
						return Mono.error(new IllegalStateException("Estado inválido após transição: " + targetEvent));
					}
				});
	}
}

