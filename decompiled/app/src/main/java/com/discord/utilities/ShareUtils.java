package com.discord.utilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.p004pm.ShortcutInfoCompat;
import androidx.core.content.p004pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.colors.RepresentativeColors;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p578f0._Sequences2;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p591y.Closeable;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: ShareUtils.kt */
/* loaded from: classes2.dex */
public final class ShareUtils {
    public static final ShareUtils INSTANCE = new ShareUtils();

    /* compiled from: ShareUtils.kt */
    public static final /* data */ class SharedContent {
        private final CharSequence text;
        private final List<Uri> uris;

        /* JADX WARN: Multi-variable type inference failed */
        public SharedContent(CharSequence charSequence, List<? extends Uri> list) {
            this.text = charSequence;
            this.uris = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SharedContent copy$default(SharedContent sharedContent, CharSequence charSequence, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = sharedContent.text;
            }
            if ((i & 2) != 0) {
                list = sharedContent.uris;
            }
            return sharedContent.copy(charSequence, list);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        public final List<Uri> component2() {
            return this.uris;
        }

        public final SharedContent copy(CharSequence text, List<? extends Uri> uris) {
            return new SharedContent(text, uris);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedContent)) {
                return false;
            }
            SharedContent sharedContent = (SharedContent) other;
            return Intrinsics3.areEqual(this.text, sharedContent.text) && Intrinsics3.areEqual(this.uris, sharedContent.uris);
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final List<Uri> getUris() {
            return this.uris;
        }

        public int hashCode() {
            CharSequence charSequence = this.text;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            List<Uri> list = this.uris;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("SharedContent(text=");
            sbM833U.append(this.text);
            sbM833U.append(", uris=");
            return outline.m824L(sbM833U, this.uris, ")");
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1 */
    public static final class C66491<T, R> implements Func1<MGImagesBitmap.CloseableBitmaps, Observable<? extends MGImagesBitmap.CloseableBitmaps>> {
        public final /* synthetic */ int $fillMargins;
        public final /* synthetic */ int $fullBitmapSize;
        public final /* synthetic */ int $iconSize;

        /* compiled from: ShareUtils.kt */
        /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Map.Entry<? extends String, ? extends Bitmap>, Observable<? extends Tuples2<? extends String, ? extends Bitmap>>> {
            public final /* synthetic */ RepresentativeColors $representativeColors;

            /* compiled from: ShareUtils.kt */
            /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C132701<T, R> implements Func1<Integer, Tuples2<? extends String, ? extends Bitmap>> {
                public final /* synthetic */ Bitmap $bitmap;
                public final /* synthetic */ String $url;

                public C132701(String str, Bitmap bitmap) {
                    this.$url = str;
                    this.$bitmap = bitmap;
                }

                @Override // p637j0.p641k.Func1
                public /* bridge */ /* synthetic */ Tuples2<? extends String, ? extends Bitmap> call(Integer num) {
                    return call2(num);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Tuples2<String, Bitmap> call2(Integer num) {
                    String str = this.$url;
                    MGImages mGImages = MGImages.INSTANCE;
                    Bitmap bitmap = this.$bitmap;
                    C66491 c66491 = C66491.this;
                    int i = c66491.$iconSize;
                    int i2 = c66491.$fullBitmapSize;
                    return Tuples.m10073to(str, mGImages.centerBitmapInTransparentBitmap(bitmap, i, i, i2, i2, c66491.$fillMargins, num != null ? num.intValue() : 0));
                }
            }

            public AnonymousClass1(RepresentativeColors representativeColors) {
                this.$representativeColors = representativeColors;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends String, ? extends Bitmap>> call(Map.Entry<? extends String, ? extends Bitmap> entry) {
                return call2((Map.Entry<String, Bitmap>) entry);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Tuples2<String, Bitmap>> call2(Map.Entry<String, Bitmap> entry) {
                Observable<R> scalarSynchronousObservable;
                String key = entry.getKey();
                Bitmap value = entry.getValue();
                if (value.getWidth() <= 0 || value.getHeight() <= 0 || value.getPixel(0, 0) != 0) {
                    scalarSynchronousObservable = new ScalarSynchronousObservable(0);
                } else {
                    RepresentativeColors.handleBitmap$default(this.$representativeColors, key, value, null, 4, null);
                    Observable<R> observableM11083G = this.$representativeColors.observeRepresentativeColor(key).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
                    Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
                    scalarSynchronousObservable = observableM11083G.m11119z().m11104c0(2L, TimeUnit.SECONDS).m11087M(ShareUtils$loadAdaptiveBitmaps$1$1$representativeColor$1.INSTANCE);
                }
                return scalarSynchronousObservable.m11083G(new C132701(key, value));
            }
        }

        /* compiled from: ShareUtils.kt */
        /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<Map<String, ? extends Bitmap>, MGImagesBitmap.CloseableBitmaps> {
            public final /* synthetic */ MGImagesBitmap.CloseableBitmaps $iconBitmaps;

            public AnonymousClass2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                this.$iconBitmaps = closeableBitmaps;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ MGImagesBitmap.CloseableBitmaps call(Map<String, ? extends Bitmap> map) {
                return call2((Map<String, Bitmap>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final MGImagesBitmap.CloseableBitmaps call2(Map<String, Bitmap> map) {
                this.$iconBitmaps.close();
                Intrinsics3.checkNotNullExpressionValue(map, "bitmaps");
                return new MGImagesBitmap.CloseableBitmaps(map, false);
            }
        }

        public C66491(int i, int i2, int i3) {
            this.$iconSize = i;
            this.$fullBitmapSize = i2;
            this.$fillMargins = i3;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends MGImagesBitmap.CloseableBitmaps> call(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            return call2(closeableBitmaps);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends MGImagesBitmap.CloseableBitmaps> call2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            Observable<R> observableM11109n = Observable.m11058B(closeableBitmaps.entrySet()).m11109n(new AnonymousClass1(new RepresentativeColors()));
            Intrinsics3.checkNotNullExpressionValue(observableM11109n, "Observable.from(iconBitm…        }\n              }");
            return ObservableExtensionsKt.toMap(observableM11109n).m11083G(new AnonymousClass2(closeableBitmaps));
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$1 */
    public static final class C66501<T, R> implements Func1<List<? extends Channel>, List<? extends ChannelShortcutInfo>> {
        public static final C66501 INSTANCE = new C66501();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends ChannelShortcutInfo> call(List<? extends Channel> list) {
            return call2((List<Channel>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ChannelShortcutInfo> call2(List<Channel> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                arrayList.add(new ChannelShortcutInfo((Channel) t, i, false));
                i = i2;
            }
            return arrayList;
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$2 */
    public static final class C66512<T, R> implements Func1<Map<Long, ? extends Channel>, Boolean> {
        public static final C66512 INSTANCE = new C66512();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Map<Long, Channel> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "it");
            return Boolean.valueOf(!map.isEmpty());
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$3 */
    public static final class C66523<T1, T2, R> implements Func2<List<? extends ChannelShortcutInfo>, Map<Long, ? extends Channel>, List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>> {
        public final /* synthetic */ Context $context;

        public C66523(Context context) {
            this.$context = context;
        }

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>> call(List<? extends ChannelShortcutInfo> list, Map<Long, ? extends Channel> map) {
            return call2((List<ChannelShortcutInfo>) list, (Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Tuples2<ChannelShortcutInfo, String>> call2(List<ChannelShortcutInfo> list, Map<Long, Channel> map) {
            Intrinsics3.checkNotNullExpressionValue(list, "directShareChannels");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((ChannelShortcutInfo) it.next()).getChannel().getId()));
            }
            Set set = _Collections.toSet(arrayList);
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.$context);
            Intrinsics3.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            List<ChannelShortcutInfo> listPlus = _Collections.plus((Collection) list, _Sequences2.map(_Sequences2.mapNotNull(_Sequences2.filter(_Sequences2.map(_Sequences2.filter(_Collections.asSequence(dynamicShortcuts), C6653x626dc25a.INSTANCE), C6654x626dc25b.INSTANCE), new C6655x626dc25c(set)), new C6656x626dc25d(map)), C6657x626dc25e.INSTANCE));
            ArrayList arrayList2 = new ArrayList();
            for (ChannelShortcutInfo channelShortcutInfo : listPlus) {
                String forChannel$default = IconUtils.getForChannel$default(channelShortcutInfo.getChannel(), null, 2, null);
                Tuples2 tuples2M10073to = forChannel$default != null ? Tuples.m10073to(channelShortcutInfo, forChannel$default) : null;
                if (tuples2M10073to != null) {
                    arrayList2.add(tuples2M10073to);
                }
            }
            return arrayList2;
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$1 */
    public static final class C66581<T, R> implements Func1<List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, Observable<? extends Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>>> {
        public static final C66581 INSTANCE = new C66581();

        /* compiled from: ShareUtils.kt */
        /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<MGImagesBitmap.CloseableBitmaps, Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>> {
            public final /* synthetic */ List $channelAndIconUriPairs;

            public AnonymousClass1(List list) {
                this.$channelAndIconUriPairs = list;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps> call(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                return call2(closeableBitmaps);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples2<List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps> call2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                return Tuples.m10073to(this.$channelAndIconUriPairs, closeableBitmaps);
            }
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>> call(List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>> list) {
            return call2((List<Tuples2<ChannelShortcutInfo, String>>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Tuples2<List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps>> call2(List<Tuples2<ChannelShortcutInfo, String>> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "channelAndIconUriPairs");
            return ShareUtils.INSTANCE.loadAdaptiveBitmaps(_Sequences2.map(_Collections.asSequence(list), ShareUtils$updateDirectShareTargets$1$uris$1.INSTANCE)).m11083G(new AnonymousClass1(list));
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$2 */
    public static final class C66592 extends Lambda implements Function1<Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66592(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps> tuples2) throws IOException {
            invoke2((Tuples2<? extends List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps>) tuples2);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps> tuples2) throws IOException {
            List<Tuples2<ChannelShortcutInfo, String>> listComponent1 = tuples2.component1();
            MGImagesBitmap.CloseableBitmaps closeableBitmapsComponent2 = tuples2.component2();
            try {
                ShareUtils shareUtils = ShareUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(listComponent1, "channelAndIconUriPairs");
                Context context = this.$context;
                Intrinsics3.checkNotNullExpressionValue(closeableBitmapsComponent2, "iconBitmaps");
                ShareUtils.access$updateDynamicShortcuts(shareUtils, listComponent1, context, closeableBitmapsComponent2);
                Closeable.closeFinally(closeableBitmapsComponent2, null);
            } finally {
            }
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$3 */
    public static final class C66603<T, R> implements Func1<Map<Long, ? extends Channel>, Boolean> {
        public static final C66603 INSTANCE = new C66603();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Map<Long, Channel> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "it");
            return Boolean.valueOf(!map.isEmpty());
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$4 */
    public static final class C66614 extends Lambda implements Function1<Map<Long, ? extends Channel>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66614(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Channel> map) {
            invoke2((Map<Long, Channel>) map);
            return Unit.f27425a;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2(Map<Long, Channel> map) {
            boolean z2;
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.$context);
            ArrayList<ShortcutInfoCompat> arrayListM840a0 = outline.m840a0(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            for (Object obj : dynamicShortcuts) {
                ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) obj;
                Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (shortcutInfoCompat.isPinned()) {
                    String id2 = shortcutInfoCompat.getId();
                    Intrinsics3.checkNotNullExpressionValue(id2, "it.id");
                    z2 = !map.containsKey(Long.valueOf(Long.parseLong(id2)));
                }
                if (z2) {
                    arrayListM840a0.add(obj);
                }
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arrayListM840a0, 10));
            for (ShortcutInfoCompat shortcutInfoCompat2 : arrayListM840a0) {
                Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat2, "it");
                arrayList.add(shortcutInfoCompat2.getId());
            }
            ShortcutManagerCompat.disableShortcuts(this.$context, arrayList, "The channels these shortcuts are for no longer exist.");
            ShortcutManagerCompat.removeLongLivedShortcuts(this.$context, arrayList);
        }
    }

    private ShareUtils() {
    }

    public static final /* synthetic */ void access$updateDynamicShortcuts(ShareUtils shareUtils, List list, Context context, MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
        shareUtils.updateDynamicShortcuts(list, context, closeableBitmaps);
    }

    public static /* synthetic */ void addShortcut$default(ShareUtils shareUtils, Context context, ShortcutInfoCompat shortcutInfoCompat, NotificationCompat.Builder builder, int i, Object obj) {
        if ((i & 4) != 0) {
            builder = null;
        }
        shareUtils.addShortcut(context, shortcutInfoCompat, builder);
    }

    private final Observable<List<Tuples2<ChannelShortcutInfo, String>>> observeChannelAndIconPairs(Context context) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11083G = ObservableExtensionsKt.takeSingleUntilTimeout$default(companion.getChannels().observeDirectShareCandidates(context), 0L, false, 1, null).m11083G(C66501.INSTANCE);
        Observable<Map<Long, Channel>> observableM11118y = companion.getChannels().observeGuildAndPrivateChannels().m11118y(C66512.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11118y, "StoreStream\n            …ilter { it.isNotEmpty() }");
        return Observable.m11076j(observableM11083G, ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y, 0L, false, 1, null), new C66523(context));
    }

    public static /* synthetic */ ShortcutInfoCompat toShortcutInfo$default(ShareUtils shareUtils, Context context, long j, CharSequence charSequence, CharSequence charSequence2, IconCompat iconCompat, List list, int i, int i2, Object obj) {
        return shareUtils.toShortcutInfo(context, j, charSequence, (i2 & 8) != 0 ? charSequence : charSequence2, (i2 & 16) != 0 ? null : iconCompat, (i2 & 32) != 0 ? Collections2.emptyList() : list, (i2 & 64) != 0 ? 0 : i);
    }

    private final void updateDynamicShortcuts(List<Tuples2<ChannelShortcutInfo, String>> channelAndIconUriPairs, Context context, MGImagesBitmap.CloseableBitmaps iconBitmaps) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = channelAndIconUriPairs.iterator();
        while (it.hasNext()) {
            Tuples2 tuples2 = (Tuples2) it.next();
            Boolean boolValueOf = Boolean.valueOf(((ChannelShortcutInfo) tuples2.component1()).isPinnedOnly());
            Object arrayList = linkedHashMap.get(boolValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(boolValueOf, arrayList);
            }
            List list = (List) arrayList;
            ChannelShortcutInfo channelShortcutInfo = (ChannelShortcutInfo) tuples2.component1();
            String str = (String) tuples2.component2();
            ShareUtils shareUtils = INSTANCE;
            Channel channel = channelShortcutInfo.getChannel();
            Bitmap bitmap = (Bitmap) iconBitmaps.get((Object) str);
            list.add(shareUtils.toShortcutInfo(channel, context, bitmap != null ? IconCompat.createWithAdaptiveBitmap(bitmap) : null, channelShortcutInfo.getRank()));
        }
        Object objEmptyList = linkedHashMap.get(Boolean.FALSE);
        if (objEmptyList == null) {
            objEmptyList = Collections2.emptyList();
        }
        List list2 = (List) objEmptyList;
        Object objEmptyList2 = linkedHashMap.get(Boolean.TRUE);
        if (objEmptyList2 == null) {
            objEmptyList2 = Collections2.emptyList();
        }
        ShortcutManagerCompat.setDynamicShortcuts(context, list2);
        ShortcutManagerCompat.updateShortcuts(context, (List) objEmptyList2);
    }

    public final void addShortcut(Context context, ShortcutInfoCompat shortcutInfo, NotificationCompat.Builder notificationBuilder) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(shortcutInfo, "shortcutInfo");
        if (notificationBuilder != null) {
            notificationBuilder.setShortcutId(shortcutInfo.getId());
        }
        if (notificationBuilder != null) {
            notificationBuilder.setLocusId(new LocusIdCompat(shortcutInfo.getId()));
        }
        List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(context);
        Intrinsics3.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
        boolean z2 = false;
        if (!(dynamicShortcuts instanceof Collection) || !dynamicShortcuts.isEmpty()) {
            Iterator<T> it = dynamicShortcuts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) it.next();
                Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (Intrinsics3.areEqual(shortcutInfoCompat.getId(), shortcutInfo.getId())) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            return;
        }
        ShortcutManagerCompat.pushDynamicShortcut(context, shortcutInfo);
    }

    public final SharedContent getSharedContent(Intent intent, boolean deleteExtras) {
        Uri uri;
        Intrinsics3.checkNotNullParameter(intent, "intent");
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
        ArrayList arrayListArrayListOf = null;
        if (charSequenceExtra == null || StringsJVM.isBlank(charSequenceExtra)) {
            charSequenceExtra = !(stringExtra == null || StringsJVM.isBlank(stringExtra)) ? stringExtra : null;
        }
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1173264947) {
                if (iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE")) {
                    arrayListArrayListOf = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                }
            } else if (action.equals("android.intent.action.SEND") && (uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) != null) {
                arrayListArrayListOf = Collections2.arrayListOf(uri);
            }
        }
        if (deleteExtras) {
            intent.removeExtra("android.intent.extra.TEXT");
            intent.removeExtra("android.intent.extra.SUBJECT");
            intent.removeExtra("android.intent.extra.STREAM");
        }
        return new SharedContent(charSequenceExtra, arrayListArrayListOf);
    }

    public final Observable<MGImagesBitmap.CloseableBitmaps> loadAdaptiveBitmaps(Sequence<String> iconUris) {
        Intrinsics3.checkNotNullParameter(iconUris, "iconUris");
        int iDpToPixels = DimenUtils.dpToPixels(72);
        int iDpToPixels2 = DimenUtils.dpToPixels(108);
        int iDpToPixels3 = DimenUtils.dpToPixels(18);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it = iconUris.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(new MGImagesBitmap.ImageRequest(it.next(), false));
        }
        Observable observableM11082A = MGImagesBitmap.getBitmaps(linkedHashSet).m11082A(new C66491(iDpToPixels, iDpToPixels2, iDpToPixels3));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "MGImagesBitmap\n        .…              }\n        }");
        return observableM11082A;
    }

    public final ShortcutInfoCompat toShortcutInfo(Context context, long channelId, CharSequence shortLabel, CharSequence longLabel, IconCompat icon, List<? extends Person> persons, int rank) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(shortLabel, "shortLabel");
        Intrinsics3.checkNotNullParameter(longLabel, "longLabel");
        Intrinsics3.checkNotNullParameter(persons, "persons");
        ShortcutInfoCompat.Builder categories = new ShortcutInfoCompat.Builder(context, String.valueOf(channelId)).setLocusId(new LocusIdCompat(String.valueOf(channelId))).setShortLabel(shortLabel).setLongLabel(longLabel).setIcon(icon).setIntent(IntentUtils.RouteBuilders.selectChannel$default(channelId, 0L, null, 6, null).setPackage(context.getPackageName())).setRank(rank).setLongLived(true).setCategories(Sets5.setOf((Object[]) new String[]{"com.discord.intent.category.DIRECT_SHARE_TARGET", "android.shortcut.conversation"}));
        Object[] array = persons.toArray(new Person[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ShortcutInfoCompat shortcutInfoCompatBuild = categories.setPersons((Person[]) array).build();
        Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompatBuild, "ShortcutInfoCompat.Build…ray())\n          .build()");
        return shortcutInfoCompatBuild;
    }

    public final void updateDirectShareTargets(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Observable<List<Tuples2<ChannelShortcutInfo, String>>> observableObserveChannelAndIconPairs = observeChannelAndIconPairs(context);
        Intrinsics3.checkNotNullExpressionValue(observableObserveChannelAndIconPairs, "observeChannelAndIconPairs(context)");
        Observable observableM11082A = ObservableExtensionsKt.computationLatest(observableObserveChannelAndIconPairs).m11082A(C66581.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "observeChannelAndIconPai…riPairs to it }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableM11082A), ShareUtils.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C66592(context), 60, (Object) null);
        Observable<Map<Long, Channel>> observableM11118y = StoreStream.INSTANCE.getChannels().observeGuildAndPrivateChannels().m11118y(C66603.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11118y, "StoreStream.getChannels(…ilter { it.isNotEmpty() }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y, 0L, false, 1, null)), ShareUtils.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C66614(context), 60, (Object) null);
    }

    private final ShortcutInfoCompat toShortcutInfo(Channel channel, Context context, IconCompat iconCompat, int i) {
        long id2 = channel.getId();
        String strM7679c = ChannelUtils.m7679c(channel);
        List<User> listM7683g = ChannelUtils.m7683g(channel);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listM7683g, 10));
        for (User user : listM7683g) {
            Person personBuild = new Person.Builder().setName(user.getUsername()).setKey(user.toString()).setBot(user.getIsBot()).build();
            Intrinsics3.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …\n                .build()");
            arrayList.add(personBuild);
        }
        return toShortcutInfo$default(this, context, id2, strM7679c, null, iconCompat, arrayList, i, 8, null);
    }
}
