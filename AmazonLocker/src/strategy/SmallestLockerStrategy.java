package strategy;

import enums.LockerSize;
import exceptions.NoAvailableLockerException;
import models.Locker;

import java.util.List;

public class SmallestLockerStrategy implements LockerAssignmentStrategy{

    @Override
    public Locker assignLocker(LockerSize requiredSize, List<Locker> availableLockers) {
        LockerSize[] sizes = LockerSize.values();

        for(int i = requiredSize.ordinal();i < sizes.length ; i++){
            LockerSize targetSize = sizes[i];
            for(Locker locker : availableLockers){
                if(locker.isAvailable() && locker.getSize().equals(targetSize)){
                    return locker;
                }
            }
        }
        throw new NoAvailableLockerException(
                "No available locker for size " + requiredSize + " or larger"
        );


    }
}
