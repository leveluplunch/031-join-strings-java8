package com.levelup;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void basic_string_join() {

		StringJoiner stringJoiner = new StringJoiner(" ");

		String concatenatedString = stringJoiner.add("LevelUp").add("Lunch")
				.add("Tutorial").toString();

		assertEquals("LevelUp Lunch Tutorial", concatenatedString);

		String stringJoined = String.join(" ", "LevelUp", "Lunch", "Tutorial");

		assertEquals("LevelUp Lunch Tutorial", stringJoined);
	}

	@Test
	public void join_intstream_values() {

		String intStreamToString = IntStream.of(1, 2, 3, 4)
				.boxed()
				.map(String::valueOf)
				.collect(Collectors.joining(",", "[", "]"));

		assertEquals("[1,2,3,4]", intStreamToString);
	}

	@Test
	public void join_string_csv() {

		String stringToCSV = String.join(",", "hello", "world", "csv");

		assertEquals("hello,world,csv", stringToCSV);

		List<String> randomStrings = new ArrayList<>();
		randomStrings.add("hello");
		randomStrings.add("world");
		randomStrings.add("csv");

		String listToCSV = randomStrings.stream().collect(
				Collectors.joining(","));

		assertEquals("hello,world,csv", listToCSV);

	}

	class Team {

		String name;
		String state;

		public Team(String name, String state) {
			super();
			this.name = name;
			this.state = state;
		}

		public String getName() {
			return name;
		}

	}

	@Test
	public void join_list_objects_values() {

		List<Team> teams = new ArrayList<>();
		teams.add(new Team("Badgers", "Wisconsin"));
		teams.add(new Team("Bearcats", "Ohio"));
		teams.add(new Team("Terrapins", "Maryland"));

		String allTeams = teams.stream().map(Team::getName)
				.collect(Collectors.joining("-"));

		assertEquals("Badgers-Bearcats-Terrapins", allTeams);

	}

	@Test
	public void map_values_to_json() {

		Map<String, String> mapToJson = new HashMap<String, String>();
		mapToJson.put("name", "Justin");
		mapToJson.put("city", "Janesville");
		mapToJson.put("ncaa-team", "UW badgers");

		String json = mapToJson.entrySet().stream()
				.map(Object::toString)
				.collect(Collectors.joining(",", "{", "}"));

		assertEquals("{city=Janesville,name=Justin,ncaa-team=UW badgers}", json);

	}
}
