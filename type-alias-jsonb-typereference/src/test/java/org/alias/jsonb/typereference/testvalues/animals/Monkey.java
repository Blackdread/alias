package org.alias.jsonb.typereference.testvalues.animals;

import java.util.Objects;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

import org.alias.annotation.TypeAlias;

@TypeAlias("Monkey")
public class Monkey implements Animal {

	private final String name;

	@JsonbCreator
	public Monkey(@JsonbProperty(value = "name") String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Monkey [name=" + name + "]";
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null) {
			return false;
		}
		if (!getClass().equals(other.getClass())) {
			return false;
		}
		Monkey castOther = (Monkey) other;
		return Objects.equals(name, castOther.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}