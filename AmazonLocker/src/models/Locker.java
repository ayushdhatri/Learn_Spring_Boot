package models;

import enums.LockerSize;
import enums.LockerStatus;

public class Locker {
    private final String id;

    private final LockerSize size;

    private LockerStatus status;

    private Package currentPackage;

    private LockerCode currentCode;

    Locker(String id, LockerSize size){
        this.id = id;
        this.size = size;
        this.status = LockerStatus.AVAILABLE;
        this.currentPackage = null;
        this.currentCode = null;
    }

    public void assignPackage(Package pkg, LockerCode code){
        if(this.status != LockerStatus.AVAILABLE){
            throw new IllegalStateException("Locker : " + id + " is not avaialble");
        }
        this.currentPackage = pkg;
        this.currentCode = code;
        this.status = LockerStatus.OCCUPIED;
    }

    public Package releasePackage(){
        Package pkg = this.currentPackage;
        this.currentCode = null;
        this.currentPackage = null;
        this.status = LockerStatus.AVAILABLE;
        return pkg;
    }

    public boolean isAvailable(){
        return this.status == LockerStatus.AVAILABLE;
    }

    public String getId() { return id; }
    public LockerSize getSize() { return size; }
    public LockerStatus getStatus() { return status; }
    public Package getCurrentPackage() { return currentPackage; }
    public LockerCode getCurrentCode() { return currentCode; }







}
