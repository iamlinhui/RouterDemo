package cn.promptness.service;

import cn.promptness.pojo.Image;

public interface ImageService extends BaseService<Image>{
	
	public Image getById(Integer id);

}
