package cn.game.core.repository.user;

import org.springframework.stereotype.Repository;



import cn.game.core.entity.table.system.Role;
import cn.game.core.repository.HibernateRepositoryImpl;

@Repository
public class RoleRepositoryCustomImpl extends HibernateRepositoryImpl<Role> implements RoleRepositoryCustom {

}
