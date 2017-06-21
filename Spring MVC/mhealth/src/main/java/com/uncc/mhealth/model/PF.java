package com.uncc.mhealth.model;

import java.util.ArrayList;

public class PF {
	public String auditRisc;
	public String gender;
	public double weight;
	public int maxBeer;
	public int maxWine;
	public int maxShots;
	public int maxLiqour;
	public int maxHours;
	public int maxTotal;
	public int firstDrink;
	public int firstDrinkHours;
	public double alpha;
	public int alcoholUsage;
	public float alcoholPercentile;
	public float alcoholPercentage;
	public int averageDrink;
	public float drinkPercentile;
	public float drinkPercentage;
	public Question cea1;
	public Question cea2;
	public String genderString;
	public double r;
	public String peakBAC;
	public int peakSober;
	public String typicalBAC;
	public int typicalSober;
	public int total;
	public int monthlyCalReq;
	public int alcoholCal;
	public double alcoholPercent;
	public int byaacqScore;
	public String byaacqProblems;
	public String byaacqRange;
	public int auditScore;
	public String geneticRisk;
	public String ruler1Text;
	public String ruler2Text;
	public String pcaCategory;
	public int preferredTimeMon = AM8to9_15;
	public int preferredTimeTue = AM8to9_15;
	public int preferredTimeWed = AM8to9_15;
	public int preferredTimeThu = AM8to9_15;
	public int preferredTimeFri = AM8to9_15;
	public int preferredTimeSat = AM8to9_15;
	public int preferredTimeSun = AM8to9_15;
	public int maxAlcoholCal;
	public double maxAlcoholPercent;
	public double alcoholPercent1;
	public double alcoholPercent2;
	public double maxAlcoholPercent1;
	public double maxAlcoholPercent2;
	public Question byaacq;
	public ArrayList<String> auditPoints;
	public Question ruler1;
	public Question ruler2;
	public ArrayList<String> pssNever;
	public ArrayList<String> pssRarely;
	public ArrayList<String> pssOccasionally;
	public ArrayList<String> pssSometimes;
	public ArrayList<String> pssUsually;
	public ArrayList<String> pssAlways;
	public int maxAlcoholCal1;
	public int maxAlcoholCal2;
	
	
	public static final int AM8to9_15 = 0;
	public static final int AM9_30to10_45 = 1;
	public static final int AM11to12_15 = 2;
	public static final int PM12_30to1_45 = 3;
	public static final int PM2to3_15 = 4;
	public static final int PM3_30to4_45 = 5;
	public static final int PM5to6_15 = 6;
	public static final int PM6_30to7_45 = 7;
	public static final int PM8to9_15 = 8;
	
	
	
	public int getMaxAlcoholCal1() {
		return maxAlcoholCal1;
	}



	public void setMaxAlcoholCal1(int maxAlcoholCal1) {
		this.maxAlcoholCal1 = maxAlcoholCal1;
	}



	public int getMaxAlcoholCal2() {
		return maxAlcoholCal2;
	}



	public void setMaxAlcoholCal2(int maxAlcoholCal2) {
		this.maxAlcoholCal2 = maxAlcoholCal2;
	}



	public Question getRuler1() {
		return ruler1;
	}



	public void setRuler1(Question ruler1) {
		this.ruler1 = ruler1;
	}



	public Question getRuler2() {
		return ruler2;
	}



	public void setRuler2(Question ruler2) {
		this.ruler2 = ruler2;
	}



	public ArrayList<String> getPssNever() {
		return pssNever;
	}



	public void setPssNever(ArrayList<String> pssNever) {
		this.pssNever = pssNever;
	}



	public ArrayList<String> getPssRarely() {
		return pssRarely;
	}



	public void setPssRarely(ArrayList<String> pssRarely) {
		this.pssRarely = pssRarely;
	}



	public ArrayList<String> getPssOccasionally() {
		return pssOccasionally;
	}



	public void setPssOccasionally(ArrayList<String> pssOccasionally) {
		this.pssOccasionally = pssOccasionally;
	}



	public ArrayList<String> getPssSometimes() {
		return pssSometimes;
	}



	public void setPssSometimes(ArrayList<String> pssSometimes) {
		this.pssSometimes = pssSometimes;
	}



	public ArrayList<String> getPssUsually() {
		return pssUsually;
	}



	public void setPssUsually(ArrayList<String> pssUsually) {
		this.pssUsually = pssUsually;
	}



	public ArrayList<String> getPssAlways() {
		return pssAlways;
	}



	public void setPssAlways(ArrayList<String> pssAlways) {
		this.pssAlways = pssAlways;
	}



	public ArrayList<String> getAuditPoints() {
		return auditPoints;
	}



	public void setAuditPoints(ArrayList<String> auditPoints) {
		this.auditPoints = auditPoints;
	}



	public Question getByaacq() {
		return byaacq;
	}



	public void setByaacq(Question byaacq) {
		this.byaacq = byaacq;
	}



	public double getAlcoholPercent1() {
		return alcoholPercent1;
	}



	public void setAlcoholPercent1(double alcoholPercent1) {
		this.alcoholPercent1 = alcoholPercent1;
	}



	public double getAlcoholPercent2() {
		return alcoholPercent2;
	}



	public void setAlcoholPercent2(double alcoholPercent2) {
		this.alcoholPercent2 = alcoholPercent2;
	}



	public double getMaxAlcoholPercent1() {
		return maxAlcoholPercent1;
	}



	public void setMaxAlcoholPercent1(double maxAlcoholPercent1) {
		this.maxAlcoholPercent1 = maxAlcoholPercent1;
	}



	public double getMaxAlcoholPercent2() {
		return maxAlcoholPercent2;
	}



	public void setMaxAlcoholPercent2(double maxAlcoholPercent2) {
		this.maxAlcoholPercent2 = maxAlcoholPercent2;
	}



	public String getAuditRisc() {
		return auditRisc;
	}



	public void setAuditRisc(String auditRisc) {
		this.auditRisc = auditRisc;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public double getWeight() {
		return weight;
	}



	public void setWeight(double weight) {
		this.weight = weight;
	}



	public int getMaxBeer() {
		return maxBeer;
	}



	public void setMaxBeer(int maxBeer) {
		this.maxBeer = maxBeer;
	}



	public int getMaxWine() {
		return maxWine;
	}



	public void setMaxWine(int maxWine) {
		this.maxWine = maxWine;
	}



	public int getMaxShots() {
		return maxShots;
	}



	public void setMaxShots(int maxShots) {
		this.maxShots = maxShots;
	}



	public int getMaxLiqour() {
		return maxLiqour;
	}



	public void setMaxLiqour(int maxLiqour) {
		this.maxLiqour = maxLiqour;
	}



	public int getMaxHours() {
		return maxHours;
	}



	public void setMaxHours(int maxHours) {
		this.maxHours = maxHours;
	}



	public int getMaxTotal() {
		return maxTotal;
	}



	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}



	public int getFirstDrink() {
		return firstDrink;
	}



	public void setFirstDrink(int firstDrink) {
		this.firstDrink = firstDrink;
	}



	public int getFirstDrinkHours() {
		return firstDrinkHours;
	}



	public void setFirstDrinkHours(int firstDrinkHours) {
		this.firstDrinkHours = firstDrinkHours;
	}



	public double getAlpha() {
		return alpha;
	}



	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}



	public int getAlcoholUsage() {
		return alcoholUsage;
	}



	public void setAlcoholUsage(int alcoholUsage) {
		this.alcoholUsage = alcoholUsage;
	}



	public float getAlcoholPercentile() {
		return alcoholPercentile;
	}



	public void setAlcoholPercentile(float alcoholPercentile) {
		this.alcoholPercentile = alcoholPercentile;
	}



	public float getAlcoholPercentage() {
		return alcoholPercentage;
	}



	public void setAlcoholPercentage(float alcoholPercentage) {
		this.alcoholPercentage = alcoholPercentage;
	}



	public int getAverageDrink() {
		return averageDrink;
	}



	public void setAverageDrink(int averageDrink) {
		this.averageDrink = averageDrink;
	}



	public float getDrinkPercentile() {
		return drinkPercentile;
	}



	public void setDrinkPercentile(float drinkPercentile) {
		this.drinkPercentile = drinkPercentile;
	}



	public float getDrinkPercentage() {
		return drinkPercentage;
	}



	public void setDrinkPercentage(float drinkPercentage) {
		this.drinkPercentage = drinkPercentage;
	}



	public Question getCea1() {
		return cea1;
	}



	public void setCea1(Question cea1) {
		this.cea1 = cea1;
	}



	public Question getCea2() {
		return cea2;
	}



	public void setCea2(Question cea2) {
		this.cea2 = cea2;
	}



	public String getGenderString() {
		return genderString;
	}



	public void setGenderString(String genderString) {
		this.genderString = genderString;
	}



	public double getR() {
		return r;
	}



	public void setR(double r) {
		this.r = r;
	}



	public String getPeakBAC() {
		return peakBAC;
	}



	public void setPeakBAC(String peakBAC) {
		this.peakBAC = peakBAC;
	}



	public double getPeakSober() {
		return peakSober;
	}



	public void setPeakSober(int peakSober) {
		this.peakSober = peakSober;
	}



	public String getTypicalBAC() {
		return typicalBAC;
	}



	public void setTypicalBAC(String typicalBAC) {
		this.typicalBAC = typicalBAC;
	}



	public double getTypicalSober() {
		return typicalSober;
	}



	public void setTypicalSober(int typicalSober) {
		this.typicalSober = typicalSober;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public int getMonthlyCalReq() {
		return monthlyCalReq;
	}



	public void setMonthlyCalReq(int monthlyCalReq) {
		this.monthlyCalReq = monthlyCalReq;
	}



	public int getAlcoholCal() {
		return alcoholCal;
	}



	public void setAlcoholCal(int alcoholCal) {
		this.alcoholCal = alcoholCal;
	}



	public double getAlcoholPercent() {
		return alcoholPercent;
	}



	public void setAlcoholPercent(double alcoholPercent) {
		this.alcoholPercent = alcoholPercent;
	}



	public int getByaacqScore() {
		return byaacqScore;
	}



	public void setByaacqScore(int byaacqScore) {
		this.byaacqScore = byaacqScore;
	}



	public String getByaacqProblems() {
		return byaacqProblems;
	}



	public void setByaacqProblems(String byaacqProblems) {
		this.byaacqProblems = byaacqProblems;
	}



	public String getByaacqRange() {
		return byaacqRange;
	}



	public void setByaacqRange(String byaacqRange) {
		this.byaacqRange = byaacqRange;
	}



	public int getAuditScore() {
		return auditScore;
	}



	public void setAuditScore(int auditScore) {
		this.auditScore = auditScore;
	}



	public String getGeneticRisk() {
		return geneticRisk;
	}



	public void setGeneticRisk(String geneticRisk) {
		this.geneticRisk = geneticRisk;
	}



	public String getRuler1Text() {
		return ruler1Text;
	}



	public void setRuler1Text(String ruler1Text) {
		this.ruler1Text = ruler1Text;
	}



	public String getRuler2Text() {
		return ruler2Text;
	}



	public void setRuler2Text(String ruler2Text) {
		this.ruler2Text = ruler2Text;
	}



	public String getPcaCategory() {
		return pcaCategory;
	}



	public void setPcaCategory(String pcaCategory) {
		this.pcaCategory = pcaCategory;
	}



	public int getPreferredTimeMon() {
		return preferredTimeMon;
	}



	public void setPreferredTimeMon(int preferredTimeMon) {
		this.preferredTimeMon = preferredTimeMon;
	}



	public int getPreferredTimeTue() {
		return preferredTimeTue;
	}



	public void setPreferredTimeTue(int preferredTimeTue) {
		this.preferredTimeTue = preferredTimeTue;
	}



	public int getPreferredTimeWed() {
		return preferredTimeWed;
	}



	public void setPreferredTimeWed(int preferredTimeWed) {
		this.preferredTimeWed = preferredTimeWed;
	}



	public int getPreferredTimeThu() {
		return preferredTimeThu;
	}



	public void setPreferredTimeThu(int preferredTimeThu) {
		this.preferredTimeThu = preferredTimeThu;
	}



	public int getPreferredTimeFri() {
		return preferredTimeFri;
	}



	public void setPreferredTimeFri(int preferredTimeFri) {
		this.preferredTimeFri = preferredTimeFri;
	}



	public int getPreferredTimeSat() {
		return preferredTimeSat;
	}



	public void setPreferredTimeSat(int preferredTimeSat) {
		this.preferredTimeSat = preferredTimeSat;
	}



	public int getPreferredTimeSun() {
		return preferredTimeSun;
	}



	public void setPreferredTimeSun(int preferredTimeSun) {
		this.preferredTimeSun = preferredTimeSun;
	}



	public int getMaxAlcoholCal() {
		return maxAlcoholCal;
	}



	public void setMaxAlcoholCal(int maxAlcoholCal) {
		this.maxAlcoholCal = maxAlcoholCal;
	}



	public double getMaxAlcoholPercent() {
		return maxAlcoholPercent;
	}



	public void setMaxAlcoholPercent(double maxAlcoholPercent) {
		this.maxAlcoholPercent = maxAlcoholPercent;
	}



	public static int getAm8to915() {
		return AM8to9_15;
	}



	public static int getAm930to1045() {
		return AM9_30to10_45;
	}



	public static int getAm11to1215() {
		return AM11to12_15;
	}



	public static int getPm1230to145() {
		return PM12_30to1_45;
	}



	public static int getPm2to315() {
		return PM2to3_15;
	}



	public static int getPm330to445() {
		return PM3_30to4_45;
	}



	public static int getPm5to615() {
		return PM5to6_15;
	}



	public static int getPm630to745() {
		return PM6_30to7_45;
	}



	public static int getPm8to915() {
		return PM8to9_15;
	}



	@Override
	public String toString() {
		return "PF [auditRisc=" + auditRisc + ", gender=" + gender + ", weight=" + weight + ", maxBeer=" + maxBeer
				+ ", maxWine=" + maxWine + ", maxShots=" + maxShots + ", maxLiqour=" + maxLiqour + ", maxHours="
				+ maxHours + ", maxTotal=" + maxTotal + ", firstDrink=" + firstDrink + ", firstDrinkHours="
				+ firstDrinkHours + ", alpha=" + alpha + ", alcoholUsage=" + alcoholUsage + ", alcoholPercentile="
				+ alcoholPercentile + ", alcoholPercentage=" + alcoholPercentage + ", averageDrink=" + averageDrink
				+ ", drinkPercentile=" + drinkPercentile + ", drinkPercentage=" + drinkPercentage + ", cea1=" + cea1
				+ ", cea2=" + cea2 + ", genderString=" + genderString + ", r=" + r + ", peakBAC=" + peakBAC
				+ ", peakSober=" + peakSober + ", typicalBAC=" + typicalBAC + ", typicalSober=" + typicalSober
				+ ", total=" + total + ", monthlyCalReq=" + monthlyCalReq + ", alcoholCal=" + alcoholCal
				+ ", alcoholPercent=" + alcoholPercent + ", byaacqScore=" + byaacqScore + ", byaacqProblems="
				+ byaacqProblems + ", byaacqRange=" + byaacqRange + ", auditScore=" + auditScore + ", geneticRisk="
				+ geneticRisk + ", ruler1Text=" + ruler1Text + ", ruler2Text=" + ruler2Text + ", pcaCategory="
				+ pcaCategory + ", preferredTimeMon=" + preferredTimeMon + ", preferredTimeTue=" + preferredTimeTue
				+ ", preferredTimeWed=" + preferredTimeWed + ", preferredTimeThu=" + preferredTimeThu
				+ ", preferredTimeFri=" + preferredTimeFri + ", preferredTimeSat=" + preferredTimeSat
				+ ", preferredTimeSun=" + preferredTimeSun + ", maxAlcoholCal=" + maxAlcoholCal + ", maxAlcoholPercent="
				+ maxAlcoholPercent + ", alcoholPercent1=" + alcoholPercent1 + ", alcoholPercent2=" + alcoholPercent2
				+ ", maxAlcoholPercent1=" + maxAlcoholPercent1 + ", maxAlcoholPercent2=" + maxAlcoholPercent2
				+ ", byaacq=" + byaacq + ", auditPoints=" + auditPoints + ", ruler1=" + ruler1 + ", ruler2=" + ruler2
				+ ", pssNever=" + pssNever + ", pssRarely=" + pssRarely + ", pssOccasionally=" + pssOccasionally
				+ ", pssSometimes=" + pssSometimes + ", pssUsually=" + pssUsually + ", pssAlways=" + pssAlways
				+ ", maxAlcoholCal1=" + maxAlcoholCal1 + ", maxAlcoholCal2=" + maxAlcoholCal2 + "]";
	}

	
	
}
