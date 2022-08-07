package hrms.lecture63.core.utilities.results;

import hrms.lecture63.entities.concretes.JobSeekerSchool;

import java.util.Comparator;

public class JobSeekerSchoolGraduationDateComparator implements Comparator<JobSeekerSchool> {
    @Override
    public int compare(JobSeekerSchool o1, JobSeekerSchool o2) {
        //null first part
        if(o1.getGraduationSchoolDate() == null && o2.getGraduationSchoolDate() == null)
            return 0;
        else if(o1.getGraduationSchoolDate() == null)
            return -1;
        else if(o2.getGraduationSchoolDate() == null)
            return 1;

        else{
            int result = o1.getGraduationSchoolDate().compareTo(o2.getGraduationSchoolDate());
            result = (-1) * result;
            if(result == 0)
                result = o1.getGraduationSchoolDate().compareTo(o2.getGraduationSchoolDate());

            return result;
        }
    }

}
