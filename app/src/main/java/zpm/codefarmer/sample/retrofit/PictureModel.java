package zpm.codefarmer.sample.retrofit;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public class PictureModel {

    /**
     * ImageCheckUrl : http://image.ideayapai.com/ImageResult/16-七月-07ccff1c86-5d24-40fa-8603-0317d423b23b33_resultChecked.jpg
     * ImageGrayUrl : http://image.ideayapai.com/ImageResult/16-七月-07ccff1c86-5d24-40fa-8603-0317d423b23b33_resultGray.jpg
     * DefectType : 0
     * PerUnit : 1.0
     * CrackWidth : 70.2031
     * Length : 326.5
     * UsedTime : 0.125
     * Area : 0
     */

    private String ImageCheckUrl;
    private String ImageGrayUrl;
    private int DefectType;
    private double PerUnit;
    private double CrackWidth;
    private double Length;
    private double UsedTime;
    private double Area;

    public String getImageCheckUrl() {
        return ImageCheckUrl;
    }

    public void setImageCheckUrl(String ImageCheckUrl) {
        this.ImageCheckUrl = ImageCheckUrl;
    }

    public String getImageGrayUrl() {
        return ImageGrayUrl;
    }

    public void setImageGrayUrl(String ImageGrayUrl) {
        this.ImageGrayUrl = ImageGrayUrl;
    }

    public int getDefectType() {
        return DefectType;
    }

    public void setDefectType(int DefectType) {
        this.DefectType = DefectType;
    }

    public double getPerUnit() {
        return PerUnit;
    }

    public void setPerUnit(double PerUnit) {
        this.PerUnit = PerUnit;
    }

    public double getCrackWidth() {
        return CrackWidth;
    }

    public void setCrackWidth(double CrackWidth) {
        this.CrackWidth = CrackWidth;
    }

    public double getLength() {
        return Length;
    }

    public void setLength(double Length) {
        this.Length = Length;
    }

    public double getUsedTime() {
        return UsedTime;
    }

    public void setUsedTime(double UsedTime) {
        this.UsedTime = UsedTime;
    }

    public double getArea() {
        return Area;
    }

    public void setArea(double Area) {
        this.Area = Area;
    }
}
