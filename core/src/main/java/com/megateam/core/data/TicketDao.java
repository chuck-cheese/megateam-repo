package com.megateam.core.data;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Ticket> {

	private final List<Ticket> tickets;
	private ZonedDateTime creationDate;

	public TicketDao() {
		this.tickets = new ArrayList<>();
		this.creationDate = ZonedDateTime.now(ZoneId.systemDefault());
	}

	@Override
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	@Override
	public void add(Ticket item) {
		if (item != null) tickets.add(item);
	}

	@Override
	public Optional<Ticket> get(long id) {
		for (Ticket ticket : tickets) if (
			ticket.getId().equals(id)
		) return Optional.of(ticket);

		return Optional.empty();
	}

	@Override
	public List<Ticket> getAll() {
		return tickets;
	}

	@Override
	public void update(long id, Ticket item) {
		if (item == null) return;

		for (Ticket ticket : tickets) {
			if (ticket.getId().equals(id)) {
				tickets.set(tickets.indexOf(ticket), item);
				return;
			}
		}
	}

	@Override
	public void delete(long id) {
		for (Ticket ticket : tickets) {
			if (ticket.getId().equals(id)) {
				tickets.remove(ticket);
				return;
			}
		}
	}

	@Override
	public void clear() {
		tickets.clear();
	}

	@Override
	public void removeFirst() {
		if (tickets.size() > 0) tickets.remove(0);
	}

	@Override
	public void removeLast() {
		if (tickets.size() > 0) tickets.remove(tickets.size() - 1);
	}
}
