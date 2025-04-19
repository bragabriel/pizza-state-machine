package io.github.bragabriel.pizza_state_machine;

import io.github.bragabriel.pizza_state_machine.entity.Pizza;
import io.github.bragabriel.pizza_state_machine.event.PizzaEvent;
import io.github.bragabriel.pizza_state_machine.service.PizzaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PizzaStateMachineApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(PizzaStateMachineApplication.class, args);
		PizzaService pizzaService = context.getBean(PizzaService.class);

		Pizza pizza = new Pizza(123L);
		System.out.println("Estado inicial: " + pizza.getState());

		pizzaService.processEvent(pizza, PizzaEvent.START_PREPARE)
				.doOnTerminate(() -> System.out.println("Estado após o evento START_PREPARE: " + pizza.getState()))
				.subscribe();

		pizzaService.processEvent(pizza, PizzaEvent.START_ASSEMBLING)
				.doOnTerminate(() -> System.out.println("Estado após o evento START_ASSEMBLING: " + pizza.getState()))
				.subscribe();

		pizzaService.processEvent(pizza, PizzaEvent.START_BAKING)
				.doOnTerminate(() -> System.out.println("Estado após o evento START_BAKING: " + pizza.getState()))
				.subscribe();

		pizzaService.processEvent(pizza, PizzaEvent.FINISH)
				.doOnTerminate(() -> System.out.println("Estado após o evento FINISH: " + pizza.getState()))
				.subscribe();
	}

}
