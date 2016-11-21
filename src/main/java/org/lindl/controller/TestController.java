package org.lindl.controller;

import java.util.ArrayList;

import org.lindl.entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@ResponseBody
	@RequestMapping(value = "/getData.action")
	public Result getData(int page) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("湖南衡阳原书记高铁站被拷走");
		list.add("广东人大财经委主任委员陈家记被查(图/简历)");
		list.add("媒体：哪所大学培养的政治局常委最多？");
		// list.add("人民日报：官员怕说错话不敢说也是失职");
		// list.add("瑞士国家元首对话新浪：愿支持中国反腐");
		// list.add("李克强大写三个见瑞士联邦主席");
		// list.add("习近平：建设绿色家园是人类的共同梦想");
		// list.add("习近平谈党规:从严治党首先要尊崇党章 这三年");
		// list.add("城管踩烂莲藕 司机辱骂女子");
		// list.add("希拉里扬言要让中国守规矩");
		// list.add("曝郭富城分手互点赞疑破传闻");
		// list.add("女警殴保安 大熊猫交配被拍");
		// list.add("霍建华加盟《明月几时有》");
		// list.add("欧联杯首回合 多特1-1利物浦");
		// list.add("20万内最省油的十款SUV！第一你猜不出");

		return new Result(0, list, "查询成功");
	}
}
