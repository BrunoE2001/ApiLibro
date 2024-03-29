// Generated by Dagger (https://dagger.dev).
package com.esaudev.graphqlapollo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CharactersRepositoryImpl_Factory implements Factory<CharactersRepositoryImpl> {
  private final Provider<BooksApi> charactersApiProvider;

  public CharactersRepositoryImpl_Factory(Provider<BooksApi> charactersApiProvider) {
    this.charactersApiProvider = charactersApiProvider;
  }

  @Override
  public CharactersRepositoryImpl get() {
    return newInstance(charactersApiProvider.get());
  }

  public static CharactersRepositoryImpl_Factory create(Provider<BooksApi> charactersApiProvider) {
    return new CharactersRepositoryImpl_Factory(charactersApiProvider);
  }

  public static CharactersRepositoryImpl newInstance(BooksApi charactersApi) {
    return new CharactersRepositoryImpl(charactersApi);
  }
}
