package zpm.codefarmer.sample.retrofit;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public class PictureModel {

    /**
     * ImageCheckUrl : http://image.ideayapai.com/ImageResult/16-七月-0840ae4e2b-f1e1-431a-af9e-44abd16dca0c6_resultChecked.jpg
     * ImageGrayUrl : http://image.ideayapai.com/ImageResult/16-七月-0840ae4e2b-f1e1-431a-af9e-44abd16dca0c6_resultGray.jpg
     * DefectType : 0
     * PerUnit : 1
     * CrackWidth : 370.463
     * Length : 4778.5
     * UsedTime : 1.682
     * Area : 0
     */

    private String ImageCheckUrl;
    private String ImageGrayUrl;
    private int DefectType;
    private int PerUnit;
    private double CrackWidth;
    private double Length;
    private double UsedTime;
    private int Area;

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

    public int getPerUnit() {
        return PerUnit;
    }

    public void setPerUnit(int PerUnit) {
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

    public int getArea() {
        return Area;
    }

    public void setArea(int Area) {
        this.Area = Area;
    }
}
