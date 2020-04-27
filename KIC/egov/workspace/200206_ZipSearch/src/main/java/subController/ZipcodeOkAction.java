package subController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.ZipDAO;
import model.ZipcodeDAO;
import model.ZipcodeTO;

public class ZipcodeOkAction implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

//		System.out.println(this.getClass().getName() + " method call execute");
//		
//		System.out.println(request.getParameter("dong"));
//		
		
		String strDong = request.getParameter("dong");
		
//		ZipDAO zDao = new ZipDAO();
		ZipcodeDAO zDao = new ZipcodeDAO();
		
		ArrayList<ZipcodeTO> zipcodeList = zDao.zipcodeList(strDong);
		
		for(ZipcodeTO zto : zipcodeList) {
			System.out.println(zto.getSeq());			
		}
		
		ModelAndView modelAndView = new ModelAndView("zipcode_ok");
		modelAndView.addObject("dong", zipcodeList);
		modelAndView.addObject("data", "새로운 데이터");
//		request.setAttribute("data", "새로운 데이터");
		
		return modelAndView;
	}

}
