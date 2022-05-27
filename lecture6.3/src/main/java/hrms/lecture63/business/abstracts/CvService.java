package hrms.lecture63.business.abstracts;

import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.Cv;
import hrms.lecture63.entities.concretes.JobSeekerJobExperience;
import hrms.lecture63.entities.concretes.JobSeekerSchool;

import java.util.List;

public interface CvService {
    DataResult<List<Cv>> getAll();
    Result add(Cv cv);
    Result addSchoolToCv(int cvId, int jobSeekerSchoolId);
    Result addLanguageToCv(int cvId, int jobSeekerLanguageId);
    Result addJobExperienceToCv(int cvId, int jobSeekerJobExperienceId);
    Result addGithubProfileToCv(int cvId, String githubProfile);
    Result addLinkedinProfileToCv(int cvId, String linkedinProfile);
    Result addCoverLetterToCv(int cvId, String coverLetter);
    Result addSkillToCv(int cvId, String skill);
    DataResult<List<JobSeekerJobExperience>> findJobSeekerJobExperienceOrderByQuitJobDateDesc(int cvId);
    DataResult<List<JobSeekerSchool>> findJobSeekerSchoolOrderByGraduationDateDesc(int cvId);
}
