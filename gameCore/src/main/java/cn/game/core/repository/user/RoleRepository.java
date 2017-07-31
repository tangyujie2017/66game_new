package cn.game.core.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.game.core.entity.table.system.Role;




@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
  Role findByName(String name);
  Role findByDetails(String details);
}
