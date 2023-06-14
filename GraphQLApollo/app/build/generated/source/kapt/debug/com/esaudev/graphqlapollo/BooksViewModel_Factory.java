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
public final class BooksViewModel_Factory implements Factory<BooksViewModel> {
  private final Provider<CharactersRepository> repositoryProvider;

  public BooksViewModel_Factory(Provider<CharactersRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public BooksViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static BooksViewModel_Factory create(Provider<CharactersRepository> repositoryProvider) {
    return new BooksViewModel_Factory(repositoryProvider);
  }

  public static BooksViewModel newInstance(CharactersRepository repository) {
    return new BooksViewModel(repository);
  }
}