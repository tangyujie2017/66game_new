package cn.game.core.repository.game;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cn.game.core.entity.table.game.Game;
import cn.game.core.repository.HibernateRepositoryImpl;

public class GameRepositoryImpl extends HibernateRepositoryImpl<Game> implements GameRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
}
