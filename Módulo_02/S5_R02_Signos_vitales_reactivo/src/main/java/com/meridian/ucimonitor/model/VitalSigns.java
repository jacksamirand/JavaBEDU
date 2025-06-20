package com.meridian.ucimonitor.model;

public class VitalSigns {
    private int patientId;
    private int heartRate;
    private int systolicBP;
    private int diastolicBP;
    private int oxygen;

    public VitalSigns(int patientId, int heartRate, int systolicBP, int diastolicBP, int oxygen) {
        this.patientId = patientId;
        this.heartRate = heartRate;
        this.systolicBP = systolicBP;
        this.diastolicBP = diastolicBP;
        this.oxygen = oxygen;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public int getSystolicBP() {
        return systolicBP;
    }

    public int getDiastolicBP() {
        return diastolicBP;
    }

    public int getOxygen() {
        return oxygen;
    }
}
