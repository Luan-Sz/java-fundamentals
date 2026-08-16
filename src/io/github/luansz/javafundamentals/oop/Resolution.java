package io.github.luansz.javafundamentals.oop;

public class Resolution {
    private int resolutionTime;
    private String resolvedBy;

    //constructor
    public Resolution(int resolutionTime, String resolvedBy) {
        if (resolutionTime <= 0) {
            throw new IllegalArgumentException("Resolution time must be greater than zero");
        }
        this.resolutionTime = resolutionTime;

        if (resolvedBy == null || resolvedBy.isBlank()) {
            throw new IllegalArgumentException("The name of who resolved must be placed");
        }
        this.resolvedBy = resolvedBy;
    }

    //Getters
    public int getResolutionTime() {
        return resolutionTime;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }
}
