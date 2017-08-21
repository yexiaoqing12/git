package cn.itcast.controller.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDate implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
//		Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(arg0);
		
		return null;
	}

}
