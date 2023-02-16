package com.megateam.core.data;

public class Coordinates {

	private Float x;
	private int y;

	public static class CoordinatesBuilder {

		private Float x;
		private int y;

		private CoordinatesBuilder() {}

		public CoordinatesBuilder setX(Float x) {
			this.x = x;
			return this;
		}

		public CoordinatesBuilder setY(int y) {
			this.y = y;
			return this;
		}

		public Coordinates build() {
			return new Coordinates(this);
		}
	}

	private Coordinates(CoordinatesBuilder builder) {
		this.x = builder.x;
		this.y = builder.y;
	}

	public Float getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString()
	{
		return String.format("Coordinates: (%f, %d)", x, y);
	}

	public static CoordinatesBuilder builder() {
		return new CoordinatesBuilder();
	}
}
