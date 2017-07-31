package cn.game.core.repository.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.game.core.entity.table.system.Authority;




@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long>, AuthorityRepositoryCustom {
   
    
    
}
