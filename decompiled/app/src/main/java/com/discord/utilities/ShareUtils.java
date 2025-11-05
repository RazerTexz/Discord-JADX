package com.discord.utilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import b.d.b.a.a;
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
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.f0.q;
import d0.g0.t;
import d0.o;
import d0.t.n;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
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
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.functions.Func2;

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
            return m.areEqual(this.text, sharedContent.text) && m.areEqual(this.uris, sharedContent.uris);
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
            StringBuilder sbU = a.U("SharedContent(text=");
            sbU.append(this.text);
            sbU.append(", uris=");
            return a.L(sbU, this.uris, ")");
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<MGImagesBitmap.CloseableBitmaps, Observable<? extends MGImagesBitmap.CloseableBitmaps>> {
        public final /* synthetic */ int $fillMargins;
        public final /* synthetic */ int $fullBitmapSize;
        public final /* synthetic */ int $iconSize;

        /* compiled from: ShareUtils.kt */
        /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03231<T, R> implements b<Map.Entry<? extends String, ? extends Bitmap>, Observable<? extends Pair<? extends String, ? extends Bitmap>>> {
            public final /* synthetic */ RepresentativeColors $representativeColors;

            /* compiled from: ShareUtils.kt */
            /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C03241<T, R> implements b<Integer, Pair<? extends String, ? extends Bitmap>> {
                public final /* synthetic */ Bitmap $bitmap;
                public final /* synthetic */ String $url;

                public C03241(String str, Bitmap bitmap) {
                    this.$url = str;
                    this.$bitmap = bitmap;
                }

                @Override // j0.k.b
                public /* bridge */ /* synthetic */ Pair<? extends String, ? extends Bitmap> call(Integer num) {
                    return call2(num);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Pair<String, Bitmap> call2(Integer num) {
                    String str = this.$url;
                    MGImages mGImages = MGImages.INSTANCE;
                    Bitmap bitmap = this.$bitmap;
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    int i = anonymousClass1.$iconSize;
                    int i2 = anonymousClass1.$fullBitmapSize;
                    return o.to(str, mGImages.centerBitmapInTransparentBitmap(bitmap, i, i, i2, i2, anonymousClass1.$fillMargins, num != null ? num.intValue() : 0));
                }
            }

            public C03231(RepresentativeColors representativeColors) {
                this.$representativeColors = representativeColors;
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Observable<? extends Pair<? extends String, ? extends Bitmap>> call(Map.Entry<? extends String, ? extends Bitmap> entry) {
                return call2((Map.Entry<String, Bitmap>) entry);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Pair<String, Bitmap>> call2(Map.Entry<String, Bitmap> entry) {
                Observable<R> kVar;
                String key = entry.getKey();
                Bitmap value = entry.getValue();
                if (value.getWidth() <= 0 || value.getHeight() <= 0 || value.getPixel(0, 0) != 0) {
                    kVar = new k(0);
                } else {
                    RepresentativeColors.handleBitmap$default(this.$representativeColors, key, value, null, 4, null);
                    Observable<R> observableG = this.$representativeColors.observeRepresentativeColor(key).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                    m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
                    kVar = observableG.z().c0(2L, TimeUnit.SECONDS).M(ShareUtils$loadAdaptiveBitmaps$1$1$representativeColor$1.INSTANCE);
                }
                return kVar.G(new C03241(key, value));
            }
        }

        /* compiled from: ShareUtils.kt */
        /* renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements b<Map<String, ? extends Bitmap>, MGImagesBitmap.CloseableBitmaps> {
            public final /* synthetic */ MGImagesBitmap.CloseableBitmaps $iconBitmaps;

            public AnonymousClass2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                this.$iconBitmaps = closeableBitmaps;
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ MGImagesBitmap.CloseableBitmaps call(Map<String, ? extends Bitmap> map) {
                return call2((Map<String, Bitmap>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final MGImagesBitmap.CloseableBitmaps call2(Map<String, Bitmap> map) {
                this.$iconBitmaps.close();
                m.checkNotNullExpressionValue(map, "bitmaps");
                return new MGImagesBitmap.CloseableBitmaps(map, false);
            }
        }

        public AnonymousClass1(int i, int i2, int i3) {
            this.$iconSize = i;
            this.$fullBitmapSize = i2;
            this.$fillMargins = i3;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends MGImagesBitmap.CloseableBitmaps> call(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            return call2(closeableBitmaps);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends MGImagesBitmap.CloseableBitmaps> call2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            Observable<R> observableN = Observable.B(closeableBitmaps.entrySet()).n(new C03231(new RepresentativeColors()));
            m.checkNotNullExpressionValue(observableN, "Observable.from(iconBitm…        }\n              }");
            return ObservableExtensionsKt.toMap(observableN).G(new AnonymousClass2(closeableBitmaps));
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<List<? extends Channel>, List<? extends ChannelShortcutInfo>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<? extends ChannelShortcutInfo> call(List<? extends Channel> list) {
            return call2((List<Channel>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ChannelShortcutInfo> call2(List<Channel> list) {
            m.checkNotNullExpressionValue(list, "it");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                arrayList.add(new ChannelShortcutInfo((Channel) t, i, false));
                i = i2;
            }
            return arrayList;
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Map<Long, ? extends Channel>, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Map<Long, Channel> map) {
            m.checkNotNullExpressionValue(map, "it");
            return Boolean.valueOf(!map.isEmpty());
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, R> implements Func2<List<? extends ChannelShortcutInfo>, Map<Long, ? extends Channel>, List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>> {
        public final /* synthetic */ Context $context;

        public AnonymousClass3(Context context) {
            this.$context = context;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>> call(List<? extends ChannelShortcutInfo> list, Map<Long, ? extends Channel> map) {
            return call2((List<ChannelShortcutInfo>) list, (Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Pair<ChannelShortcutInfo, String>> call2(List<ChannelShortcutInfo> list, Map<Long, Channel> map) {
            m.checkNotNullExpressionValue(list, "directShareChannels");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((ChannelShortcutInfo) it.next()).getChannel().getId()));
            }
            Set set = u.toSet(arrayList);
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.$context);
            m.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            List<ChannelShortcutInfo> listPlus = u.plus((Collection) list, q.map(q.mapNotNull(q.filter(q.map(q.filter(u.asSequence(dynamicShortcuts), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$1.INSTANCE), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2.INSTANCE), new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$3(set)), new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$4(map)), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$5.INSTANCE));
            ArrayList arrayList2 = new ArrayList();
            for (ChannelShortcutInfo channelShortcutInfo : listPlus) {
                String forChannel$default = IconUtils.getForChannel$default(channelShortcutInfo.getChannel(), null, 2, null);
                Pair pair = forChannel$default != null ? o.to(channelShortcutInfo, forChannel$default) : null;
                if (pair != null) {
                    arrayList2.add(pair);
                }
            }
            return arrayList2;
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, Observable<? extends Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: ShareUtils.kt */
        /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03251<T, R> implements b<MGImagesBitmap.CloseableBitmaps, Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>> {
            public final /* synthetic */ List $channelAndIconUriPairs;

            public C03251(List list) {
                this.$channelAndIconUriPairs = list;
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps> call(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                return call2(closeableBitmaps);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Pair<List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps> call2(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                return o.to(this.$channelAndIconUriPairs, closeableBitmaps);
            }
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>> call(List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>> list) {
            return call2((List<Pair<ChannelShortcutInfo, String>>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Pair<List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps>> call2(List<Pair<ChannelShortcutInfo, String>> list) {
            m.checkNotNullExpressionValue(list, "channelAndIconUriPairs");
            return ShareUtils.INSTANCE.loadAdaptiveBitmaps(q.map(u.asSequence(list), ShareUtils$updateDirectShareTargets$1$uris$1.INSTANCE)).G(new C03251(list));
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$2, reason: invalid class name */
    public static final class AnonymousClass2 extends d0.z.d.o implements Function1<Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps> pair) throws IOException {
            invoke2((Pair<? extends List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps>) pair);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<? extends List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps> pair) throws IOException {
            List<Pair<ChannelShortcutInfo, String>> listComponent1 = pair.component1();
            MGImagesBitmap.CloseableBitmaps closeableBitmapsComponent2 = pair.component2();
            try {
                ShareUtils shareUtils = ShareUtils.INSTANCE;
                m.checkNotNullExpressionValue(listComponent1, "channelAndIconUriPairs");
                Context context = this.$context;
                m.checkNotNullExpressionValue(closeableBitmapsComponent2, "iconBitmaps");
                ShareUtils.access$updateDynamicShortcuts(shareUtils, listComponent1, context, closeableBitmapsComponent2);
                d0.y.b.closeFinally(closeableBitmapsComponent2, null);
            } finally {
            }
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements b<Map<Long, ? extends Channel>, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Map<Long, Channel> map) {
            m.checkNotNullExpressionValue(map, "it");
            return Boolean.valueOf(!map.isEmpty());
        }
    }

    /* compiled from: ShareUtils.kt */
    /* renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$4, reason: invalid class name */
    public static final class AnonymousClass4 extends d0.z.d.o implements Function1<Map<Long, ? extends Channel>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Channel> map) {
            invoke2((Map<Long, Channel>) map);
            return Unit.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke2(Map<Long, Channel> map) {
            boolean z2;
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.$context);
            ArrayList<ShortcutInfoCompat> arrayListA0 = a.a0(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            for (Object obj : dynamicShortcuts) {
                ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) obj;
                m.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (shortcutInfoCompat.isPinned()) {
                    String id2 = shortcutInfoCompat.getId();
                    m.checkNotNullExpressionValue(id2, "it.id");
                    z2 = !map.containsKey(Long.valueOf(Long.parseLong(id2)));
                }
                if (z2) {
                    arrayListA0.add(obj);
                }
            }
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayListA0, 10));
            for (ShortcutInfoCompat shortcutInfoCompat2 : arrayListA0) {
                m.checkNotNullExpressionValue(shortcutInfoCompat2, "it");
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

    private final Observable<List<Pair<ChannelShortcutInfo, String>>> observeChannelAndIconPairs(Context context) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableG = ObservableExtensionsKt.takeSingleUntilTimeout$default(companion.getChannels().observeDirectShareCandidates(context), 0L, false, 1, null).G(AnonymousClass1.INSTANCE);
        Observable<Map<Long, Channel>> observableY = companion.getChannels().observeGuildAndPrivateChannels().y(AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …ilter { it.isNotEmpty() }");
        return Observable.j(observableG, ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 1, null), new AnonymousClass3(context));
    }

    public static /* synthetic */ ShortcutInfoCompat toShortcutInfo$default(ShareUtils shareUtils, Context context, long j, CharSequence charSequence, CharSequence charSequence2, IconCompat iconCompat, List list, int i, int i2, Object obj) {
        return shareUtils.toShortcutInfo(context, j, charSequence, (i2 & 8) != 0 ? charSequence : charSequence2, (i2 & 16) != 0 ? null : iconCompat, (i2 & 32) != 0 ? n.emptyList() : list, (i2 & 64) != 0 ? 0 : i);
    }

    private final void updateDynamicShortcuts(List<Pair<ChannelShortcutInfo, String>> channelAndIconUriPairs, Context context, MGImagesBitmap.CloseableBitmaps iconBitmaps) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = channelAndIconUriPairs.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Boolean boolValueOf = Boolean.valueOf(((ChannelShortcutInfo) pair.component1()).isPinnedOnly());
            Object arrayList = linkedHashMap.get(boolValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(boolValueOf, arrayList);
            }
            List list = (List) arrayList;
            ChannelShortcutInfo channelShortcutInfo = (ChannelShortcutInfo) pair.component1();
            String str = (String) pair.component2();
            ShareUtils shareUtils = INSTANCE;
            Channel channel = channelShortcutInfo.getChannel();
            Bitmap bitmap = (Bitmap) iconBitmaps.get((Object) str);
            list.add(shareUtils.toShortcutInfo(channel, context, bitmap != null ? IconCompat.createWithAdaptiveBitmap(bitmap) : null, channelShortcutInfo.getRank()));
        }
        Object objEmptyList = linkedHashMap.get(Boolean.FALSE);
        if (objEmptyList == null) {
            objEmptyList = n.emptyList();
        }
        List list2 = (List) objEmptyList;
        Object objEmptyList2 = linkedHashMap.get(Boolean.TRUE);
        if (objEmptyList2 == null) {
            objEmptyList2 = n.emptyList();
        }
        ShortcutManagerCompat.setDynamicShortcuts(context, list2);
        ShortcutManagerCompat.updateShortcuts(context, (List) objEmptyList2);
    }

    public final void addShortcut(Context context, ShortcutInfoCompat shortcutInfo, NotificationCompat.Builder notificationBuilder) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(shortcutInfo, "shortcutInfo");
        if (notificationBuilder != null) {
            notificationBuilder.setShortcutId(shortcutInfo.getId());
        }
        if (notificationBuilder != null) {
            notificationBuilder.setLocusId(new LocusIdCompat(shortcutInfo.getId()));
        }
        List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(context);
        m.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
        boolean z2 = false;
        if (!(dynamicShortcuts instanceof Collection) || !dynamicShortcuts.isEmpty()) {
            Iterator<T> it = dynamicShortcuts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) it.next();
                m.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (m.areEqual(shortcutInfoCompat.getId(), shortcutInfo.getId())) {
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
        m.checkNotNullParameter(intent, "intent");
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
        ArrayList arrayListArrayListOf = null;
        if (charSequenceExtra == null || t.isBlank(charSequenceExtra)) {
            charSequenceExtra = !(stringExtra == null || t.isBlank(stringExtra)) ? stringExtra : null;
        }
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1173264947) {
                if (iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE")) {
                    arrayListArrayListOf = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                }
            } else if (action.equals("android.intent.action.SEND") && (uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) != null) {
                arrayListArrayListOf = n.arrayListOf(uri);
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
        m.checkNotNullParameter(iconUris, "iconUris");
        int iDpToPixels = DimenUtils.dpToPixels(72);
        int iDpToPixels2 = DimenUtils.dpToPixels(108);
        int iDpToPixels3 = DimenUtils.dpToPixels(18);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it = iconUris.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(new MGImagesBitmap.ImageRequest(it.next(), false));
        }
        Observable observableA = MGImagesBitmap.getBitmaps(linkedHashSet).A(new AnonymousClass1(iDpToPixels, iDpToPixels2, iDpToPixels3));
        m.checkNotNullExpressionValue(observableA, "MGImagesBitmap\n        .…              }\n        }");
        return observableA;
    }

    public final ShortcutInfoCompat toShortcutInfo(Context context, long channelId, CharSequence shortLabel, CharSequence longLabel, IconCompat icon, List<? extends Person> persons, int rank) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(shortLabel, "shortLabel");
        m.checkNotNullParameter(longLabel, "longLabel");
        m.checkNotNullParameter(persons, "persons");
        ShortcutInfoCompat.Builder categories = new ShortcutInfoCompat.Builder(context, String.valueOf(channelId)).setLocusId(new LocusIdCompat(String.valueOf(channelId))).setShortLabel(shortLabel).setLongLabel(longLabel).setIcon(icon).setIntent(IntentUtils.RouteBuilders.selectChannel$default(channelId, 0L, null, 6, null).setPackage(context.getPackageName())).setRank(rank).setLongLived(true).setCategories(n0.setOf((Object[]) new String[]{"com.discord.intent.category.DIRECT_SHARE_TARGET", "android.shortcut.conversation"}));
        Object[] array = persons.toArray(new Person[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ShortcutInfoCompat shortcutInfoCompatBuild = categories.setPersons((Person[]) array).build();
        m.checkNotNullExpressionValue(shortcutInfoCompatBuild, "ShortcutInfoCompat.Build…ray())\n          .build()");
        return shortcutInfoCompatBuild;
    }

    public final void updateDirectShareTargets(Context context) {
        m.checkNotNullParameter(context, "context");
        Observable<List<Pair<ChannelShortcutInfo, String>>> observableObserveChannelAndIconPairs = observeChannelAndIconPairs(context);
        m.checkNotNullExpressionValue(observableObserveChannelAndIconPairs, "observeChannelAndIconPairs(context)");
        Observable observableA = ObservableExtensionsKt.computationLatest(observableObserveChannelAndIconPairs).A(AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableA, "observeChannelAndIconPai…riPairs to it }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableA), ShareUtils.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(context), 60, (Object) null);
        Observable<Map<Long, Channel>> observableY = StoreStream.INSTANCE.getChannels().observeGuildAndPrivateChannels().y(AnonymousClass3.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…ilter { it.isNotEmpty() }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 1, null)), ShareUtils.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(context), 60, (Object) null);
    }

    private final ShortcutInfoCompat toShortcutInfo(Channel channel, Context context, IconCompat iconCompat, int i) {
        long id2 = channel.getId();
        String strC = ChannelUtils.c(channel);
        List<User> listG = ChannelUtils.g(channel);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listG, 10));
        for (User user : listG) {
            Person personBuild = new Person.Builder().setName(user.getUsername()).setKey(user.toString()).setBot(user.getIsBot()).build();
            m.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …\n                .build()");
            arrayList.add(personBuild);
        }
        return toShortcutInfo$default(this, context, id2, strC, null, iconCompat, arrayList, i, 8, null);
    }
}
