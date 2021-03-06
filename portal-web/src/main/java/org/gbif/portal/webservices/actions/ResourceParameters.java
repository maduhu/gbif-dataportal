/***************************************************************************
 * Copyright (C) 2006 Global Biodiversity Information Facility Secretariat.  
 * All Rights Reserved.
 *
 * The contents of this file are subject to the Mozilla Public
 * License Version 1.1 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 ***************************************************************************/
package org.gbif.portal.webservices.actions;

import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gbif.portal.util.path.PathMapping;
import org.gbif.portal.webservices.util.GbifWebServiceException;


/**
 * @author Donald Hobern
 *
 */
public class ResourceParameters extends Parameters {
	
	public static final String RESOURCE_SERVICE_NAME ="resource";
	
	public static final String RESOURCE_NAMESPACE = "http://portal.gbif.org/ws/response/gbif";
	
	public static final String KEY_FORMAT = "format";
	public static final String KEY_NAME = "name";
	public static final String KEY_BASISOFRECORDCODE = "basisofrecordcode";
	public static final String KEY_KEY = "key";
	public static final String KEY_PROVIDERKEY = "providerkey";

	public static final int FORMAT_BRIEF = 0;
	
	public static final String FORMATNAME_BRIEF = "brief";

	public static final int MINIMUM_WILDCARDINDEX = 3;
	
	protected int format = FORMAT_BRIEF;
	protected String name = null;
	protected String basisOfRecordCode = null;
	protected String providerKey = null;
	protected String key = null;

	public static Log log = LogFactory.getLog(ResourceParameters.class);
	
	protected ResourceParameters() {
		// Null constructor
	}
	
	public ResourceParameters(Map<String, Object> params, PathMapping pathMapping)
		throws GbifWebServiceException
	{
		super(params, pathMapping);
		
		try {
			this.pathMapping = pathMapping;
			
			Set<String> keys = params.keySet();
			for (String k : keys) {
				Object value = params.get(k);
				
				if (k.equals(KEY_FORMAT)) {
					format = getFormat((String) value); 
				}
				else if (k.equals(KEY_NAME)) {
					name = (String) value; 
				}
				else if (k.equals(KEY_BASISOFRECORDCODE)) {
					basisOfRecordCode = (String) value; 
				}
				else if (k.equals(KEY_KEY)) {
					key = (String) value; 
				}
				else if (k.equals(KEY_PROVIDERKEY)) {
					providerKey = (String) value; 
				}
			}
			
			if (requestType == Action.GET && key == null) {
				throw new GbifWebServiceException("Must provide key for get request");
			}
		}
		catch (GbifWebServiceException gwse) {
			throw(gwse);
		}
		catch (Exception e) {
			throw new GbifWebServiceException("ResourceParameters exception: " + e);
		}
	}

	/**
	 * Returns the request type name for a given KVP set.
	 */
	public String getRequestTypeName() {
		return Action.getRequestTypeName(requestType);
	}

	protected int getFormat(String formatString) {
		int format = FORMAT_BRIEF;
		
		return format;
	}
	
	public String getFormatName() {
		String name = FORMATNAME_BRIEF;
		
		return name;
	}
	
	public Map<String, Object> getParameterMap(Integer overrideRequestType) {
		Map<String,Object> map = super.getParameterMap(overrideRequestType);
		int rt = (overrideRequestType == null) ? requestType : overrideRequestType.intValue();
		if (rt != Action.SCHEMA && rt != Action.STYLESHEET) {
			if (requestType == Action.COUNT || requestType == Action.LIST) {
				if (name != null) map.put(KEY_NAME, name);
				if (basisOfRecordCode != null) map.put(KEY_BASISOFRECORDCODE, basisOfRecordCode);
				if (providerKey != null) map.put(KEY_PROVIDERKEY, providerKey);
			}
			if (requestType == Action.LIST) {
				map.put(KEY_FORMAT, getFormatName());
			}
			if (requestType == Action.GET) {
				if (key != null) map.put(KEY_KEY, key);
			}
		}
		return map;
	}

	/**
	 * @return the format
	 */
	public int getFormat() {
		return format;
	}

	/**
	 * @return the basisOfRecordCode
	 */
	public String getBasisOfRecordCode() {
		return basisOfRecordCode;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the providerKey
	 */
	public String getProviderKey() {
		return providerKey;
	}
}