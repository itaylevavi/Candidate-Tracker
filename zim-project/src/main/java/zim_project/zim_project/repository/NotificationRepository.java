package zim_project.zim_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zim_project.zim_project.model.Notifications;

@Repository
public interface NotificationRepository extends JpaRepository <Notifications, Long>{

}
