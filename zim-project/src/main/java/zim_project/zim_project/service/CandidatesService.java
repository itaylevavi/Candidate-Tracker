package zim_project.zim_project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zim_project.zim_project.model.Candidates;
import zim_project.zim_project.repository.CandidatesRepository;

@Service
public class CandidatesService {

    @Autowired
    private CandidatesRepository candidatesRepository;

    public Candidates save(Candidates candidate) {
        return candidatesRepository.save(candidate);
    }
}
