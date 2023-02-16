package com.megateam.core.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Random;

@JacksonXmlRootElement(localName = "ticket")
public class Ticket implements Comparable<Ticket> {

	@JacksonXmlProperty(localName = "id")
	private Long id;
	@JacksonXmlProperty(localName = "creationDate")
	private ZonedDateTime creationDate;

	@JacksonXmlProperty(localName = "name")
	private String name;
	@JacksonXmlProperty(localName = "coordinates")
	private Coordinates coordinates;
	@JacksonXmlProperty(localName = "price")
	private Float price;
	@JacksonXmlProperty(localName = "comment")
	private String comment;
	@JacksonXmlProperty(localName = "refundable")
	private Boolean refundable;
	@JacksonXmlProperty(localName = "type")
	private TicketType type;
	@JacksonXmlProperty(localName = "venue")
	private Venue venue;

	@Override
	public int compareTo(Ticket ticket)
	{
		if (ticket.equals(this))
			return 0;

		return (id < ticket.id) ? -1 : 1;
	}

	public static class TicketBuilder {

		private String name;
		private Coordinates coordinates;
		private Float price;
		private String comment;
		private Boolean refundable;
		private TicketType type;
		private Venue venue;

		private TicketBuilder() {}

		public TicketBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public TicketBuilder setCoordinates(Coordinates coordinates) {
			this.coordinates = coordinates;
			return this;
		}

		public TicketBuilder setPrice(float price) {
			this.price = price;
			return this;
		}

		public TicketBuilder setComment(String comment) {
			this.comment = comment;
			return this;
		}

		public TicketBuilder setRefundable(boolean refundable) {
			this.refundable = refundable;
			return this;
		}

		public TicketBuilder setType(TicketType type) {
			this.type = type;
			return this;
		}

		public TicketBuilder setVenue(Venue venue) {
			this.venue = venue;
			return this;
		}

		public Ticket build() {
			return new Ticket(this);
		}
	}

	private Ticket(TicketBuilder builder) {
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

	public Long getId() {
		return id;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public String getName() {
		return name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public Float getPrice() {
		return price;
	}

	public String getComment() {
		return comment;
	}

	public Boolean getRefundable() {
		return refundable;
	}

	public TicketType getType() {
		return type;
	}

	public Venue getVenue() {
		return venue;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Ticket:").append('\n');
		sb.append(String.format("id: %d", id)).append('\n');
		sb.append(String.format("creationDate: %s", creationDate.toString())).append('\n');
		sb.append(String.format("name: %s", name)).append('\n');
		sb.append(String.format("coordinates: %s", coordinates.toString())).append('\n');
		sb.append(String.format("price: %f", price)).append('\n');
		sb.append(String.format("comment: %s", comment)).append('\n');
		sb.append(String.format("refundable: %b", refundable)).append('\n');
		sb.append(String.format("type: %s", (type == null) ? "not defined" : type.name())).append('\n');
		sb.append(String.format("venue: %s", venue.toString())).append('\n');

		return sb.toString();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;

		if (!(o instanceof Ticket ticket))
			return false;

		if (!Objects.equals(id, ticket.id)) return false;
		if (!Objects.equals(creationDate, ticket.creationDate))
			return false;
		if (!Objects.equals(name, ticket.name)) return false;
		if (!Objects.equals(coordinates, ticket.coordinates)) return false;
		if (!Objects.equals(price, ticket.price)) return false;
		if (!Objects.equals(comment, ticket.comment)) return false;
		if (!Objects.equals(refundable, ticket.refundable)) return false;
		if (type != ticket.type) return false;
		return Objects.equals(venue, ticket.venue);
	}

	@Override
	public int hashCode()
	{
		int result = id.hashCode();
		result = 31 * result + creationDate.hashCode();

		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (comment != null ? comment.hashCode() : 0);
		result = 31 * result + (refundable != null ? refundable.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (venue != null ? venue.hashCode() : 0);
		return result;
	}

	public static TicketBuilder builder()
	{
		return new TicketBuilder();
	}
}
