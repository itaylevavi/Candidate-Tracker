package zim_project.zim_project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import zim_project.zim_project.model.Stages;

public interface StageRepository extends JpaRepository<Stages, Long> {
}