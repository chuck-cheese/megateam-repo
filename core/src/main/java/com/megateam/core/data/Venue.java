package com.megateam.core.data;

import java.util.Objects;
import java.util.Random;

public class Venue {

	int id;
	String name;
	Long capacity;
	VenueType type;

	public static class VenueBuilder {

		private String name;
		private Long capacity;
		private VenueType type;

		public VenueBuilder() {}

		public VenueBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public VenueBuilder setCapacity(Long capacity) {
			this.capacity = capacity;
			return this;
		}

		public VenueBuilder setType(VenueType type) {
			this.type = type;
			return this;
		}

		public Venue build() {
			return new Venue(this);
		}
	}

	private Venue(VenueBuilder builder) {
		Random random = new Random();
		this.id = random.nextInt(1, Integer.MAX_VALUE);

		this.name = builder.name;
		this.capacity = builder.capacity;
		this.type = builder.type;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getCapacity() {
		return capacity;
	}

	public VenueType getType() {
		return type;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Venue:").append('\n');
		sb.append(String.format("id: %d", id)).append('\n');
		sb.append(String.format("name: %s", name)).append('\n');
		sb.append(String.format("capacity: %d", capacity)).append('\n');
		sb.append(String.format("type: %s", (type == null) ? "is not defined" : type.name())).append('\n');

		return sb.toString();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;

		if (!(o instanceof Venue venue))
			return false;

		if (id != venue.id) return false;
		if (!Objects.equals(name, venue.name)) return false;
		if (!Objects.equals(capacity, venue.capacity)) return false;
		return type == venue.type;
	}

	@Override
	public int hashCode()
	{
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		return result;
	}

	public static VenueBuilder builder() {
		return new VenueBuilder();
	}
}
