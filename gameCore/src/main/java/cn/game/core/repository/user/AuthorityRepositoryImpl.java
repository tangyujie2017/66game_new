package cn.game.core.repository.user;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cn.game.core.entity.table.system.Authority;
import cn.game.core.repository.HibernateRepositoryImpl;
public class AuthorityRepositoryImpl extends HibernateRepositoryImpl<Authority> implements AuthorityRepositoryCustom {


  @PersistenceContext
  private EntityManager entityManager;

 


}