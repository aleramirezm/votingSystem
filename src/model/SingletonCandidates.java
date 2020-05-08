package model;

import java.util.ArrayList;
import java.util.List;

public class SingletonCandidates {
    private static SingletonCandidates singletonCandidates;
    private List<Candidate> candidateList = null;

    private SingletonCandidates(){
        candidateList = new ArrayList<>();
    }
    public static SingletonCandidates createInstance(){
        if(singletonCandidates == null){
            synchronized (SingletonCandidates.class) {
                if(singletonCandidates == null){
                    singletonCandidates = new SingletonCandidates();
                }
            }
        }
        return singletonCandidates;
    }

    public void addCandidate(Candidate person){
        this.candidateList.add(person);

    }

    public List<Candidate> candidateList(){
        return this.candidateList;
    }

}
