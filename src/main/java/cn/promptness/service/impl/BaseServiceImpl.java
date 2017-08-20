package cn.promptness.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.promptness.service.BaseService;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private Mapper<T> mapper;

	Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType ptype = (ParameterizedType) type;
		this.clazz = (Class<T>) ptype.getActualTypeArguments()[0];
	}

	@Override
	public T queryById(Long id) {
		T t = this.mapper.selectByPrimaryKey(id);
		return t;
	}

	@Override
	public List<T> queryAll() {
		List<T> list = this.mapper.select(null);
		return list;
	}

	@Override
	public Integer queryCountByWhere(T t) {
		int count = this.mapper.selectCount(t);
		return count;
	}

	@Override
	public List<T> queryListByWhere(T t) {
		List<T> list = this.mapper.select(t);
		return list;
	}

	@Override
	public List<T> queryByPage(Integer page, Integer rows) {
		// 设置分页条件
		PageHelper.startPage(page, rows);
		// 执行查询
		List<T> list = this.mapper.select(null);
		return list;
	}

	@Override
	public T queryOne(T t) {
		T result = this.mapper.selectOne(t);
		return result;
	}

	@Override
	public void save(T t) {
		this.mapper.insert(t);
	}

	@Override
	public void saveSelective(T t) {
		this.mapper.insertSelective(t);
	}

	@Override
	public void updateById(T t) {
		this.mapper.updateByPrimaryKey(t);
	}

	@Override
	public void updateByIdSelective(T t) {
		this.mapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void deleteById(Long id) {
		this.mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(List<Object> ids) {
		// 声明删除条件
		Example example = new Example(this.clazz);
		example.createCriteria().andIn("id", ids);

		// 执行批量删除
		this.mapper.deleteByExample(example);
	}

}
