package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreGifPicker;
import com.discord.widgets.chat.input.gifpicker.GifSearchViewModel;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: GifSearchViewModel.kt */
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifSearchViewModel3<T, R> implements Func1<String, Observable<? extends GifSearchViewModel.StoreState>> {
    public final /* synthetic */ StoreGifPicker $storeGifPicker;
    public final /* synthetic */ List $trendingSearchTerms;

    /* compiled from: GifSearchViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2$1 */
    public static final class C78721<T, R> implements Func1<List<? extends ModelGif>, Boolean> {
        public static final C78721 INSTANCE = new C78721();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(List<? extends ModelGif> list) {
            return call2((List<ModelGif>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<ModelGif> list) {
            return Boolean.valueOf(list != StoreGifPicker.INSTANCE.getSearchResultsLoadingList());
        }
    }

    /* compiled from: GifSearchViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2$2 */
    public static final class C78732<T1, T2, R> implements Func2<List<? extends ModelGif>, List<? extends String>, GifSearchViewModel.StoreState.SearchResults> {
        public final /* synthetic */ String $query;

        public C78732(String str) {
            this.$query = str;
        }

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ GifSearchViewModel.StoreState.SearchResults call(List<? extends ModelGif> list, List<? extends String> list2) {
            return call2((List<ModelGif>) list, (List<String>) list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GifSearchViewModel.StoreState.SearchResults call2(List<ModelGif> list, List<String> list2) {
            Intrinsics3.checkNotNullExpressionValue(list, "gifResults");
            Intrinsics3.checkNotNullExpressionValue(list2, "searchTerms");
            return new GifSearchViewModel.StoreState.SearchResults(list, list2, GifSearchViewModel3.this.$trendingSearchTerms, this.$query);
        }
    }

    public GifSearchViewModel3(List list, StoreGifPicker storeGifPicker) {
        this.$trendingSearchTerms = list;
        this.$storeGifPicker = storeGifPicker;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends GifSearchViewModel.StoreState> call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GifSearchViewModel.StoreState> call2(String str) {
        Intrinsics3.checkNotNullExpressionValue(str, "query");
        return str.length() == 0 ? new ScalarSynchronousObservable(new GifSearchViewModel.StoreState.TrendingSearchTermsResults(this.$trendingSearchTerms)) : Observable.m11076j(this.$storeGifPicker.observeGifsForSearchQuery(str).m11118y(C78721.INSTANCE), this.$storeGifPicker.observeSuggestedSearchTerms(str), new C78732(str));
    }
}
