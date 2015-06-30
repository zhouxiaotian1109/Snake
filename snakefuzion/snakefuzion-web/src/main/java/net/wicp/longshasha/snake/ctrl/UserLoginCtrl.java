package net.wicp.longshasha.snake.ctrl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.wicp.longshasha.snake.service.entity.SfUser;

import org.nutz.json.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @project snakefuzion-web
 * @classpath net.wicp.longshasha.snake.ctrl.UserLoginCtrl
 * @author 陈雨清 2015年6月30日 下午3:52:47
 */
@Controller
@RequestMapping("/userlogin")
public class UserLoginCtrl {
	@RequestMapping("/welcome")
	public ModelAndView welcome(ModelAndView mav, HttpServletRequest request, HttpServletResponse response, RedirectAttributes attr) throws Exception {
		System.out.println("welcom to UserLoginCtrl");
		Map<String, String> cookies = getCookieMap(request);
		if ("true".equals(cookies.get("autologin")) //
				&& "true".equals(cookies.get("remember"))//
				&& !"".equals(cookies.get("name"))//
				&& !"".equals(cookies.get("pwd"))) {
			attr.addAttribute("autologin", "true");
			attr.addAttribute("remember", "true");
			attr.addAttribute("name", URLDecoder.decode(cookies.get("name"), "UTF-8"));
			attr.addAttribute("pwd", cookies.get("pwd"));
			mav.setViewName("redirect:/userlogin/login.ctrl");
		} else {
			if ("true".equals(cookies.get("remember"))//
					&& !"".equals(cookies.get("name"))//
					&& !"".equals(cookies.get("pwd"))) {
				Map<String, String> loginInfo = new HashMap<String, String>();
				loginInfo.put("name", cookies.get("name"));
				loginInfo.put("pwd", cookies.get("pwd"));
				loginInfo.put("remember", "true");
				mav.addObject("loginInfo", loginInfo);
			}
			mav.setViewName("/login");
		}
		/*
		 * Cookie cookie = new Cookie("washmore", "shuaibushuai"); //
		 * cookie.setMaxAge(3600*24); // 设置路径，这个路径即该工程下都可以访问该cookie
		 * 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问 cookie.setPath("/");
		 * response.addCookie(cookie); System.out.println();
		 */
		return mav;
	}

	private Map<String, String> getCookieMap(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		for (Cookie cookie : cookies) {
			map.put(cookie.getName(), cookie.getValue());
		}
		return map;
	}

	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mav, @RequestParam Map<String, String> loginInfo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(Json.toJson(loginInfo));
		if (loginInfo.get("name") != null) {
			loginInfo.put("name", new String(loginInfo.get("name").getBytes("ISO8859-1"), "utf-8"));
		}
		if ("张三".equals(loginInfo.get("name")) && "123456".equals(loginInfo.get("pwd"))) {
			SfUser user = new SfUser();
			user.setUserName(loginInfo.get("name"));
			user.setUserPwd(loginInfo.get("pwd"));
			request.getSession().setAttribute("user", user);
			if (loginInfo.get("remember") != null) {
				Cookie cookie1 = new Cookie("remember", "true");
				cookie1.setMaxAge(60 * 60 * 24 * 7);
				Cookie cookie2 = new Cookie("name", URLEncoder.encode(loginInfo.get("name"), "UTF-8"));
				cookie2.setMaxAge(60 * 60 * 24 * 7);
				Cookie cookie3 = new Cookie("pwd", loginInfo.get("pwd"));
				cookie3.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				response.addCookie(cookie3);
			}
			if (loginInfo.get("autologin") != null) {
				Cookie cookie = new Cookie("autologin", "true");
				cookie.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(cookie);
			}
			mav.setViewName("loginsuccess");
		} else {
			mav.addObject("error", "账号或者密码错误");
			mav.setViewName("/login");
		}
		return mav;
	}
}
