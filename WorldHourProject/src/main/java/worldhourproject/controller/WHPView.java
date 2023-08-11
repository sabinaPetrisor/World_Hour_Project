package worldhourproject.controller;

public interface WHPView {
	public String APP_CONTEXT = "/WorldHourProject";
	public String PAGE_FOLDER = "/jsp";
	
	public String AdminPage = APP_CONTEXT + PAGE_FOLDER + "/admin.jsp";
	public String AddCountryPage = APP_CONTEXT + PAGE_FOLDER + "/add-country.jsp";
	public String EditCountryPage = APP_CONTEXT + PAGE_FOLDER + "/edit-country.jsp";
	
	public String MainServlet = APP_CONTEXT + "/MainServlet";
	public String AddCountryServlet = APP_CONTEXT + "/addcountry";
	public String EditCountryServlet = APP_CONTEXT + "/editcountry";
	public String DeleteCountryServlet = APP_CONTEXT + "/deletecountry";
}
