package com.ichuang.gulimall.member.dao;

import com.ichuang.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author iChuang
 * @email 963592390@qq.com
 * @date 2022-08-08 16:22:05
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
