package uk.ac.ebi.spot.ols.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author Simon Jupp
 * @date 05/08/2015
 * Samples, Phenotypes and Ontologies Team, EMBL-EBI
 */
public class OLSEnv {

    private final static Logger log = LoggerFactory.getLogger(OLSEnv.class);


    protected static Logger getLog() {
           return log;
       }

    public static String getOLSHome () {

        // ols properties already set?
        String olsHome = System.getProperty("ols.home");

        // if ols.home not set, check $OLS_HOME environment variable
        if (olsHome == null || olsHome.equals("")) {
            String home = System.getenv("OLS_HOME");
            if (home == null || home.equals("")) {
                home = System.getProperty("user.home") + File.separator + ".ols";
                getLog().info("*** $OLS_HOME not set - defaulting to: " + home + " ***");
            }
            else {
                getLog().info("*** $OLS_HOME: " + home + " ***");
            }
            System.setProperty("ols.home", home);
        }
        else {
            getLog().debug("*** ols.home: " + olsHome + " ***");
        }

        return System.getProperty("ols.home");

    }


}
