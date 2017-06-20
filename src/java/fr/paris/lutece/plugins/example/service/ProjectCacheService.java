package fr.paris.lutece.plugins.example.service;

import fr.paris.lutece.plugins.example.business.Project;
import fr.paris.lutece.portal.service.cache.AbstractCacheableService;

public class ProjectCacheService extends AbstractCacheableService {

	
	public static final String SERVICE_NAME = "Project Service";
	
	public ProjectCacheService(){
		initCache();
	}
	
	@Override
	public String getName() {
		return SERVICE_NAME;
	}

	public Project getResource(String strId){
		
		Project r = (Project) getFromCache(strId);
		
		if(r==null){
			r=getResourceFromSource(strId);
			putInCache(strId, r);
		}
		
		return r;
	}
	
	private static String getCacheKey(String strId, LuteceUser user){
		
		StringBuilder sbKey = new StringBuilder();
		sbKey.append( "[res:" ).append( strId ).append( "][user:").append( user.getName() ).append("]");
	     return sbKey.toString();
	}
	
}
