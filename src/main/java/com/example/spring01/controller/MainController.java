package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;



//Controller 빈으로 등록
@Controller
public class MainController {
	//로깅 변수
	private static final Logger logger=LoggerFactory.getLogger(MainController.class);
	
	//url 요청 매핑처리
	@RequestMapping("/")
	public String main(Model model) {
		//Model은 자료저장용 객체(서블릿 request객체와 같은 역할)
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		return "main"; // WEB-INF/views/main.jsp로 포워딩(스프링은 기본값이 포워딩이다, 리다이렉트는 별도로 지정)
	}
	
	@RequestMapping("gugu.do") //url mapping
	public String gugu(Model model, @RequestParam(defaultValue = "2") int dan) {
		//int dan=7;
		String result="";
		for(int i=1; i<=9; i++) {
			result += dan + "x" + i + "=" + dan*i + "<br>";
		}
		//Model에 자료 저장
		model.addAttribute("result", result);
		return "test/gugu"; //views/test/gugu.jsp로 포워딩
	}
	
	@RequestMapping("test.do")
	public void test() {
		//리턴 타입이 void인 경우 메소드 name(test())과 같은 페이지로 포워딩
		//WEB-INF/views/test.jsp로 자동 포워딩 함.
	}
	
	@RequestMapping("test/doA")
	public String doA(Model model) {
		//request.setAttribute("message", "홈페이지 방문을 환영합니다.");
		//String page="/test/doA.jsp";
		//RequestDispatcher rd=request.getRequestDispatcher(page);
		//rd.forward(request, response);
		
		//자료 저장
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		//포워딩
		return "test/doA";
	}
	
	@RequestMapping("test/doB")
	public void doB() {
		logger.info("doB 호출...");
	}
	
	@RequestMapping("test/doC")
	public ModelAndView doC() {
		Map<String,Object> map= new HashMap<>();
		map.put("product", new ProductDTO("샤프", 1000));
		return new ModelAndView("test/doC", "map", map);	
	}
	
	@RequestMapping("test/doD")
	public String doD() {
		//forward : 주소는 그대로, 화면 이동, 데이터 전달
		//redirect : 주소 변경, 화면 이동, get방식의 소량의 데이터에 적합
		//스프링은 jsp와 달리 기본값이 forward이다.
		
		return "redirect:/test/doE"; //다시 Controller를 호출한 후에 test/doE로 이동
	}
	
	@RequestMapping("test/doE")
	public void doE() {
		//void는 doE.jsp로 포워딩
	}
	
	//@RestController - 스프링4.0이상 부터 사용 가능
	
	/*
	 * @ResponseBody //자바객체인 dto를 json형식으로 변환
	 * 
	 * @RequestMapping("test/doF") public ProductDTO doF() { return new
	 * ProductDTO("냉장고", 5000000); }
	 */


}
