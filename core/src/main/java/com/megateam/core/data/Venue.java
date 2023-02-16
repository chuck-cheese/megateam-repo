package com.megateam.core.data;

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

	public static VenueBuilder builder() {
		return new VenueBuilder();
	}
}
