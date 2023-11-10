package com.katana.demo.uc.service.impl;

import com.katana.demo.uc.entity.UserTag;
import com.katana.demo.uc.mapper.UserTagMapper;
import com.katana.demo.uc.service.IUserTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户标签表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-11-10
 */
@Service
public class UserTagServiceImpl extends ServiceImpl<UserTagMapper, UserTag> implements IUserTagService {

}
