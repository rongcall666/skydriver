/**
 * 
 */
package com.skydriver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jrong
 *
 */
@Mapper
public interface TestMapper {
	void insertA(@Param("id") Integer id, @Param("name") String name);

	void insertB(@Param("id") Integer id, @Param("name") String name);
}
