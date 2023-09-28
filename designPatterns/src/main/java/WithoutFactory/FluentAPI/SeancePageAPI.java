package WithoutFactory.FluentAPI;


import org.openqa.selenium.By;



public class SeancePageAPI {

    public By KaveIstPointButton = By.xpath("//a[text() = 'კავეა ისთ ფოინთი']");
    public By listOfSeances = By.xpath("//div[@aria-expanded='true'][@aria-hidden='false'][@style='display: flex;']");
    public By cinemaName = By.className("cinema-title");




}
