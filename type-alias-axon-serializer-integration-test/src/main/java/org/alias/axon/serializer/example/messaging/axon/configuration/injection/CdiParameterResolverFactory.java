package org.alias.axon.serializer.example.messaging.axon.configuration.injection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Parameter;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Typed;
import javax.enterprise.inject.spi.CDI;

import org.axonframework.common.Priority;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.annotation.ParameterResolver;
import org.axonframework.messaging.annotation.ParameterResolverFactory;

/**
 * Resolves method parameters using CDI.
 */
@Typed()
@Priority(Priority.LAST)
public class CdiParameterResolverFactory implements ParameterResolverFactory {

	private static final Logger LOGGER = Logger.getLogger(CdiParameterResolverFactory.class.getName());

	private static final String CDI_NOT_AVAILABLE = "CDI parameter resolving not supported";
	private static final String AMBIGUOUS_CDI_REFERENCE = "Ambiguous CDI reference for parameter type %s with annotations %s";
	private static final String UNSATISFIED_CDI_REFERENCE = "Unsatisfied CDI reference for parameter type %s with annotations %s";
	private static final String RESOLVE_CDI_REFERENCE = "Starting to resolve CDI reference for parameter type %s with annotations %s";
	private static final String RESOLVED_CDI_REFERENCE = "Finished resolving CDI reference for parameter type %s with annotations %s";

	private final Supplier<CDI<Object>> cdiSupplier;

	public CdiParameterResolverFactory() {
		this(CdiParameterResolverFactory::currentCdi);
	}

	public CdiParameterResolverFactory(Supplier<CDI<Object>> cdiSupplier) {
		this.cdiSupplier = Objects.requireNonNull(cdiSupplier);
	}

	@Override
	public ParameterResolver<?> createInstance(Executable executable, Parameter[] parameters, int parameterIndex) {
		Parameter parameter = parameters[parameterIndex];
		Class<?> parameterType = parameter.getType();
		Annotation[] parameterAnnotations = parameter.getAnnotations();

		LOGGER.finest(String.format(RESOLVE_CDI_REFERENCE, parameterType.getName(), parameterAnnotations));
		Instance<?> instance = cdiSupplier.get().select(parameterType, parameterAnnotations);
		if (instance.isUnsatisfied()) {
			throw logged(resolutionFailure(UNSATISFIED_CDI_REFERENCE, parameterType.getName(), parameterAnnotations));
		}
		if (instance.isAmbiguous()) {
			throw logged(resolutionFailure(AMBIGUOUS_CDI_REFERENCE, parameterType.getName(), parameterAnnotations));
		}
		LOGGER.finest(String.format(RESOLVED_CDI_REFERENCE, parameterType.getName(), parameterAnnotations));
		return new CdiParameterResolver(instance);
	}

	@Override
	public String toString() {
		return "CdiParameterResolverFactory [cdi=" + cdiSupplier + "]";
	}

	private static final CDI<Object> currentCdi() {
		try {
			return CDI.current();
		} catch (IllegalStateException e) {
			throw logged(resolutionFailure(CDI_NOT_AVAILABLE, e));
		}
	}

	private static <T extends RuntimeException> T logged(T exception) {
		LOGGER.log(Level.WARNING, exception.getMessage(), exception);
		return exception;
	}

	private static RuntimeException resolutionFailure(String message, Object... args) {
		return new IllegalStateException(String.format(message, args));
	}

	@Typed()
	public static class CdiParameterResolver implements ParameterResolver<Object> {

		private final Instance<?> instance;

		public CdiParameterResolver(Instance<?> instance) {
			this.instance = instance;
		}

		@Override
		@SuppressWarnings("rawtypes")
		public Object resolveParameterValue(Message message) {
			return instance.get();
		}

		@Override
		@SuppressWarnings("rawtypes")
		public boolean matches(final Message message) {
			return true;
		}

		@Override
		public String toString() {
			return "CdiParameterResolver [instance=" + instance + "]";
		}
	}
}