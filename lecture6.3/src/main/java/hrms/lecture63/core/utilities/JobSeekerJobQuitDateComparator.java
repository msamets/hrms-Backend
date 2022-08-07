package hrms.lecture63.core.utilities;

import hrms.lecture63.entities.concretes.JobSeekerJobExperience;

import java.util.Comparator;

public class JobSeekerJobQuitDateComparator implements Comparator<JobSeekerJobExperience> {
    //null first desc date sorting
    @Override
    public int compare(JobSeekerJobExperience o1, JobSeekerJobExperience o2) {
        //null first part
        if(o1.getQuitJobDate() == null && o2.getQuitJobDate() == null)
            return 0;
        else if(o1.getQuitJobDate() == null)
            return -1;
        else if(o2.getQuitJobDate() == null){
            return 1;
        }

        else{//desc sort part
            int result = o1.getQuitJobDate().compareTo(o2.getQuitJobDate());
            result = (-1) * result;
            if(result == 0)
                result = o1.getQuitJobDate().compareTo(o2.getQuitJobDate());

            return result;
        }
    }
}
