package com.megateam.core.data;

import com.megateam.core.Coordinates;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;

public class Ticket
{
	private Long id;
	private ZonedDateTime creationDate;

	private String name;
	private Coordinates coordinates;
	private Float price;
	private String comment;
	private Boolean refundable;
	private TicketType type;
	private Venue venue;
	public static class TicketBuilder
	{
		private String name;
		private Coordinates coordinates;
		private Float price;
		private String comment;
		private Boolean refundable;
		private TicketType type;
		private Venue venue;

		private TicketBuilder()
		{
		}

		public TicketBuilder setName(String name)
		{
			this.name = name;
			return this;
		}

		public TicketBuilder setCoordinates(Coordinates coordinates)
		{
			this.coordinates = coordinates;
			return this;
		}

		public TicketBuilder setPrice(float price)
		{
			this.price = price;
			return this;
		}

		public TicketBuilder setComment(String comment)
		{
			this.comment = comment;
			return this;
		}

		public TicketBuilder setRefundable(boolean refundable)
		{
			this.refundable = refundable;
			return this;
		}

		public TicketBuilder setType(TicketType type)
		{
			this.type = type;
			return this;
		}

		public TicketBuilder setVenue(Venue venue)
		{
			this.venue = venue;
			return this;
		}

		public Ticket build()
		{
			return new Ticket(this);
		}

	}

	private Ticket(TicketBuilder builder)
	{
		Random random = new Random();
		this.id = random.nextLong(1, Long.MAX_VALUE);
		this.creationDate = ZonedDateTime.now(ZoneId.systemDefault());

		this.name = builder.name;
		this.coordinates = builder.coordinates;
		this.price = builder.price;
		this.comment = builder.comment;
		this.refundable = builder.refundable;
		this.type = builder.type;
		this.venue = builder.venue;
	}

	public Long getId()
	{
		return id;
	}

	public ZonedDateTime getCreationDate()
	{
		return creationDate;
	}

	public String getName()
	{
		return name;
	}

	public Coordinates getCoordinates()
	{
		return coordinates;
	}

	public Float getPrice()
	{
		return price;
	}

	public String getComment()
	{
		return comment;
	}

	public Boolean getRefundable()
	{
		return refundable;
	}

	public TicketType getType()
	{
		return type;
	}

	public Venue getVenue()
	{
		return venue;
	}

}
