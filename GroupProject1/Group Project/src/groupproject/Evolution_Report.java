/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

/**
 *
 * @author Yasara JLP
 */
public class Evolution_Report {

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }
    private String applicationID,nameOfTheSurvayor;
    private String areaRatios;
    private String park;
    private String covesOfHolding;
    private String drainwater;
    private boolean isSurvayorApprved;
    private boolean existing_attachments;
    private boolean zonalization_accept;
    private String buildingBasics,isCommercial,toSummary;

    public String getNameOfTheSurvayor() {
        return nameOfTheSurvayor;
    }

    public void setNameOfTheSurvayor(String nameOfTheSurvayor) {
        this.nameOfTheSurvayor = nameOfTheSurvayor;
    }

    public String getAreaRatios() {
        return areaRatios;
    }

    public void setAreaRatios(String areaRatios) {
        this.areaRatios = areaRatios;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public String getCovesOfHolding() {
        return covesOfHolding;
    }

    public void setCovesOfHolding(String covesOfHolding) {
        this.covesOfHolding = covesOfHolding;
    }

    public String getDrainwater() {
        return drainwater;
    }

    public void setDrainwater(String railwater) {
        this.drainwater = railwater;
    }

    public boolean getIsIsSurvayorApprved() {
        return isSurvayorApprved;
    }

    public void setIsSurvayorApprved(boolean isSurvayorApprved) {
        this.isSurvayorApprved = isSurvayorApprved;
    }

    public boolean getIsExisting_attachments() {
        return existing_attachments;
    }

    public void setExisting_attachments(boolean existing_attachments) {
        this.existing_attachments = existing_attachments;
    }

    public boolean isZonalization_accept() {
        return zonalization_accept;
    }

    public void setZonalization_accept(boolean zonalization_accept) {
        this.zonalization_accept = zonalization_accept;
    }

    public String getBuildingBasics() {
        return buildingBasics;
    }

    public void setBuildingBasics(String buildingBasics) {
        this.buildingBasics = buildingBasics;
    }

    public String getIsCommercial() {
        return isCommercial;
    }

    public void setIsCommercial(String isCommercial) {
        this.isCommercial = isCommercial;
    }

    public String getToSummary() {
        return toSummary;
    }

    public void setToSummary(String toSummary) {
        this.toSummary = toSummary;
    }
}
