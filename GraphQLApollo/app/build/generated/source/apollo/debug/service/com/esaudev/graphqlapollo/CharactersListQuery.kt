// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.esaudev.graphqlapollo

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
class CharactersListQuery : Query<CharactersListQuery.Data, CharactersListQuery.Data,
    Operation.Variables> {
  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = parse(Buffer().write(byteString), scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> = parse(byteString, DEFAULT)

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString =
      OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = scalarTypeAdapters
  )

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  data class Book(
    val __typename: String = "Book",
    val title: String?,
    val author: String?,
    val precio: Int?,
    val descripcion: String?,
    val imagen: String?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Book.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Book.title)
      writer.writeString(RESPONSE_FIELDS[2], this@Book.author)
      writer.writeInt(RESPONSE_FIELDS[3], this@Book.precio)
      writer.writeString(RESPONSE_FIELDS[4], this@Book.descripcion)
      writer.writeString(RESPONSE_FIELDS[5], this@Book.imagen)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("title", "title", null, true, null),
          ResponseField.forString("author", "author", null, true, null),
          ResponseField.forInt("precio", "precio", null, true, null),
          ResponseField.forString("descripcion", "descripcion", null, true, null),
          ResponseField.forString("imagen", "imagen", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Book = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val title = readString(RESPONSE_FIELDS[1])
        val author = readString(RESPONSE_FIELDS[2])
        val precio = readInt(RESPONSE_FIELDS[3])
        val descripcion = readString(RESPONSE_FIELDS[4])
        val imagen = readString(RESPONSE_FIELDS[5])
        Book(
          __typename = __typename,
          title = title,
          author = author,
          precio = precio,
          descripcion = descripcion,
          imagen = imagen
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Book> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  data class Data(
    val books: List<Book?>?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeList(RESPONSE_FIELDS[0], this@Data.books) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forList("books", "books", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val books = readList<Book>(RESPONSE_FIELDS[0]) { reader ->
          reader.readObject<Book> { reader ->
            Book(reader)
          }
        }
        Data(
          books = books
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "ae991aa56ca2044cfa1ce34b2e3b907002b0cd8b6f2858ebcac7020b8a233e97"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query CharactersList {
          |  books {
          |    __typename
          |    title
          |    author
          |    precio
          |    descripcion
          |    imagen
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "CharactersList"
    }
  }
}