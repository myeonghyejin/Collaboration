package com.mhj.s2.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mhj.s2.util.Pagination;

@Controller
@RequestMapping(value="/qna/*")
public class QNAController {

	@Autowired
	private QNAService qnaService;
	
	/** SELECT **/
	//List
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getQNAList(Pagination pagination) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<QNADTO> ar = qnaService.getQNAList(pagination);
		
		modelAndView.setViewName("qna/list");
		modelAndView.addObject("list", ar);
		modelAndView.addObject("pagination", pagination);
		
		return modelAndView;
	}
	
	//Detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getQNADetail(QNADTO qnaDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		qnaDTO = qnaService.getQNADetail(qnaDTO);
		
		modelAndView.setViewName("qna/detail");
		modelAndView.addObject("detail", qnaDTO);
		
		return modelAndView;
	}
	
	/** INSERT **/
	//Add (입력 폼으로 이동)
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView setQNAAdd(QNADTO qnaDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("qna/add");
		
		return modelAndView;
	}
	
	//Add (DB에 INSERT)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setQNAAdd(QNADTO qnaDTO, MultipartFile multipartFile, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = qnaService.setQNAAdd(qnaDTO, multipartFile);
		
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	
	/** UPDATE **/
	//Update (입력 폼으로 이동)
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setQNAUpdate(QNADTO qnaDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		qnaDTO = qnaService.getQNADetail(qnaDTO);
		
		modelAndView.setViewName("qna/update");
		modelAndView.addObject("DTO", qnaDTO);
		
		return modelAndView;
	}
	
	//Update (DB에 INSERT)
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView setQNAUpdate(ModelAndView modelAndView, QNADTO qnaDTO) throws Exception {
		
		int result = qnaService.setQNAUpdate(qnaDTO);
		
		modelAndView.setViewName("redirect:./detail?qnaNum" + qnaDTO.getQnaNum().toString());
		
		return modelAndView;
	}
	
	/** DELETE **/
	//Delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView setQNADelete(QNADTO qnaDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = qnaService.setQNADelete(qnaDTO);
		
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	
}
