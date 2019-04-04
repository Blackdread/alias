package org.alias.axon.serializer.example.configuration.eventsourcing.transaction;

import java.util.function.Consumer;

/**
 * {@link Consumer}, that may throw a (here hard-typed) {@link Exception}.
 * @author Johannes Troppacher
 *
 * @see Consumer
 * @param <T>
 */
@FunctionalInterface
interface ExceptionConsumer<T> {
	/**
	 * Performs this operation on the given argument.
	 *
	 * @param t the input argument
	 */
	void accept(T t) throws Exception;
}
