/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author Yasara JLP
 */
public class Application {
    // main identifiers
    private String applicantNIC,ApplicationID;
    // details about the land
    private String ratePaymentReceiptNo,streetName,wardNo,SurvayorPlanNo,BlockNo;
    private double areaOfTheLand;
    // details about current building (if any)
    private double areaOfCurrentBuilding;
    private String purposeOfCurrentBuilding = null;
    private boolean isCurrentBuildingPlanApproved,isCurrentBuildingHaveCOC;
    // development details
    private String typeOfTheBuilding,proposedUse,effectOnNeighbour = null,address;
    private double areaCoveredByBuilding;
    private double floorAreas[] = new double[5],distances[] = new double[4]; /* {floorAreas : ground,first,second,third,under ground}
                                                                                {distances from : road,back boader,right boader,left boader}     */
    // current completeness
    private boolean walls,roof,floor;
    
    //details about the entrance road
    private float widthOfTheEntranceRoad;
    private String typeOfTheRoad;
    
    // plans
    private InputStream survayorPlan;
    // plans
    private InputStream newBuildingPlan;
    // plans
    private InputStream existingBuildingPlan;
    // plans
    private InputStream existingBuildingCoC;

    public String getApplicantNIC() {
        return applicantNIC;
    }

    public void setApplicantNIC(String applicantNIC) {
        this.applicantNIC = applicantNIC.trim();
    }

    public String getApplicationID() {
        return ApplicationID;
    }

    public void setApplicationID(String ApplicationID) {
        this.ApplicationID = ApplicationID.trim();
    }

    public String getRatePaymentReceiptNo() {
        return ratePaymentReceiptNo;
    }

    public void setRatePaymentReceiptNo(String ratePaymentReceiptNo) {
        this.ratePaymentReceiptNo = ratePaymentReceiptNo.trim();
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName.trim();
    }

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo.trim();
    }

    public String getSurvayorPlanNo() {
        return SurvayorPlanNo;
    }

    public void setSurvayorPlanNo(String SurvayorPlanNo) {
        this.SurvayorPlanNo = SurvayorPlanNo.trim();
    }

    public String getBlockNo() {
        return BlockNo;
    }

    public void setBlockNo(String BlockNo) {
        this.BlockNo = BlockNo.trim();
    }

    public double getAreaOfTheLand() {
        return areaOfTheLand;
    }

    public void setAreaOfTheLand(double areaOfTheLand) {
        this.areaOfTheLand = areaOfTheLand;
    }

    public double getAreaOfCurrentBuilding() {
        return areaOfCurrentBuilding;
    }

    public void setAreaOfCurrentBuilding(double areaOfCurrentBuilding) {
        this.areaOfCurrentBuilding = areaOfCurrentBuilding;
    }

    public String getPurposeOfCurrentBuilding() {
        return purposeOfCurrentBuilding;
    }

    public void setPurposeOfCurrentBuilding(String purposeOfCurrentBuilding) {
        this.purposeOfCurrentBuilding = purposeOfCurrentBuilding.trim();
    }

    public boolean getIsCurrentBuildingPlanApproved() {
        return isCurrentBuildingPlanApproved;
    }

    public void setIsCurrentBuildingPlanApproved(boolean isCurrentBuildingPlanApproved) {
        this.isCurrentBuildingPlanApproved = isCurrentBuildingPlanApproved;
    }

    public boolean getIsCurrentBuildingHaveCOC() {
        return isCurrentBuildingHaveCOC;
    }

    public void setIsCurrentBuildingHaveCOC(boolean isCurrentBuildingHaveCOC) {
        this.isCurrentBuildingHaveCOC = isCurrentBuildingHaveCOC;
    }

    public String getTypeOfTheBuilding() {
        return typeOfTheBuilding;
    }

    public void setTypeOfTheBuilding(String typeOfTheBuilding) {
        this.typeOfTheBuilding = typeOfTheBuilding.trim();
    }

    public String getProposedUse() {
        return proposedUse;
    }

    public void setProposedUse(String proposedUse) {
        this.proposedUse = proposedUse.trim();
    }

    public double getAreaCoveredByBuilding() {
        return areaCoveredByBuilding;
    }

    public void setAreaCoveredByBuilding(double areaCoveredByBuilding) {
        this.areaCoveredByBuilding = areaCoveredByBuilding;
    }

    public double[] getFloorAreas() {
        return floorAreas;
    }

    public void setFloorAreas(double[] floorAreas) {
        this.floorAreas = floorAreas;
    }

    public double[] getDistances() {
        return distances;
    }

    public void setDistances(double[] distances) {
        this.distances = distances;
    }

    public boolean getWalls() {
        return walls;
    }

    public void setWalls(boolean walls) {
        this.walls = walls;
    }

    public boolean getRoof() {
        return roof;
    }

    public void setRoof(boolean roof) {
        this.roof = roof;
    }

    public boolean getFloor() {
        return floor;
    }

    public void setFloor(boolean floor) {
        this.floor = floor;
    }

    public float getWidthOfTheEntranceRoad() {
        return widthOfTheEntranceRoad;
    }

    public void setWidthOfTheEntranceRoad(float widthOfTheEntranceRoad) {
        this.widthOfTheEntranceRoad = widthOfTheEntranceRoad;
    }

    public String getTypeOfTheRoad() {
        return typeOfTheRoad;
    }

    public void setTypeOfTheRoad(String typeOfTheRoad) {
        this.typeOfTheRoad = typeOfTheRoad.trim();
    }

    public InputStream getSurvayorPlan() {
        return survayorPlan;
    }

    public void setSurvayorPlan(InputStream survayorPlan) {
        this.survayorPlan = survayorPlan;
    }

    public InputStream getNewBuildingPlan() {
        return newBuildingPlan;
    }

    public void setNewBuildingPlan(InputStream newBuildingPlan) {
        this.newBuildingPlan = newBuildingPlan;
    }

    public InputStream getExistingBuildingPlan() {
        return existingBuildingPlan;
    }

    public void setExistingBuildingPlan(InputStream existingBuildingPlan) {
        this.existingBuildingPlan = existingBuildingPlan;
    }

    public InputStream getExistingBuildingCoC() {
        return existingBuildingCoC;
    }

    public void setExistingBuildingCoC(InputStream existingBuildingCoC) {
        this.existingBuildingCoC = existingBuildingCoC;
    }

    public String getEffectOnNeighbour() {
        return effectOnNeighbour;
    }

    public void setEffectOnNeighbour(String effectOnNeighbour) {
        this.effectOnNeighbour = effectOnNeighbour.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
