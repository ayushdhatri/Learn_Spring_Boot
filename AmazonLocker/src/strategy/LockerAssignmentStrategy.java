package strategy;

import enums.LockerSize;
import models.Locker;

import java.util.List;

public interface LockerAssignmentStrategy {

  Locker assignLocker(LockerSize requiredSize, List<Locker> availableLockers);

}
