# 🍕 Pizza State Machine (without frameworks)

This module shows how to implement a **State Machine from scratch**, without the state-machine-framework.

It's a simple, clean implementation where all transitions and rules are explicitly defined in code — **great for 
learning the fundamentals** before diving into frameworks.


> 🎥 This is **Part 2** of the series:
> - Part 1: Explaining what a State Machine is.
> - **Part 2 (this one): Implementing a State Machine manually in Java.** [Watch the video here](https://www.youtube.com/@gabrielbragadev) 👈
> - Part 3 : Using Spring State Machine Framework. 

---

## 🎯 What you'll learn

- What a State Machine really is under the hood
- How to represent states and transitions manually
- How to trigger transitions using events
- Why state machines are useful in backend workflows

---

## ⚙️ Pizza Flow Example

1. **ORDER_RECEIVED** – Order has been placed.
    - Event: `START_PREPARE`
2. **PREPARING** – Ingredients are being prepared.
    - Event: `START_ASSEMBLING` or `CANCEL`
3. **ASSEMBLING** – Pizza is being assembled.
    - Event: `START_BAKING` or `CANCEL`
4. **BAKING** – Pizza is in the oven.
    - Event: `FINISH`
5. **READY** – Pizza is finished. End state.
6. **CANCELLED** – Order was cancelled. End state.

---

## ▶️ How to run

```bash
  ./mvnw spring-boot:run
```

Or just run the ```main()``` method in PizzaStateMachineApplication.
Logs will show the state transitions happening step by step.

---

## 👨‍💻 Author

Created by Gabriel Braga — [LinkedIn](https://www.linkedin.com/in/gabriel-braga-da-silva/) |
[Twitter](https://x.com/gbraga_dev) |
[YouTube](https://www.youtube.com/@gabrielbragadev)

---

## 🔗 Related modules

- [FW StateMachine Module](../fw-statemachine/README.md): Implementation **using** the <u>state-machine-framework</u>.
- [Project Root](../README.md): Overview and series link.