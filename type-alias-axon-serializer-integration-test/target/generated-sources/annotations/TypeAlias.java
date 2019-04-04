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


import java.util.ListResourceBundle;
import javax.annotation.Generated;

@Generated("type-alias")
public class TypeAlias extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
				{ "NicknameChanged", org.alias.axon.serializer.example.messages.event.account.NicknameChangedEvent.class },
				{ "AccountCreated", org.alias.axon.serializer.example.messages.event.account.AccountCreatedEvent.class },
				{ "AccountAggregate", org.alias.axon.serializer.example.domain.model.account.AccountAggregate.class },
				{ "MessagingMetaData", org.axonframework.messaging.MetaData.class },
				{ "NicknamePreset", org.alias.axon.serializer.example.messages.event.account.NicknamePresetEvent.class },
				{ "org.alias.axon.serializer.example.messages.event.account.NicknameChangedEvent", "NicknameChanged" },
				{ "org.alias.axon.serializer.example.messages.event.account.AccountCreatedEvent", "AccountCreated" },
				{ "org.alias.axon.serializer.example.domain.model.account.AccountAggregate", "AccountAggregate" },
				{ "org.axonframework.messaging.MetaData", "MessagingMetaData" },
				{ "org.alias.axon.serializer.example.messages.event.account.NicknamePresetEvent", "NicknamePreset" },
		};
	}
}