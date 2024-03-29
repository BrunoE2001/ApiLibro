// Generated by Dagger (https://dagger.dev).
package com.esaudev.graphqlapollo;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RepoModule_ProvideRickApiFactory implements Factory<BooksApi> {
  @Override
  public BooksApi get() {
    return provideRickApi();
  }

  public static RepoModule_ProvideRickApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BooksApi provideRickApi() {
    return Preconditions.checkNotNullFromProvides(RepoModule.INSTANCE.provideRickApi());
  }

  private static final class InstanceHolder {
    private static final RepoModule_ProvideRickApiFactory INSTANCE = new RepoModule_ProvideRickApiFactory();
  }
}
