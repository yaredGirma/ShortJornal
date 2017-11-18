package edu.mum.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.domain.Duration;
import edu.mum.domain.Event;
import edu.mum.domain.Feeling;
import edu.mum.domain.Frequency;
import edu.mum.domain.Type;
import edu.mum.domain.UserCredentials;
import edu.mum.service.DurationService;
import edu.mum.service.EventService;
import edu.mum.service.FeelingService;
import edu.mum.service.FrequencyService;
import edu.mum.service.TypeService;
import edu.mum.service.UserCredentialsService;

@Controller
@SessionAttributes(value = { "feelings", "types", "durations", "frequencies" })
public class EventController {

	@Autowired
	UserCredentialsService userCredentialsService;

	@Autowired
	EventService eventService;

	@Autowired
	FeelingService feelingService;

	@Autowired
	DurationService durationService;

	@Autowired
	TypeService typeService;

	@Autowired
	FrequencyService frequencyService;

	@RequestMapping(value = "/editEvent/{id}", method = RequestMethod.GET)
	public String editEvent(Model model, @PathVariable("id") Long eventId) {
		Event thEvent = eventService.findOne(eventId);
		model.addAttribute("event", thEvent);
		List<Feeling> feelings = feelingService.getAll();
		List<Duration> durations = durationService.getAll();
		List<Type> types = typeService.getAll();
		List<Frequency> frequencies = frequencyService.getAll();
		model.addAttribute("feelings", feelings);
		model.addAttribute("types", types);
		model.addAttribute("durations", durations);
		model.addAttribute("frequencies", frequencies);
		
		return "editEvent";
	}
	
	@RequestMapping(value = "/editEvent", method = RequestMethod.POST)
	public String editEvent(@Valid @ModelAttribute Event event, BindingResult result, Model model, SessionStatus status, Principal principal) {
		if(result.hasErrors()) {
			model.addAttribute("event", event);
			return "editEvent";
		}
		
		event.setUser(userCredentialsService.findByUsername(principal.getName()));
		eventService.save(event);
		status.setComplete();
		
		return "redirect:/viewEvents";
	}
	
	@RequestMapping(value = "/events/remove/{eventId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeEvent(@PathVariable("eventId") Long eventId) {
		eventService.delete(eventService.findOne(eventId));
	}
	
	@RequestMapping(value = "/addEvent", method = RequestMethod.GET)
	public String addEvent(@ModelAttribute("newEvent") Event event, Model model) {
		List<Feeling> feelings = feelingService.getAll();
		List<Duration> durations = durationService.getAll();
		List<Type> types = typeService.getAll();
		List<Frequency> frequencies = frequencyService.getAll();
		model.addAttribute("feelings", feelings);
		model.addAttribute("types", types);
		model.addAttribute("durations", durations);
		model.addAttribute("frequencies", frequencies);
		return "addEvent";
	}

	@RequestMapping(value = "/viewEvents", method = RequestMethod.GET)
	public String viewEvents(Model model, Principal principal) {
		List<Event> events = eventService.findByUser(userCredentialsService.findByUsername(principal.getName()));
		model.addAttribute("events", events);

		return "viewEvents";
	}

	@RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	public String addEvent(@Valid @ModelAttribute("newEvent") Event event, BindingResult result, Principal principal,
			Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "addEvent";
		}

		UserCredentials userCredentials = userCredentialsService.findByUsername(principal.getName());
		event.setUser(userCredentials);

		eventService.save(event);
		status.setComplete();

		return "redirect:/viewEvents";
	}
}
