package cn.game.core.repository.game;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.game.core.entity.table.game.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> , GameRepositoryCustom{

}
