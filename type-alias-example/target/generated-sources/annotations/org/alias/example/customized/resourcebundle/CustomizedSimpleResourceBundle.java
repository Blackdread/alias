/*
 * Generated by 'type-alias' using java annotation processing.
 * 
 * This file contains all @TypeAlias annotated types 
 * inside this package and its sub-packages, except otherwise configured.
 * 
 * The name of the file, its template and its package scope/location can be configured
 * in 'package-info.java' using the annotation @TypeAliasGeneratedFile.
 * Without customization, aliases are written into 'TypeAlias.properties' 
 * located in the default package.
 */
package org.alias.example.customized.resourcebundle;

import java.util.ListResourceBundle;
import javax.annotation.Generated;

@Generated("type-alias")
public class CustomizedSimpleResourceBundle extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
				{ "AliasForAnotherCustomizedResourceBundleFile", org.alias.example.customized.resourcebundle.AnotherCustomizedResourceBundleFileType.class },
				{ "AliasForCustomizedResourceBundleFile", org.alias.example.customized.resourcebundle.CustomizedResourceBundleFileType.class },
		};
	}
}