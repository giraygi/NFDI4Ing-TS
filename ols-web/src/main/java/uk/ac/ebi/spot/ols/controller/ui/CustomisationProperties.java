
package uk.ac.ebi.spot.ols.controller.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@ConfigurationProperties(prefix = "ols.customisation")
@Configuration("customisationProperties")
public class CustomisationProperties {

    @Value("${ols.customisation.debrand:false}")
    private boolean debrand;
    
    @Value("${ols.customisation.logo:/img/20190922_nfdi4ing_avatar_management_cmyk.jpg}")
    private String logo;

    @Value("${ols.customisation.title: NFDI4Ing Terminology Service}")
    private String title;

    @Value("${ols.customisation.short-title: NFDI4IngTS}")
    private String shortTitle;

    @Value("${ols.customisation.org: TIB}")
    private String org;

    public void setCustomisationModelAttributes(Model model) {
        model.addAttribute("debrand", debrand);
        model.addAttribute("logo", logo);
        model.addAttribute("title", title);
        model.addAttribute("shortTitle", shortTitle);
        model.addAttribute("org", org);
    }

    public boolean getDebrand() {
        return debrand;
    }
}
