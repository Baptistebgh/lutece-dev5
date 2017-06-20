/*
 * Copyright (c) 2002-2016, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */ 
package fr.paris.lutece.plugins.example.business;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import fr.paris.lutece.portal.service.resource.IExtendableResource;

import java.io.Serializable;

/**
 * This is the business class for the object Project
 */ 
public class Project implements Serializable, IExtendableResource 
{
    private static final long serialVersionUID = 1L;

    // Variables declarations 
    private int _nId;
    
    @NotEmpty( message = "#i18n{example.validation.project.Name.notEmpty}" )
    @Size( max = 50 , message = "#i18n{example.validation.project.Name.size}" ) 
    private String _strName;
    
    @NotEmpty( message = "#i18n{example.validation.project.Description.notEmpty}" )
    @Size( max = 255 , message = "#i18n{example.validation.project.Description.size}" ) 
    private String _strDescription;
    
    @URL(message = "#i18n{portal.validation.message.url}")
    @NotEmpty( message = "#i18n{example.validation.project.ImageURL.notEmpty}" )
    @Size( max = 255 , message = "#i18n{example.validation.project.ImageURL.size}" ) 
    private String _strImageURL;
    
    

    @Min(value = 5, message = "Le coût doit être supérieur à 5 € !")
    @Max(value = 25, message = "Le coût doit être inférieur à 25 € !")
    private int _nCout;
    
    public static String PROPERTY_RESOURCE_TYPE ="Project_resource_type";
    

    /**
     * Returns the Id
     * @return The Id
     */
    public int getId( )
    {
        return _nId;
    }

    /**
     * Sets the Id
     * @param nId The Id
     */ 
    public void setId( int nId )
    {
        _nId = nId;
    }
    
    /**
     * Returns the Name
     * @return The Name
     */
    public String getName( )
    {
        return _strName;
    }

    /**
     * Sets the Name
     * @param strName The Name
     */ 
    public void setName( String strName )
    {
        _strName = strName;
    }
    
    /**
     * Returns the Description
     * @return The Description
     */
    public String getDescription( )
    {
        return _strDescription;
    }

    /**
     * Sets the Description
     * @param strDescription The Description
     */ 
    public void setDescription( String strDescription )
    {
        _strDescription = strDescription;
    }
    
    /**
     * Returns the ImageURL
     * @return The ImageURL
     */
    public String getImageURL( )
    {
        return _strImageURL;
    }

    /**
     * Sets the ImageURL
     * @param strImageURL The ImageURL
     */ 
    public void setImageURL( String strImageURL )
    {
        _strImageURL = strImageURL;
    }
    
    public int getCout( )
    {
    	return _nCout;
    }
    
    public void setCout( int nCout)
    {
    	_nCout = nCout;
    }

	@Override
	public String getIdExtendableResource() {
		return Integer.toString(_nId);
	}

	@Override
	public String getExtendableResourceType() {
		
		return PROPERTY_RESOURCE_TYPE;
	}

	@Override
	public String getExtendableResourceName() {
		
		return _strName;
	}

	@Override
	public String getExtendableResourceDescription() {
		
		return _strDescription;
	}

	@Override
	public String getExtendableResourceImageUrl() {
		
		return _strImageURL;
	}
}
