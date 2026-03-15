# HilbertCurveCreator

> A space-filling curve that somehow makes a straight line feel guilty.

An interactive Java Swing visualization of the **Hilbert curve** — a fractal that fills 2D space without crossing itself. Crank up the order and watch the curve turn into a dense lattice.

## What it does

- Recursively constructs and renders a Hilbert space-filling curve on a resizable `JPanel`
- Supports increasing the order/depth of the curve for progressively finer detail
- Real-time redraw via Java2D graphics

## How it works

The Hilbert curve is built recursively: a first-order curve is a U-shape of 4 segments. Each subsequent order replaces every segment with a rotated/reflected copy of the lower-order curve. `HilbertCreator.java` computes the point sequence using the standard rotation-and-reflection algorithm, then `Panel.java` draws line segments between consecutive points.

## Tech stack

- **Java** (standard library)
- **Java Swing / Java2D** for rendering

## Getting started

### Prerequisites

- Java 8+
- An IDE (IntelliJ IDEA or Eclipse recommended)

### Run

1. Open the project root in IntelliJ IDEA (the `src/` folder is the source root).
2. Run `Main.java`.
3. A window will open showing the Hilbert curve. Adjust the order parameter in the source to increase detail.

### Compile manually

```bash
javac -d out src/*.java
java -cp out Main
```

## Project structure

```
src/
├── Main.java            # entry point, sets up the JFrame
├── Panel.java           # JPanel subclass that draws the curve
└── HilbertCreator.java  # recursive Hilbert curve point generator
```
