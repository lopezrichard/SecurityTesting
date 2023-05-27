package security;

import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;
import utils.ConfigurationZAP;

/**
 * @author Richard Lopez on 27/05/2023
 * https://www.linkedin.com/in/richard-lopez-/
 * https://github.com/lopezrichard
 */
public class Report {
 public static void generate(ClientApi api) throws ClientApiException {
  if (api !=null){
   ApiResponse response= api.reports.generate(
           ConfigurationZAP.TITLE, ConfigurationZAP.TEMPLATE,null, ConfigurationZAP.DESCRIPTION,null,null,
           null,null,null, ConfigurationZAP.REPORTFILENAME,null, ConfigurationZAP.TARGETFOLDER,null);
   System.out.println("Report: " +response.toString());
  }
 }
}
