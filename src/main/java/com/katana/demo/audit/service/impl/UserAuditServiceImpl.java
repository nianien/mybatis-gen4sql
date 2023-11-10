package com.katana.demo.audit.service.impl;

import com.katana.demo.audit.entity.UserAudit;
import com.katana.demo.audit.mapper.UserAuditMapper;
import com.katana.demo.audit.service.IUserAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户审核表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-11-10
 */
@Service
public class UserAuditServiceImpl extends ServiceImpl<UserAuditMapper, UserAudit> implements IUserAuditService {

}
