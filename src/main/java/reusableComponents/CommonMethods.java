package reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	// get Dropdown options as list of string to compare
	public List<String> Select_list_options(WebElement Element) {
		Select select = new Select(Element);
		List<WebElement> ListofOptions = select.getOptions();
		List<String> actualvalue = new ArrayList<String>();// getting value from the Site and add to this list as actual
															// list
		for (WebElement webElement : ListofOptions) {
			String text = webElement.getText();
			actualvalue.add(text);
		}
		return actualvalue;
	}

	public void selectDropDownOptions(WebElement Element, String Value) throws Exception {
		Select sel = new Select(Element);
		try {
			sel.selectByVisibleText(Value);
		} catch (Exception e) {
			throw new Exception("Value is not in the DropDown of The WebElemet");
		}
	}

	public void SelectRadioValue(List<WebElement> Elements, String Value) {
		for (WebElement Element : Elements) {
			if (Element.getText().equalsIgnoreCase(Value)) {
				Element.click();
				break;
			}
		}
	}

	public void SelectCheckBoxes(List<WebElement> Elements, String Value) {
		String[] split = Value.split(",");
		for (WebElement Element : Elements) {
			for (int i = 0; i <= split.length-1; i++) {
				if (Element.getText().equalsIgnoreCase(split[i])) {
					Element.click();
					break;
				}
			}
		} 
	}
}
