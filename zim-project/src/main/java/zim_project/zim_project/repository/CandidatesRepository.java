package zim_project.zim_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zim_project.zim_project.model.Candidates;

import java.util.List;

@Repository
public interface CandidatesRepository extends JpaRepository<Candidates, Long> {
    @Query("SELECT c.candidateid AS id, c.name AS name FROM Candidates c")
    List<CandidateProjection> findAllProjectedBy();

}
