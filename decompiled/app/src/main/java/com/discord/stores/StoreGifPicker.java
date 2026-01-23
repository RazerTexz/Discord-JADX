package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.models.gifpicker.dto.GifCategoryDto;
import com.discord.models.gifpicker.dto.GifDto;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.models.gifpicker.dto.TrendingGifCategoriesResponseDto;
import com.discord.models.gifpicker.dto.TrendingGifPreviewDto;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker extends StoreV2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<ModelGif> searchResultsLoadingList = Collections2.emptyList();
    private static final List<String> searchTermsLoadingList = Collections2.emptyList();
    private final Dispatcher dispatcher;
    private final List<ModelGifCategory> gifCategories;
    private List<ModelGifCategory> gifCategoriesSnapshot;
    private final CacheHistory<String, List<ModelGif>> gifSearchHistory;
    private Map<String, ? extends List<ModelGif>> gifSearchHistorySnapshot;
    private final CacheHistory<String, List<String>> gifSuggestedSearchTermsHistory;
    private final List<String> gifTrendingSearchTerms;
    private List<String> gifTrendingSearchTermsSnapshot;
    private boolean isFetchingGifCategories;
    private boolean isFetchingTrendingCategoryGifs;
    private boolean isFetchingTrendingSearchTerms;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final StoreUserSettingsSystem storeUserSettingsSystem;
    private Map<String, ? extends List<String>> suggestedSearchTermsSnapshot;
    private final List<ModelGif> trendingCategoryGifs;
    private List<ModelGif> trendingCategoryGifsSnapshot;
    private String trendingGifCategoryPreviewUrl;

    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class CacheHistory<K, V> extends LinkedHashMap<K, V> {
        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Set getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<K> keySet() {
            return getKeys();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > 20;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<V> values() {
            return getValues();
        }
    }

    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class Companion {
        private Companion() {
        }

        public final List<ModelGif> getSearchResultsLoadingList() {
            return StoreGifPicker.access$getSearchResultsLoadingList$cp();
        }

        public final List<String> getSearchTermsLoadingList() {
            return StoreGifPicker.access$getSearchTermsLoadingList$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifCategories$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59561 extends Lambda implements Function1<Error, Unit> {
        public C59561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGifPicker.access$handleFetchGifCategoriesError(StoreGifPicker.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifCategories$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final /* synthetic */ class C59572 extends FunctionReferenceImpl implements Function1<TrendingGifCategoriesResponseDto, Unit> {
        public C59572(StoreGifPicker storeGifPicker) {
            super(1, storeGifPicker, StoreGifPicker.class, "handleFetchGifCategoriesOnNext", "handleFetchGifCategoriesOnNext(Lcom/discord/models/gifpicker/dto/TrendingGifCategoriesResponseDto;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
            invoke2(trendingGifCategoriesResponseDto);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
            Intrinsics3.checkNotNullParameter(trendingGifCategoriesResponseDto, "p1");
            StoreGifPicker.access$handleFetchGifCategoriesOnNext((StoreGifPicker) this.receiver, trendingGifCategoriesResponseDto);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifTrendingSearchTerms$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59581 extends Lambda implements Function1<Error, Unit> {
        public C59581() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGifPicker.access$handleFetchTrendingSearchTermsError(StoreGifPicker.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifTrendingSearchTerms$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final /* synthetic */ class C59592 extends FunctionReferenceImpl implements Function1<List<? extends String>, Unit> {
        public C59592(StoreGifPicker storeGifPicker) {
            super(1, storeGifPicker, StoreGifPicker.class, "handleFetchTrendingSearchTermsOnNext", "handleFetchTrendingSearchTermsOnNext(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> list) {
            Intrinsics3.checkNotNullParameter(list, "p1");
            StoreGifPicker.access$handleFetchTrendingSearchTermsOnNext((StoreGifPicker) this.receiver, list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59601<T, R> implements Func1<List<? extends GifDto>, List<? extends ModelGif>> {
        public static final C59601 INSTANCE = new C59601();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends ModelGif> call(List<? extends GifDto> list) {
            return call2((List<GifDto>) list);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ModelGif> call2(List<GifDto> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "gifDtos");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ModelGif.INSTANCE.createFromGifDto((GifDto) it.next()));
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59612 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $query;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifPicker.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59612 c59612 = C59612.this;
                StoreGifPicker.access$handleGifSearchResults(StoreGifPicker.this, c59612.$query, Collections2.emptyList());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59612(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGifPicker.access$getDispatcher$p(StoreGifPicker.this).schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$3 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59623 extends Lambda implements Function1<List<? extends ModelGif>, Unit> {
        public final /* synthetic */ String $query;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifPicker.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $gifs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$gifs = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59623 c59623 = C59623.this;
                StoreGifPicker storeGifPicker = StoreGifPicker.this;
                String str = c59623.$query;
                List list = this.$gifs;
                Intrinsics3.checkNotNullExpressionValue(list, "gifs");
                StoreGifPicker.access$handleGifSearchResults(storeGifPicker, str, list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59623(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGif> list) {
            invoke2((List<ModelGif>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGif> list) {
            StoreGifPicker.access$getDispatcher$p(StoreGifPicker.this).schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59631 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $query;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifPicker.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59631 c59631 = C59631.this;
                StoreGifPicker.access$handleSuggestedSearchTerms(StoreGifPicker.this, c59631.$query, Collections2.emptyList());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59631(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGifPicker.access$getDispatcher$p(StoreGifPicker.this).schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59642 extends Lambda implements Function1<List<? extends String>, Unit> {
        public final /* synthetic */ String $query;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifPicker.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $suggestedSearchTerms;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$suggestedSearchTerms = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59642 c59642 = C59642.this;
                StoreGifPicker.access$handleSuggestedSearchTerms(StoreGifPicker.this, c59642.$query, this.$suggestedSearchTerms);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59642(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> list) {
            Intrinsics3.checkNotNullParameter(list, "suggestedSearchTerms");
            StoreGifPicker.access$getDispatcher$p(StoreGifPicker.this).schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchTrendingCategoryGifs$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59651<T, R> implements Func1<List<? extends GifDto>, List<? extends ModelGif>> {
        public static final C59651 INSTANCE = new C59651();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends ModelGif> call(List<? extends GifDto> list) {
            return call2((List<GifDto>) list);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ModelGif> call2(List<GifDto> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "gifDtos");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ModelGif.INSTANCE.createFromGifDto((GifDto) it.next()));
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchTrendingCategoryGifs$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59662 extends Lambda implements Function1<Error, Unit> {
        public C59662() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGifPicker.access$handleFetchTrendingGifsError(StoreGifPicker.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$fetchTrendingCategoryGifs$3 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final /* synthetic */ class C59673 extends FunctionReferenceImpl implements Function1<List<? extends ModelGif>, Unit> {
        public C59673(StoreGifPicker storeGifPicker) {
            super(1, storeGifPicker, StoreGifPicker.class, "handleFetchTrendingGifsOnNext", "handleFetchTrendingGifsOnNext(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGif> list) {
            invoke2((List<ModelGif>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGif> list) {
            Intrinsics3.checkNotNullParameter(list, "p1");
            StoreGifPicker.access$handleFetchTrendingGifsOnNext((StoreGifPicker) this.receiver, list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchGifCategoriesError$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59681 extends Lambda implements Function0<Unit> {
        public C59681() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$setFetchingGifCategories$p(StoreGifPicker.this, false);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchGifCategoriesOnNext$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59691 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ TrendingGifCategoriesResponseDto $trendingGifsResponseRaw;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59691(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
            super(0);
            this.$trendingGifsResponseRaw = trendingGifCategoriesResponseDto;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$handleTrendingCategoriesResponse(StoreGifPicker.this, this.$trendingGifsResponseRaw);
            StoreGifPicker.access$setFetchingGifCategories$p(StoreGifPicker.this, false);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingGifsError$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59701 extends Lambda implements Function0<Unit> {
        public C59701() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$setFetchingTrendingCategoryGifs$p(StoreGifPicker.this, false);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingGifsOnNext$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59711 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $gifs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59711(List list) {
            super(0);
            this.$gifs = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$updateTrendingCategoryGifs(StoreGifPicker.this, this.$gifs);
            StoreGifPicker.access$setFetchingTrendingCategoryGifs$p(StoreGifPicker.this, false);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingSearchTermsError$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59721 extends Lambda implements Function0<Unit> {
        public C59721() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$setFetchingTrendingSearchTerms$p(StoreGifPicker.this, false);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingSearchTermsOnNext$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59731 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $trendingSearchTerms;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59731(List list) {
            super(0);
            this.$trendingSearchTerms = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$updateTrendingSearchTerms(StoreGifPicker.this, this.$trendingSearchTerms);
            StoreGifPicker.access$setFetchingTrendingSearchTerms$p(StoreGifPicker.this, false);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifCategories$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59741 extends Lambda implements Function0<Unit> {
        public C59741() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGifPicker.access$getGifCategories$p(StoreGifPicker.this).isEmpty() || StoreGifPicker.access$isFetchingGifCategories$p(StoreGifPicker.this)) {
                return;
            }
            StoreGifPicker.this.fetchGifCategories();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifCategories$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59752 extends Lambda implements Function0<List<? extends ModelGifCategory>> {
        public C59752() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelGifCategory> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelGifCategory> invoke2() {
            return StoreGifPicker.access$getGifCategories(StoreGifPicker.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifTrendingSearchTerms$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59761 extends Lambda implements Function0<Unit> {
        public C59761() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGifPicker.access$getGifTrendingSearchTerms$p(StoreGifPicker.this).isEmpty() || StoreGifPicker.access$isFetchingTrendingSearchTerms$p(StoreGifPicker.this)) {
                return;
            }
            StoreGifPicker.access$fetchGifTrendingSearchTerms(StoreGifPicker.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifTrendingSearchTerms$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59772 extends Lambda implements Function0<List<? extends String>> {
        public C59772() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends String> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends String> invoke2() {
            return StoreGifPicker.access$getGifTrendingSearchTerms(StoreGifPicker.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifsForSearchQuery$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59781 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59781(String str) {
            super(0);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreGifPicker.access$getGifSearchHistory$p(StoreGifPicker.this).containsKey(this.$query)) {
                return;
            }
            StoreGifPicker.access$getGifSearchHistory$p(StoreGifPicker.this).put(this.$query, StoreGifPicker.INSTANCE.getSearchResultsLoadingList());
            StoreGifPicker.access$fetchGifsForSearchQuery(StoreGifPicker.this, this.$query);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeGifsForSearchQuery$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59792<T, R> implements Func1<Map<String, ? extends List<? extends ModelGif>>, List<? extends ModelGif>> {
        public final /* synthetic */ String $query;

        public C59792(String str) {
            this.$query = str;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends ModelGif> call(Map<String, ? extends List<? extends ModelGif>> map) {
            return call2((Map<String, ? extends List<ModelGif>>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ModelGif> call2(Map<String, ? extends List<ModelGif>> map) {
            return map.get(this.$query);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeSearchHistory$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59801 extends Lambda implements Function0<Map<String, ? extends List<? extends ModelGif>>> {
        public C59801() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends List<? extends ModelGif>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends List<? extends ModelGif>> invoke2() {
            return StoreGifPicker.access$getSearchHistory(StoreGifPicker.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeSuggestedSearchTerms$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59811 extends Lambda implements Function0<Map<String, ? extends List<? extends String>>> {
        public C59811() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends List<? extends String>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends List<? extends String>> invoke2() {
            return StoreGifPicker.access$getSuggestedSearchTermsHistory(StoreGifPicker.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeSuggestedSearchTerms$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59822 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59822(String str) {
            super(0);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreGifPicker.access$getGifSuggestedSearchTermsHistory$p(StoreGifPicker.this).containsKey(this.$query)) {
                return;
            }
            StoreGifPicker.access$getGifSuggestedSearchTermsHistory$p(StoreGifPicker.this).put(this.$query, StoreGifPicker.INSTANCE.getSearchTermsLoadingList());
            StoreGifPicker.access$fetchSuggestedSearchTerms(StoreGifPicker.this, this.$query);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeSuggestedSearchTerms$3 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59833<T, R> implements Func1<Map<String, ? extends List<? extends String>>, List<? extends String>> {
        public final /* synthetic */ String $query;

        public C59833(String str) {
            this.$query = str;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends String> call(Map<String, ? extends List<? extends String>> map) {
            return call2((Map<String, ? extends List<String>>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<String> call2(Map<String, ? extends List<String>> map) {
            return map.get(this.$query);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeTrendingCategoryGifs$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59841 extends Lambda implements Function0<Unit> {
        public C59841() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGifPicker.access$getTrendingCategoryGifs$p(StoreGifPicker.this).isEmpty() || StoreGifPicker.access$isFetchingTrendingCategoryGifs$p(StoreGifPicker.this)) {
                return;
            }
            StoreGifPicker.access$fetchTrendingCategoryGifs(StoreGifPicker.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeTrendingCategoryGifs$2 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59852 extends Lambda implements Function0<List<? extends ModelGif>> {
        public C59852() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelGif> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelGif> invoke2() {
            return StoreGifPicker.access$getTrendingCategoryGifs(StoreGifPicker.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifPicker$observeTrendingGifCategoryPreviewUrl$1 */
    /* JADX INFO: compiled from: StoreGifPicker.kt */
    public static final class C59861 extends Lambda implements Function0<String> {
        public C59861() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            return StoreGifPicker.access$getTrendingGifCategoryPreviewUrl(StoreGifPicker.this);
        }
    }

    public /* synthetic */ StoreGifPicker(Dispatcher dispatcher, StoreUserSettingsSystem storeUserSettingsSystem, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUserSettingsSystem, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ void access$fetchGifTrendingSearchTerms(StoreGifPicker storeGifPicker) {
        storeGifPicker.fetchGifTrendingSearchTerms();
    }

    public static final /* synthetic */ void access$fetchGifsForSearchQuery(StoreGifPicker storeGifPicker, String str) {
        storeGifPicker.fetchGifsForSearchQuery(str);
    }

    public static final /* synthetic */ void access$fetchSuggestedSearchTerms(StoreGifPicker storeGifPicker, String str) {
        storeGifPicker.fetchSuggestedSearchTerms(str);
    }

    public static final /* synthetic */ void access$fetchTrendingCategoryGifs(StoreGifPicker storeGifPicker) {
        storeGifPicker.fetchTrendingCategoryGifs();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.dispatcher;
    }

    public static final /* synthetic */ List access$getGifCategories(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getGifCategories();
    }

    public static final /* synthetic */ List access$getGifCategories$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifCategories;
    }

    public static final /* synthetic */ CacheHistory access$getGifSearchHistory$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifSearchHistory;
    }

    public static final /* synthetic */ CacheHistory access$getGifSuggestedSearchTermsHistory$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifSuggestedSearchTermsHistory;
    }

    public static final /* synthetic */ List access$getGifTrendingSearchTerms(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getGifTrendingSearchTerms();
    }

    public static final /* synthetic */ List access$getGifTrendingSearchTerms$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifTrendingSearchTerms;
    }

    public static final /* synthetic */ Map access$getSearchHistory(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getSearchHistory();
    }

    public static final /* synthetic */ List access$getSearchResultsLoadingList$cp() {
        return searchResultsLoadingList;
    }

    public static final /* synthetic */ List access$getSearchTermsLoadingList$cp() {
        return searchTermsLoadingList;
    }

    public static final /* synthetic */ Map access$getSuggestedSearchTermsHistory(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getSuggestedSearchTermsHistory();
    }

    public static final /* synthetic */ List access$getTrendingCategoryGifs(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getTrendingCategoryGifs();
    }

    public static final /* synthetic */ List access$getTrendingCategoryGifs$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.trendingCategoryGifs;
    }

    public static final /* synthetic */ String access$getTrendingGifCategoryPreviewUrl(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getTrendingGifCategoryPreviewUrl();
    }

    public static final /* synthetic */ void access$handleFetchGifCategoriesError(StoreGifPicker storeGifPicker) {
        storeGifPicker.handleFetchGifCategoriesError();
    }

    public static final /* synthetic */ void access$handleFetchGifCategoriesOnNext(StoreGifPicker storeGifPicker, TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        storeGifPicker.handleFetchGifCategoriesOnNext(trendingGifCategoriesResponseDto);
    }

    public static final /* synthetic */ void access$handleFetchTrendingGifsError(StoreGifPicker storeGifPicker) {
        storeGifPicker.handleFetchTrendingGifsError();
    }

    public static final /* synthetic */ void access$handleFetchTrendingGifsOnNext(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.handleFetchTrendingGifsOnNext(list);
    }

    public static final /* synthetic */ void access$handleFetchTrendingSearchTermsError(StoreGifPicker storeGifPicker) {
        storeGifPicker.handleFetchTrendingSearchTermsError();
    }

    public static final /* synthetic */ void access$handleFetchTrendingSearchTermsOnNext(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.handleFetchTrendingSearchTermsOnNext(list);
    }

    public static final /* synthetic */ void access$handleGifSearchResults(StoreGifPicker storeGifPicker, String str, List list) {
        storeGifPicker.handleGifSearchResults(str, list);
    }

    public static final /* synthetic */ void access$handleSuggestedSearchTerms(StoreGifPicker storeGifPicker, String str, List list) {
        storeGifPicker.handleSuggestedSearchTerms(str, list);
    }

    public static final /* synthetic */ void access$handleTrendingCategoriesResponse(StoreGifPicker storeGifPicker, TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        storeGifPicker.handleTrendingCategoriesResponse(trendingGifCategoriesResponseDto);
    }

    public static final /* synthetic */ boolean access$isFetchingGifCategories$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.isFetchingGifCategories;
    }

    public static final /* synthetic */ boolean access$isFetchingTrendingCategoryGifs$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.isFetchingTrendingCategoryGifs;
    }

    public static final /* synthetic */ boolean access$isFetchingTrendingSearchTerms$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.isFetchingTrendingSearchTerms;
    }

    public static final /* synthetic */ void access$setFetchingGifCategories$p(StoreGifPicker storeGifPicker, boolean z2) {
        storeGifPicker.isFetchingGifCategories = z2;
    }

    public static final /* synthetic */ void access$setFetchingTrendingCategoryGifs$p(StoreGifPicker storeGifPicker, boolean z2) {
        storeGifPicker.isFetchingTrendingCategoryGifs = z2;
    }

    public static final /* synthetic */ void access$setFetchingTrendingSearchTerms$p(StoreGifPicker storeGifPicker, boolean z2) {
        storeGifPicker.isFetchingTrendingSearchTerms = z2;
    }

    public static final /* synthetic */ void access$updateTrendingCategoryGifs(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.updateTrendingCategoryGifs(list);
    }

    public static final /* synthetic */ void access$updateTrendingSearchTerms(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.updateTrendingSearchTerms(list);
    }

    private final void fetchGifTrendingSearchTerms() {
        this.isFetchingTrendingSearchTerms = true;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifTrendingSearchTerms("tenor", this.storeUserSettingsSystem.getLocale(), 5), false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new C59581(), (Function0) null, (Function0) null, new C59592(this), 54, (Object) null);
    }

    private final void fetchGifsForSearchQuery(String query) {
        Observable<R> observableM11083G = this.restAPI.getGifSearchResults(query, "tenor", this.storeUserSettingsSystem.getLocale(), "tinygif", 50).m11083G(C59601.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "restAPI.getGifSearchResu…to)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableM11083G, false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new C59612(query), (Function0) null, (Function0) null, new C59623(query), 54, (Object) null);
    }

    private final void fetchSuggestedSearchTerms(String query) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifSuggestedSearchTerms("tenor", query, this.storeUserSettingsSystem.getLocale(), 5), false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new C59631(query), (Function0) null, (Function0) null, new C59642(query), 54, (Object) null);
    }

    private final void fetchTrendingCategoryGifs() {
        this.isFetchingTrendingCategoryGifs = true;
        Observable<R> observableM11083G = this.restAPI.getTrendingGifCategory("tenor", this.storeUserSettingsSystem.getLocale(), "tinygif", 50).m11083G(C59651.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "restAPI.getTrendingGifCa…to)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableM11083G, false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new C59662(), (Function0) null, (Function0) null, new C59673(this), 54, (Object) null);
    }

    private final List<ModelGifCategory> getGifCategories() {
        return this.gifCategoriesSnapshot;
    }

    private final List<String> getGifTrendingSearchTerms() {
        return this.gifTrendingSearchTermsSnapshot;
    }

    private final Map<String, List<ModelGif>> getSearchHistory() {
        return this.gifSearchHistorySnapshot;
    }

    private final Map<String, List<String>> getSuggestedSearchTermsHistory() {
        return this.gifSuggestedSearchTermsHistory;
    }

    private final List<ModelGif> getTrendingCategoryGifs() {
        return this.trendingCategoryGifsSnapshot;
    }

    private final String getTrendingGifCategoryPreviewUrl() {
        return this.trendingGifCategoryPreviewUrl;
    }

    private final void handleFetchGifCategoriesError() {
        this.dispatcher.schedule(new C59681());
    }

    private final void handleFetchGifCategoriesOnNext(TrendingGifCategoriesResponseDto trendingGifsResponseRaw) {
        this.dispatcher.schedule(new C59691(trendingGifsResponseRaw));
    }

    private final void handleFetchTrendingGifsError() {
        this.dispatcher.schedule(new C59701());
    }

    private final void handleFetchTrendingGifsOnNext(List<ModelGif> gifs) {
        this.dispatcher.schedule(new C59711(gifs));
    }

    private final void handleFetchTrendingSearchTermsError() {
        this.dispatcher.schedule(new C59721());
    }

    private final void handleFetchTrendingSearchTermsOnNext(List<String> trendingSearchTerms) {
        this.dispatcher.schedule(new C59731(trendingSearchTerms));
    }

    @Store3
    private final void handleGifSearchResults(String query, List<ModelGif> gifs) {
        this.gifSearchHistory.put(query, gifs);
        markChanged();
    }

    @Store3
    private final void handleSuggestedSearchTerms(String query, List<String> suggestedSearchTerms) {
        this.gifSuggestedSearchTermsHistory.put(query, suggestedSearchTerms);
        markChanged();
    }

    @Store3
    private final void handleTrendingCategoriesResponse(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        List<GifCategoryDto> categories = trendingGifCategoriesResponseDto.getCategories();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(categories, 10));
        for (GifCategoryDto gifCategoryDto : categories) {
            arrayList.add(new ModelGifCategory(gifCategoryDto.getName(), gifCategoryDto.getSrc()));
        }
        updateGifCategories(arrayList);
        List<TrendingGifPreviewDto> gifs = trendingGifCategoriesResponseDto.getGifs();
        this.trendingGifCategoryPreviewUrl = gifs.isEmpty() ^ true ? gifs.get(0).getSrc() : "";
        markChanged();
    }

    private final Observable<Map<String, List<ModelGif>>> observeSearchHistory() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59801(), 12, null);
    }

    private final Observable<Map<String, List<String>>> observeSuggestedSearchTerms() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59811(), 12, null);
    }

    @Store3
    private final void updateGifCategories(List<ModelGifCategory> categories) {
        this.gifCategories.clear();
        this.gifCategories.addAll(categories);
        markChanged();
    }

    @Store3
    private final void updateTrendingCategoryGifs(List<ModelGif> gifs) {
        this.trendingCategoryGifs.clear();
        this.trendingCategoryGifs.addAll(gifs);
        markChanged();
    }

    @Store3
    private final void updateTrendingSearchTerms(List<String> trendingGifSearchTerms) {
        this.gifTrendingSearchTerms.clear();
        this.gifTrendingSearchTerms.addAll(trendingGifSearchTerms);
        markChanged();
    }

    public final void fetchGifCategories() {
        this.isFetchingGifCategories = true;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getTrendingGifCategories("tenor", this.storeUserSettingsSystem.getLocale(), "tinygif"), false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new C59561(), (Function0) null, (Function0) null, new C59572(this), 54, (Object) null);
    }

    public final Observable<List<ModelGifCategory>> observeGifCategories() {
        this.dispatcher.schedule(new C59741());
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59752(), 12, null);
    }

    public final Observable<List<String>> observeGifTrendingSearchTerms() {
        this.dispatcher.schedule(new C59761());
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59772(), 12, null);
    }

    public final Observable<List<ModelGif>> observeGifsForSearchQuery(String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new C59781(query));
        Observable<R> observableM11083G = observeSearchHistory().m11083G(new C59792(query));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "observeSearchHistory().m…gifSearchHistory[query] }");
        Observable<List<ModelGif>> observableM11083G2 = observableM11083G.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G2, "filter { it != null }.map { it!! }");
        return observableM11083G2;
    }

    public final Observable<List<ModelGif>> observeTrendingCategoryGifs() {
        this.dispatcher.schedule(new C59841());
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59852(), 12, null);
    }

    public final Observable<String> observeTrendingGifCategoryPreviewUrl() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new C59861(), 12, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.gifCategoriesSnapshot = new ArrayList(this.gifCategories);
        this.gifTrendingSearchTermsSnapshot = new ArrayList(this.gifTrendingSearchTerms);
        this.gifSearchHistorySnapshot = new HashMap(this.gifSearchHistory);
        this.suggestedSearchTermsSnapshot = new HashMap(this.gifSuggestedSearchTermsHistory);
        this.trendingCategoryGifsSnapshot = new ArrayList(this.trendingCategoryGifs);
    }

    public final Observable<List<String>> observeSuggestedSearchTerms(String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new C59822(query));
        Observable<R> observableM11083G = observeSuggestedSearchTerms().m11083G(new C59833(query));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "observeSuggestedSearchTe…archTermsHistory[query] }");
        Observable<List<String>> observableM11083G2 = observableM11083G.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G2, "filter { it != null }.map { it!! }");
        return observableM11083G2;
    }

    public StoreGifPicker(Dispatcher dispatcher, StoreUserSettingsSystem storeUserSettingsSystem, RestAPI restAPI, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.gifCategoriesSnapshot = Collections2.emptyList();
        this.gifTrendingSearchTermsSnapshot = Collections2.emptyList();
        this.gifSearchHistorySnapshot = Maps6.emptyMap();
        this.suggestedSearchTermsSnapshot = Maps6.emptyMap();
        this.trendingCategoryGifsSnapshot = Collections2.emptyList();
        this.gifCategories = new ArrayList();
        this.gifTrendingSearchTerms = new ArrayList();
        this.trendingCategoryGifs = new ArrayList();
        this.trendingGifCategoryPreviewUrl = "";
        this.gifSearchHistory = new CacheHistory<>();
        this.gifSuggestedSearchTermsHistory = new CacheHistory<>();
    }
}
