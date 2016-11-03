package com.example.usuario.pruebawebsservice.objects;

/**
 * Created by Usuario on 27/10/2016.
 */

public class Convertion {
    private double fromWeight;
    private double toWeight;
    private String fromUnit;
    private String toUnit;

    @Override
    public String toString() {
        return fromWeight + " " + fromUnit + " " + toWeight + " " + toUnit;
    }

    public double getFromWeight() {
        return fromWeight;
    }

    public void setFromWeight(double fromWeight) {
        this.fromWeight = fromWeight;
    }

    public double getToWeight() {
        return toWeight;
    }

    public void setToWeight(double toWeight) {
        this.toWeight = toWeight;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }
}
