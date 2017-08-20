package cn.promptness.mapper;

import cn.promptness.pojo.Image;
import tk.mybatis.mapper.common.Mapper;

public interface ImageMapper extends Mapper<Image>{
	
	public Image getById(Integer id);

}