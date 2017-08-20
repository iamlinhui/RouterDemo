package cn.promptness.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.ColumnType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_image")
public class Image implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "path")
	private String path;

	@ColumnType
	private String info;

	@Column(name = "download_count")
	private Integer downloadCount;

	@Column(name = "like_count")
	private Integer likeCount;

}