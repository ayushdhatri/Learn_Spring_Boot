package strategy;

import enums.LockerSize;
import models.Locker;

import java.util.List;

public class SmallestLockerStrategy implements LockerAssignmentStrategy{

    @Override
    public Locker assignLocker(LockerSize requiredSize, List<Locker> availableLockers) {
        LockerSize[] sizes = LockerSize.values();

        for(int i = requiredSize.ordinal();i < sizes.length ; i++){
            LockerSize targetSize = sizes[i];
            for(Locker locker : availableLockers){
                if(locker)
            }

        }


    }
}
