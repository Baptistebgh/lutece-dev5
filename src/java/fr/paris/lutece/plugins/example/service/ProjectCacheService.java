package fr.paris.lutece.plugins.example.service;

import fr.paris.lutece.plugins.example.business.Project;
import fr.paris.lutece.plugins.example.business.ProjectHome;
import fr.paris.lutece.portal.service.cache.AbstractCacheableService;
import fr.paris.lutece.portal.service.security.LuteceUser;

public class ProjectCacheService extends AbstractCacheableService {

	
	public static final String SERVICE_NAME = "Project Service";
	private static ProjectCacheService _instance= new ProjectCacheService();
	
	public ProjectCacheService(){
		initCache();
	}
	
	@Override
	public String getName() {
		return SERVICE_NAME;
	}
	
	public static ProjectCacheService getInstance(){
		return _instance;
	}

	public Project getResource(String strId, LuteceUser user){
		
		String cacheKey = getCacheKey(strId, user);
		
		Project r = (Project) getFromCache(cacheKey);
		
		if(r==null){
			r = ProjectHome.findByPrimaryKey(Integer.parseInt(strId));
			
			cacheKey = getCacheKey(String.valueOf(r.getId()),user);
			putInCache(cacheKey, r);
		}
		
		return r;
	}
	
	private static String getCacheKey(String strId, LuteceUser user) {
        StringBuilder sbKey = new StringBuilder();
        sbKey.append("[project:").append(strId).append("][user:");

        if (user != null) {
            sbKey.append(user.getName());
        } else {
            sbKey.append("public");
        }
        sbKey.append("]");

        return sbKey.toString();
    }
	
}
