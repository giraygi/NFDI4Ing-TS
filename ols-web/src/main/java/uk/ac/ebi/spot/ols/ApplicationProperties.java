package uk.ac.ebi.spot.ols;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {
	
	private List<String> ontologies = new ArrayList<String>();
	
    public List<String> getOntologies() {
        return ontologies;
    }

}
