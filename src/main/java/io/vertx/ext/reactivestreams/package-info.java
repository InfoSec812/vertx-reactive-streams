/**
 * = Vert.x Reactive Streams Integration
 *
 * link:http://www.reactive-streams.org/[Reactive Streams] is an initiative to provide a standard for asynchronous stream
 * processing with non-blocking back pressure on the JVM.
 *
 * This library provides an implementation of reactive streams for Vert.x.
 *
 * Vert.x provides its own mechanisms for handling streams of data and pumping them with back pressure from one to another
 * using the `io.vertx.core.streams.ReadStream`, `io.vertx.core.streams.WriteStream` and `io.vertx.core.streams.Pump`.
 * Please see the Vert.x core manual for more information on Vert.x streams.
 *
 * This library provides implementations of read stream and write stream which also act as reactive streams publishers
 * and subscribers. This allows us to treat any reactive streams publisher or subscriber and deal with it like any other
 * Vert.x read or write stream.
 *
 * == Using Vert.x Reactive Streams
 *
 * To use Vert.x Reactive Streams, add the following dependency to the _dependencies_ section of your build descriptor:
 *
 * * Maven (in your `pom.xml`):
 *
 * [source,xml,subs="+attributes"]
 * ----
 * <dependency>
 *   <groupId>{maven-groupId}</groupId>
 *   <artifactId>{maven-artifactId}</artifactId>
 *   <version>{maven-version}</version>
 * </dependency>
 * ----
 *
 * * Gradle (in your `build.gradle` file):
 *
 * [source,groovy,subs="+attributes"]
 * ----
 * compile {maven-groupId}:{maven-artifactId}:{maven-version}
 * ----
 *
 * == Reactive Read Stream
 *
 * We provide an implementation of the Vert.x `ReadStream` interface with {@link io.vertx.ext.reactivestreams.ReactiveReadStream}
 * which also implements a reactive streams `Subscriber`.
 *
 * You can pass an instance of this to any reactive streams `Publisher` (e.g. a Publisher from Akka) and then you will be
 * able to read from that just like any other Vert.x `ReadStream` (e.g. use a `Pump` to pump it to a `WriteStream`.
 *
 * Here's an example of taking a publisher from some other reactive streams implementation (e.g. Akka) and pumping that
 * stream to the body of a server side HTTP response. This will handle back pressure automatically.
 *
 * [source,java]
 * ----
 * {@link examples.ReactiveStreamsExamples#example1}
 * ----
 *
 * == Reactive Write Stream
 *
 * We also provide an implementation of the Vert.x `WriteStream` interface with {@link io.vertx.ext.reactivestreams.ReactiveWriteStream}
 * which also implements a reactive streams `Publisher`. You can take any reactive streams `Subscriber`
 * (e.g. a Subscriber from Akka) and then you will be able* to write to it like any other Vert.x `WriteStream`.
 * (e.g. use a `Pump` to pump it from a `ReadStream`).
 *
 * You use `pause`, `resume`, and `writeQueueFull`, as you would with any Vert.x read stream to handle your back pressure.
 * This is automatically translated internally into the reactive streams method of propagating back pressure
 * (requesting more items).
 *
 * Here's an example of taking a subscriber from some other reactive streams implementation and pumping the body of
 * a server side HTTP request to that subscriber. This will handle back pressure automatically.
 *
 * [source,java]
 * ----
 * {@link examples.ReactiveStreamsExamples#example2}
 * ----
 *
 */
@Document(fileName = "index.adoc")
package io.vertx.ext.reactivestreams;

import io.vertx.docgen.Document;