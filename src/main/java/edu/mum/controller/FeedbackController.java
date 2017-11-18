package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.domain.FeedBack;
import edu.mum.service.FeedBackService;

@Controller
@RequestMapping({ "/feedback" })

public class FeedbackController {
	@Autowired
	private FeedBackService FeedBackService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewMemberForm(@ModelAttribute("newfeedback") FeedBack newfeedback) {
		return "AddFeedback";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewMemberForm(@Valid @ModelAttribute("newfeedback") FeedBack newfeedback,
			BindingResult result) {

		if (result.hasErrors()) {
			return "AddFeedback";
		}

		// Error caught by ControllerAdvice IF no authorization...
		FeedBackService.save(newfeedback);

		return "redirect:/feedback/feedbackList";

	}

	@RequestMapping(value = "/feedbackList", method = RequestMethod.GET)
	public String listMembers(Model model) {
		model.addAttribute("allFeedBack", FeedBackService.getAllFeedBacks());
		return "feedbackList";
	}

	@RequestMapping(value = "/feedbackDetail/{id}", method = RequestMethod.GET)
	public String getMemberById(@PathVariable("id") String id, Model model) {
		FeedBack feedbacksDetail = FeedBackService.findOne(Long.parseLong(id));

		model.addAttribute("feedbackDetail", feedbacksDetail);
		return "feedbackDetail";
	}

	/*@RequestMapping(value = "/ridefeedbacks/{rideNumber}", method = RequestMethod.GET)
	public String getfeedbackByrideNumber(@PathVariable("rideNumber") String rideNumber, Model model) {

		model.addAttribute("allFeedback", FeedBackService.findByRideNumber(Integer.parseInt(rideNumber)));

		return "feedbackList";
	}
*/
	@RequestMapping(value = "/editFeedback/{id}", method = RequestMethod.GET)
	public String editFeedback(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttribute) {
		FeedBack newfeedback = FeedBackService.findOne(Long.parseLong(id));
		redirectAttribute.addFlashAttribute("newfeedback", newfeedback);
		return "redirect:/feedback/add";
	}

	
	@RequestMapping(value = "/deleteFeedback/{id}", method = RequestMethod.GET)
	public String deleteFeedbacks(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttribute) {
		FeedBackService.delete(Long.parseLong(id));
		return "redirect:/feedback/feedbackList";
	}
	/*@RequestMapping(value = "/deleteFeedbacks/{id}", method = RequestMethod.GET)
	public String deleteFeedbacks(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttribute) {
		int rideNumber = FeedBackService.findOne(Long.parseLong(id)).getRideNumber();
		FeedBackService.delete(Long.parseLong(id));
		return "redirect:/feedback/ridefeedbacks/"+ rideNumber;
	}*/
}
