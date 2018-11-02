/**
 * 
 */
package eu.heth.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.heth.bean.Meal;
import eu.heth.bean.MealBean;

/**
 * @author tomey
 *
 */
@RestController
public class MealController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/meal")
	@GetMapping
	public Meal meal(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new MealBean(counter.incrementAndGet() + "", String.format(template, name));
	}
}
