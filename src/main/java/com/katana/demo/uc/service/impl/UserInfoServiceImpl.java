package com.katana.demo.uc.service.impl;

import com.katana.demo.uc.entity.UserInfo;
import com.katana.demo.uc.mapper.UserInfoMapper;
import com.katana.demo.uc.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-11-10
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
