package cn.promptness.service;

import java.util.List;

public interface BaseService<T> {

	// 根据id查询
	T queryById(Long id);

	// 查询所有
	List<T> queryAll();

	// 根据条件查询数据条数
	Integer queryCountByWhere(T t);

	// 根据条件查询数据
	List<T> queryListByWhere(T t);

	// 分页查询
	List<T> queryByPage(Integer page, Integer rows);

	// 根据条件查询一条数据
	T queryOne(T t);

	// 新增，不忽略空参数
	void save(T t);

	// 新增，忽略空参数
	void saveSelective(T t);

	// 更新，不忽略空参数
	void updateById(T t);

	// 更新，忽略空参数
	void updateByIdSelective(T t);

	// 根据id删除
	void deleteById(Long id);

	// 根据多个id进行批量删除
	void deleteByIds(List<Object> ids);

}