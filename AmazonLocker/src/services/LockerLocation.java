package services;

import enums.LockerSize;
import models.Locker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LockerLocation {
    private final String id;

    private final String address;

    private Map<String, Locker> lockers = new ConcurrentHashMap<>();

    public LockerLocation(String id, String address){
        this.id  =id;
        this.address  = address;
    }

    public void addLocker(Locker locker){
        String lockerId = locker.getId();
        if(lockers.containsKey(lockerId)){
            throw new IllegalArgumentException("Locker with Id" + lockerId + " already exist");
        }
        this.lockers.put(lockerId, locker);
    }

    public List<Locker> getAllLocker(){
        List<Locker> allLockers = new ArrayList<>();
        for(Map.Entry<String, Locker> entrySet : lockers.entrySet()){
            allLockers.add(entrySet.getValue());
        }
        return allLockers;
    }

    public List<Locker> getAvailableLockerBySize(LockerSize size){
        List<Locker> allLockers = new ArrayList<>();
        for(Map.Entry<String, Locker> entrySet : lockers.entrySet()){
            if(entrySet.getValue().getSize().equals(size) && entrySet.getValue().isAvailable())
                allLockers.add(entrySet.getValue());
        }
        return allLockers;
    }

    public Locker getLocker(String lockerId) {
        Locker locker = lockers.get(lockerId);
        if (locker == null) {
            throw new IllegalArgumentException("Locker " + lockerId + " not found at location " + id);
        }
        return locker;
    }

    public String getId() { return id; }
    public String getAddress() { return address; }










}
