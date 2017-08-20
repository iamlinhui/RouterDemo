package cn.promptness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.promptness.mapper.ImageMapper;
import cn.promptness.pojo.Image;
import cn.promptness.service.ImageService;

@Service
public class ImageServiceImpl extends BaseServiceImpl<Image> implements ImageService {

	@Autowired
	ImageMapper imageMapper;

	public Image getById(Integer id) {
		return imageMapper.getById(id);
	}
}