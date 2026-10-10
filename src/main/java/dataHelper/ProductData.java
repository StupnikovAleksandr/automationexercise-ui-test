package dataHelper;

import lombok.Value;
import java.math.BigDecimal;

@Value
public class ProductData {
    String id;
    String name;
    String price;

    public String totalFor(int quantity) {
        return "Rs. " + new BigDecimal(price.replace("Rs.", "").trim())
                .multiply(BigDecimal.valueOf(quantity)).stripTrailingZeros().toPlainString();
    }
}
