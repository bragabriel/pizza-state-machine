# 🍕 Pizza State Machine (Spring)

This module shows how to use **Spring StateMachine** to model and control the states of a pizza order.

It **automatically handles** state transitions, guards, and event triggering using a declarative approach.


> 🎥 This is **Part 3** of the series:
> - Part 1: Explaining what a State Machine is.
> - Part 2: Implementing a State Machine manually in Java.
> - **Part 3 (this one): Using Spring State Machine Framework.** [Watch the video here](https://youtu.be/vedmXkjZS9w) 👈

---

## 🔧 What this project covers

- How a state machine works 
- Simulating pizza states (like "preparing", "baking", etc.)
- Changing pizza states based on events 
- Preventing wrong state changes

---

## ⚙️ Pizza Flow Example

1. **ORDER_RECEIVED** – Order has been placed.
2. **PREPARING** – Ingredients are being prepared.
    - Event: `START_PREAPARE` or `CANCEL`
3. **ASSEMBLING** – Pizza is being assembled.
    - Event: `START_ASSEMBLING` or `CANCEL`
4. **BAKING** – Pizza is in the oven.
    - Event: `START_BAKING`
5. **READY** – Pizza is finished. End state.
    - Event: `FINISH`
6. **CANCELLED** – Order was cancelled. End state.

---

## ▶️ How to run

```bash
  ./mvnw spring-boot:run
```

Or just run the ```main()``` method in PizzaStateMachineApplication. 
Logs will show the state transitions happening step by step.

---

## 📚 Technologies used
Java 21; Spring Boot; Spring StateMachine

---

## 👨‍💻 Author

Created by Gabriel Braga — [LinkedIn](https://www.linkedin.com/in/gabriel-braga-da-silva/) |
[Twitter](https://x.com/gbraga_dev) |
[YouTube](https://www.youtube.com/@gabrielbragadev)

---

## 🔗 Related modules

- [Raw StateMachine Module](../raw-statemachine/README.md): Implementation **without** using the 
  <u>state-machine-framework</u>.
- [Project Root](../README.md): Overview and series link
