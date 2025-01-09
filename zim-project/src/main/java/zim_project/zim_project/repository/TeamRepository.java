package zim_project.zim_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zim_project.zim_project.model.Teams;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Teams, Long> {

    ;

}
