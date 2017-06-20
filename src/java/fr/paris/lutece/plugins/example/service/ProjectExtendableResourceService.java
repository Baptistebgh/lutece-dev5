package fr.paris.lutece.plugins.example.service;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;


import fr.paris.lutece.plugins.example.business.Project;
import fr.paris.lutece.plugins.example.business.ProjectHome;
import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.resource.IExtendableResource;
import fr.paris.lutece.portal.service.resource.IExtendableResourceService;

public class ProjectExtendableResourceService implements IExtendableResourceService
 {
	
	
	private String MESSAGE_PROJECT_RESOURCE_TYPE_DESCRIPTION = "example.extend.resource.typeDescription";
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInvoked( String strResourceType )
	{
		return Project.PROPERTY_RESOURCE_TYPE.equals( strResourceType );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IExtendableResource getResource( String strIdResource, String strResourceType )
	{
		if ( StringUtils.isNotBlank( strIdResource ) && StringUtils.isNumeric( strIdResource ) )
		{
			int nId = Integer.parseInt( strIdResource );
			return ProjectHome.findByPrimaryKey( nId );
		}
		return null;
	}

        /**
	 * {@inheritDoc}
	 */
	@Override
	public String getResourceType( )
	{
		return Project.PROPERTY_RESOURCE_TYPE;
	}

        /**
	 * {@inheritDoc}
	 */
	@Override
	public String getResourceTypeDescription( Locale locale )
	{
		return I18nService.getLocalizedString( MESSAGE_PROJECT_RESOURCE_TYPE_DESCRIPTION, locale );
	}

        /**
	 * {@inheritDoc}
	 */
	@Override
	public String getResourceUrl( String strIdResource, String strResourceType )
	{
		String strUrl="" ;

		return strUrl;
	}


}