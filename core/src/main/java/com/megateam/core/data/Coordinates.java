package com.megateam.core.data;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;

		if (!(o instanceof Coordinates coordinates))
			return false;

		if (y != coordinates.y) return false;
		return Objects.equals(x, coordinates.x);
	}

	@Override
	public int hashCode()
	{
		int result = x != null ? x.hashCode() : 0;
		result = 31 * result + y;
		return result;
	}

	public static CoordinatesBuilder builder() {
		return new CoordinatesBuilder();
	}
}
